import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.lang.Math;
import java.awt.event.*;

public class newdonater extends JFrame implements ActionListener{
    JPanel p;
    JLabel heading,jname,jdob,jgender,jemail,jusername,jpassword,labeltext;
    JTextField textname,textemail,textusername;
    JPasswordField textpassword;
    JDateChooser dateChooser;   
    JRadioButton male,female;
    ButtonGroup bg;
    JButton create;
    JComboBox cb;
    Random ran;
    long random;
    Font f;



    newdonater(){
        setVisible(true);
        setBounds(400, 200, 900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        heading = new JLabel("New Donater");
        heading.setBounds(350, 90, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);


        ran = new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        labeltext = new JLabel("Application Form No. "+random);
        labeltext.setBounds(140, 20, 600, 40);
        labeltext.setFont(new Font("Raleway",Font.BOLD,38));
        p.add(labeltext);

        jname = new JLabel("Name");
        jname.setBounds(100, 140, 100, 30);
        jname.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jname);
        textname = new JTextField();
        textname.setBounds(300, 140, 300, 30);
        textname.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textname);

        jdob = new JLabel("Date of Birth");
        jdob.setBounds(100, 190, 200, 30);
        jdob.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jdob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 190, 300, 30);
        p.add(dateChooser);


        jgender =new JLabel("Gender");
        jgender.setBounds(100, 240, 100, 30);
        jgender.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jgender);
        male =new JRadioButton("Male");
        male.setBounds(300, 240, 60, 30);
        p.add(male);
        female =new JRadioButton("Female");
        female.setBounds(400, 240, 100, 30);
        p.add(female);
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        jemail = new JLabel("Email Address");
        jemail.setBounds(100, 290, 200, 30);
        jemail.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jemail);
        textemail = new JTextField();
        textemail.setBounds(300, 290, 300, 30);
        textemail.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textemail);

        jusername = new JLabel("Username");
        jusername.setBounds(100, 340, 100, 30);
        jusername.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jusername);
        textusername = new JTextField();
        textusername.setBounds(300, 340, 300, 30);
        textusername.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textusername);

        jpassword = new JLabel("Password");
        jpassword.setBounds(100, 390, 100, 30);
        jpassword.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jpassword);
        textpassword = new JPasswordField();
        textpassword.setBounds(300, 390, 300, 30);
        textpassword.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textpassword);

        JLabel labelasuser = new JLabel("Create As");
        labelasuser.setFont(new Font("Raleway",Font.BOLD,20));
        labelasuser.setBounds(100, 440, 100, 30);
        p.add(labelasuser);

        cb = new JComboBox();
        cb.setBounds(300, 440, 200, 30);
        cb.addItem("User");
        cb.addItem("Organizer");
        p.add(cb);

        create = new JButton("Create");
        create.setBounds(600, 500, 100, 30);
        create.setFont(new Font("Raleway",Font.BOLD,14));
        create.addActionListener(this);
        p.add(create);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno="" + random;
        String name=textname.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        
        
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        

        String email=textemail.getText();
        String username=textusername.getText();
        String password = new String(textpassword.getPassword());
        String useras=(String)cb.getSelectedItem();


        try {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your name");
            }
            else{
                Conn c=new Conn();
                String query="insert into Signup values('"+formno+"','"+name+"','"+dob+"','"+gender+"','"+email+"','"+username+"','"+password+"','"+useras+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                

            }
            
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }       
        public static void main(String[] args) {
            new newdonater();
        }
}
