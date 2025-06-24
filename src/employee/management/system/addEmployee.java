package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addEmployee extends JFrame implements ActionListener {

        JTextField tName,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
        JDateChooser tDOB;
        JButton add,back;
        JComboBox Boxeducation;
        int EMP_ID=1;



    addEmployee() {

            getContentPane().setBackground(new Color(163,255,188));


            JLabel heading =new JLabel("ADD EMPLOYEE INFORMATION");
            heading.setBounds(190,30,700,50);
            heading.setFont(new Font("serif",Font.BOLD,36));
            add(heading);

            //the format of the form.
            //my name
            JLabel name=new JLabel("Name :");
            name.setBounds(50,150,150,50);
            name.setFont(new Font("serif",Font.BOLD,20));
            add(name);

            tName = new JTextField();
            tName.setBounds(200,150,150,50);
            tName.setBackground(new Color(177,252,197));
            add(tName);
//father name
            JLabel fname=new JLabel("Father Name :");
            fname.setBounds(50,250,150,50);
            fname.setFont(new Font("serif",Font.BOLD,20));
            add(fname);

            tfname = new JTextField();
            tfname.setBounds(200,250,150,50);
            tfname.setBackground(new Color(177,252,197));
            add(tfname);

//address
            JLabel addr=new JLabel("Address :");
            addr.setBounds(50,350,150,50);
            addr.setFont(new Font("serif",Font.BOLD,20));
            add(addr);

            taddress = new JTextField();
            taddress.setBounds(200,350,150,50);
            taddress.setBackground(new Color(177,252,197));
            add(taddress);

//phone no
            JLabel phoneno=new JLabel("Phone Number :");
            phoneno.setBounds(50,450,150,50);
            phoneno.setFont(new Font("serif",Font.BOLD,20));
            add(phoneno);

            tphone = new JTextField();
            tphone.setBounds(200,450,150,50);
            tphone.setBackground(new Color(177,252,197));
            add(tphone);

//DOB
            JLabel dob=new JLabel("DOB :");
            dob.setBounds(50,550,150,30);
            dob.setFont(new Font("serif",Font.BOLD,20));
            add(dob);

            tDOB=new JDateChooser();
            tDOB.setBounds(200,550,150,30);
            tDOB.setBackground(new Color(177,252,197));
            add(tDOB);

//salary
            JLabel salary=new JLabel("Salary :");
            salary.setBounds(400,150,150,50);
            salary.setFont(new Font("serif",Font.BOLD,20));
            add(salary);

            tsalary = new JTextField();
            tsalary.setBounds(550,150,150,50);
            tsalary.setBackground(new Color(177,252,197));
            add(tsalary);

//addher
            JLabel adhar=new JLabel("Addhar :");
            adhar.setBounds(400,250,150,50);
            adhar.setFont(new Font("serif",Font.BOLD,20));
            add(adhar);

            taadhar = new JTextField();
            taadhar.setBounds(550,250,150,50);
            taadhar.setBackground(new Color(177,252,197));
            add(taadhar);

            //email
            JLabel email=new JLabel("Email :");
            email.setBounds(400,350,150,50);
            email.setFont(new Font("serif",Font.BOLD,20));
            add(email);

            temail = new JTextField();
            temail.setBounds(550,350,150,50);
            temail.setBackground(new Color(177,252,197));
            add(temail);
//degignation
            JLabel deg= new JLabel("Designation :");
            deg.setBounds(400,450,150,50);
            deg.setFont(new Font("serif",Font.BOLD,20));
            add(deg);

            tdesignation = new JTextField();
            tdesignation.setBounds(550,450,150,50);
            tdesignation.setBackground(new Color(177,252,197));
            add(tdesignation);
//education:-
            JLabel education = new JLabel("Education :");
            education.setBounds(400,550,150,30);
            education.setFont(new Font("SAN_SERIF", Font.BOLD,20));
            add(education);

            String items[] = {"BBA","B.Tech","BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
            Boxeducation = new JComboBox(items);
            Boxeducation.setBackground(new Color(177,252,197));
            Boxeducation.setBounds(550,550,150,30);
            add(Boxeducation);

//buttons:
            add=new JButton("ADD");
            add.setBounds(850,250,150,50);
            add.setBackground(Color.black);
            add.setForeground(Color.white);
            add.addActionListener(this);
            add(add);

            back=new JButton("BACK");
            back.setBounds(850,350,150,50);
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            back.addActionListener(this);
            add(back);
    //frame
            setSize(900, 700);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLayout(null);
            setLocation(300, 50);
            setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){

            String name= tName.getText();
            String Fname= tfname.getText();
            String DOB= ((JTextField) tDOB.getDateEditor().getUiComponent()).getText();
            String salary= tsalary.getText();
            String addr=taadhar.getText();
            String address= taddress.getText();
            String phoneno= tphone.getText();
            String email= temail.getText();
            String designation= tdesignation.getText();
            String education= Boxeducation.getSelectedItem().toString();
             System.out.println(name+Fname+DOB+salary+address+phoneno+email+designation+education);

             try{
                 conn c=new conn();
                 String query = "INSERT INTO Employee (EMP_ID, name, Fname, DOB, salary, address, phoneno, email, designation, addharNo, education) " +
                         "VALUES ('" + 101+ "','" + name + "','" + Fname + "','" + DOB + "','" + salary + "','" + address + "','" + phoneno + "','" + email + "','" + designation + "','" + addr + "','" + education + "')";

                 c.statement.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                 setVisible(false);


             }catch(Exception ex){
                 ex.printStackTrace();
            }


        }
        else{
            try{
                setVisible(false);
                new main_class();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
            new addEmployee();
        }
    }

