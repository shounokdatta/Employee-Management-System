package employee.management.system;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class mailSender{
    public boolean mailSender(String from, String to, String subject, String body) {
        System.out.println(from);

        System.out.println("sendEmail called");
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");  // ✅ Use STARTTLS for port 587
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String username = from;
        String password = "ipdy pgjj nzei wfux"; // Use App Password, not Gmail password

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Sent message successfully");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static void main(String[] args) {
        new mailSender();
    }
}
