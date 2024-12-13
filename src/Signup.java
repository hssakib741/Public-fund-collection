import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.lang.Math;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{

    Container c;
    JLabel labeltext,personaldetails,jname,jdob,jgender,jemail,jusername,jpassword,labelasuser;
    JTextField textname,textemail,textusername;
    JPasswordField textpassword,textconfirmpassword;
    Random ran;
    long random;
    Font f;
    JDateChooser dateChooser;
    JRadioButton male,female;
    ButtonGroup bg;
    JButton create;
    JComboBox cb;

    public Signup(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 10, 850, 800);
        setVisible(true);
        setTitle("Signup");
        setLayout(null);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);



        f=new Font("Raleway",Font.BOLD,38);

        ran = new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        labeltext = new JLabel("Application Form No. "+random);
        labeltext.setBounds(140, 20, 600, 40);
        labeltext.setFont(f);
        c.add(labeltext);

        

        personaldetails = new JLabel("Personal Details");
        personaldetails.setBounds(140, 80, 600, 40);
        personaldetails.setFont(new Font("Raleway",Font.BOLD,25));
        c.add(personaldetails);

        jname = new JLabel("Name");
        jname.setBounds(100, 140, 100, 30);
        jname.setFont(new Font("Raleway",Font.BOLD,20));
        c.add(jname);
        textname = new JTextField();
        textname.setBounds(300, 140, 300, 30);
        textname.setFont(new Font("Raleway",Font.BOLD,14));
        c.add(textname);

        jdob = new JLabel("Date of Birth");
        jdob.setBounds(100, 190, 200, 30);
        jdob.setFont(new Font("Raleway",Font.BOLD,20));
        c.add(jdob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 190, 300, 30);
        c.add(dateChooser);


        jgender =new JLabel("Gender");
        jgender.setBounds(100, 240, 100, 30);
        jgender.setFont(new Font("Raleway",Font.BOLD,20));
        c.add(jgender);
        male =new JRadioButton("Male");
        male.setBounds(300, 240, 60, 30);
        c.add(male);
        female =new JRadioButton("Female");
        female.setBounds(400, 240, 100, 30);
        c.add(female);
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        jemail = new JLabel("Email Address");
        jemail.setBounds(100, 290, 200, 30);
        jemail.setFont(new Font("Raleway",Font.BOLD,20));
        c.add(jemail);
        textemail = new JTextField();
        textemail.setBounds(300, 290, 300, 30);
        textemail.setFont(new Font("Raleway",Font.BOLD,14));
        c.add(textemail);

        jusername = new JLabel("Username");
        jusername.setBounds(100, 340, 100, 30);
        jusername.setFont(new Font("Raleway",Font.BOLD,20));
        c.add(jusername);
        textusername = new JTextField();
        textusername.setBounds(300, 340, 300, 30);
        textusername.setFont(new Font("Raleway",Font.BOLD,14));
        c.add(textusername);

        jpassword = new JLabel("Password");
        jpassword.setBounds(100, 390, 100, 30);
        jpassword.setFont(new Font("Raleway",Font.BOLD,20));
        c.add(jpassword);
        textpassword = new JPasswordField();
        textpassword.setBounds(300, 390, 300, 30);
        textpassword.setFont(new Font("Raleway",Font.BOLD,14));
        c.add(textpassword);

        labelasuser = new JLabel("Create As");
        labelasuser.setFont(new Font("Raleway",Font.BOLD,20));
        labelasuser.setBounds(100, 440, 100, 30);
        c.add(labelasuser);

        cb = new JComboBox();
        cb.setBounds(300, 440, 200, 30);
        cb.addItem("User");
        cb.addItem("Organizer");
        c.add(cb);

        create = new JButton("Create");
        create.setBounds(600, 500, 100, 30);
        create.setFont(new Font("Raleway",Font.BOLD,14));
        create.addActionListener(this);
        c.add(create);

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
                new Login().setVisible(true);
            }
            
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }

    
    public static void main(String[] args) {
        new Signup();
    }

    
}
