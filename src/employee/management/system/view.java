package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view extends JFrame implements ActionListener {
    Choice choiceEMP;
    JTable table;
    JButton Search,print,update,back;
    view(){
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search=new JLabel("Search");
        search.setBounds(20,20,150,20);
        add(search);


        choiceEMP=new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMP.add(resultSet.getString("EMP_ID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table=new JTable();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);
        //Button
        Search=new JButton("Search");
        Search.setBounds(20,70,100,20);
        Search.addActionListener(this);
        add(Search);

        print=new JButton("Print");
        print.setBounds(150,70,100,20);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(280,70,100,20);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(400,70,100,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Search){
           String query="select * from employee where EMP_ID='"+choiceEMP.getSelectedItem()+"'";

           try{
               conn c=new conn();
               ResultSet resultSet=c.statement.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(resultSet));

           }catch(Exception e1){
               e1.printStackTrace();
           }
        }
        else if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==update){


        }
        else{
            setVisible(false);
            new main_class();
        }

    }

    public static void main(String[] args) {
        new view();
    }
}
