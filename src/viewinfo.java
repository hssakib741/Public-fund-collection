 import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class viewinfo extends JFrame implements ActionListener{
    Container c;
    JButton cancel;
    ImageIcon i1,i2,i3;
    JLabel heading,labelname,name,labelformnumber,formnumber,labelemail,email,labelgender,gender,labeldob,dob;
    public viewinfo(String form) {
        super("View Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 150, 850, 650);
        setVisible(true);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        heading = new JLabel("View Information");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));    
        c.add(heading);

        labelname = new JLabel("Name");
        labelname.setBounds(70, 80, 100, 20);  
        c.add(labelname);

        name = new JLabel("");
        name.setBounds(250, 80, 100, 20);  
        c.add(name);

        labelformnumber = new JLabel("Form No.");
        labelformnumber.setBounds(70, 140, 100, 20);  
        c.add(labelformnumber);

        formnumber= new JLabel("");
        formnumber.setBounds(250, 140, 100, 20);  
        c.add(formnumber);

        labelemail = new JLabel("Email ID :");
        labelemail.setBounds(70, 200, 200, 20);  
        c.add(labelemail);

        email= new JLabel("");
        email.setBounds(250, 200, 100, 20);  
        c.add(email);

        labelgender = new JLabel("Gender :");
        labelgender.setBounds(70, 260, 100, 20);  
        c.add(labelgender);

        gender= new JLabel("");
        gender.setBounds(250, 260, 100, 20);  
        c.add(gender);

        labeldob = new JLabel("Date Of Birth :");
        labeldob.setBounds(70, 320, 100, 20);
        c.add(labeldob);

        dob= new JLabel("");
        dob.setBounds(250, 320, 100, 20);
        c.add(dob);

        



        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Signup where formo='"+form+"'");
            
            while(rs.next()){
                name.setText(rs.getString("name"));
                formnumber.setText(rs.getString("formo"));
                email.setText(rs.getString("email"));  
                gender.setText(rs.getString("gender"));  
                dob.setText(rs.getString("dob"));
            }
       
        }
        catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(350, 340, 100, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        c.add(cancel);
        cancel.addActionListener(this);

        i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(30, 350, 600, 300);
        c.add(image);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            this.setVisible(false);
        }
    }       
    public static void main(String[] args) {
        new viewinfo("");
    }
}
