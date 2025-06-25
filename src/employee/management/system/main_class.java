package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class main_class extends JFrame {
        main_class(){
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
            Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel img = new JLabel(i3);
            img.setBounds(0,0,1120,630);
            add(img);

            JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
            heading.setBounds(305,155,600,40);
            heading.setFont(new Font("Railway",Font.BOLD, 25));
            img.add(heading);

            JButton add= new JButton("ADD EMPLOYEE");
            add.setLayout(null);
            add.setBounds(335,270,150,40);
            add.setForeground(Color.white);
            add.setBackground(Color.black);
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                     new addEmployee();
                }
            });
                    
            img.add(add);

            JButton view= new JButton("view EMPLOYEE");
            view.setLayout(null);
            view.setBounds(565,270,150,40);
            view.setForeground(Color.white);
            view.setBackground(Color.black);
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new view();
                }
            });
            img.add(view);


            JButton rem= new JButton("REMOVE EMPLOYEE");
            rem.setLayout(null);
            rem.setBounds(400,370,250,40);
            rem.setForeground(Color.white);
            rem.setBackground(Color.black);
            rem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new removeEmployee();

                }
            });
            img.add(rem);

            setSize(1120,630);
            setLocation(100,50);
            setLayout(null);
            setVisible(true);

        }
        public static void main(String[] args) {
            new main_class();
        }
}
