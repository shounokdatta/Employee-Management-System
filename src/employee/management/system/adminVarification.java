package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.ResultSet;

public class adminVarification extends JFrame implements ActionListener {
    String email;
    JTextField OTP;

    JButton varify;
    JButton back;
    JButton sends;
    boolean compare;

    public static String generateOTP(int length) {
        if (length <= 0) throw new IllegalArgumentException("OTP length must be positive");

        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // digits 0-9
        }

        return otp.toString();
    }
    String originalOTP = generateOTP(7);

    adminVarification() {

        JLabel heading = new JLabel("ADMIN VARIFICATION");
        heading.setBounds(200, 30, 200, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading);


        JLabel otpOTN = new JLabel("OTP on ADMIN mail");
        otpOTN.setBounds(50, 100, 150, 30);
        add(otpOTN);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login");
            while (resultSet.next()) {
                email = resultSet.getString("email");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String maskedNo = "*****" + email.substring(7);  // Output: *****10

        JLabel displayPN = new JLabel(maskedNo);
        displayPN.setBounds(210, 100, 150, 30);
        add(displayPN);

        JLabel labelotp = new JLabel("OTP- ");
        labelotp.setBounds(150, 140, 150, 30);
        add(labelotp);

        OTP = new JTextField();
        OTP.setBounds(200, 140, 150, 30);
        add(OTP);


        sends = new JButton("Sends");
        sends.setBounds(400, 140, 150, 30);
        sends.setBackground(Color.BLACK);
        sends.setForeground(Color.white);
        sends.addActionListener(this);
        add(sends);

        varify = new JButton("varify");
        varify.setBounds(300, 200, 150, 30);
        varify.setBackground(Color.BLACK);
        varify.setForeground(Color.white);
        varify.addActionListener(this);
        add(varify);

        back = new JButton("Back");
        back.setBounds(100, 200, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(600, 300);
        setLocation(450, 200);
        setBackground(new Color(173, 216, 230)); // Light blue
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == varify) {
            String otp = OTP.getText();

             compare = originalOTP.equals(otp);
            if (compare) {
                JOptionPane.showMessageDialog(null, "OTP verified");
                new main_class();
                setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "OTP NOT verified");
            }


        } else if (e.getSource() == sends) {

            System.out.println(originalOTP);

            mailSender send = new mailSender();
            boolean result = send.mailSender(
                    "dattashounok11@gmail.com",
                    email,
                    "ONE TIME PASSWORD(OTP)",
                    "YOUR ONE TYPE PASSWORD(OTP):- "+originalOTP
            );

            sends.setText("RESEND");

            if (result) {
                System.out.println("mail sent");

            } else {
                System.out.println("mail not sent");
            }
        } else {
            new LOGIN();
            setVisible(false);
        }
    }


        public static void main(String[] args) {

            new adminVarification();
        }

}



