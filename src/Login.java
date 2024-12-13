import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    JLabel labeltext, labeluser, labelpass,loginimglabel,labelasuser;
    Container c;
    Font f;
    JTextField textuser;
    JPasswordField textpass;
    JButton buttonlogin, buttonclear, buttonsignup;
    ImageIcon loginimg;
    JComboBox cb;
    
    public Login()
    {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 500);
        setVisible(true);
        setTitle("Login");

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        

        f=new Font("Arial",Font.BOLD,30);

        

        labeltext = new JLabel("Welcome To PFCCW");
        labeltext.setBounds(350, 50, 300, 50);
        labeltext.setFont(f);
        c.add(labeltext);

        labeluser = new JLabel("Username");
        labeluser.setBounds(350, 150, 100, 30);
        c.add(labeluser);

        labelpass = new JLabel("Password");
        labelpass.setBounds(350, 200, 100, 30);
        c.add(labelpass);

        labelasuser = new JLabel("Loggin As");
        labelasuser.setBounds(350, 250, 100, 30);
        c.add(labelasuser);

        cb = new JComboBox();
        cb.setBounds(450, 250, 200, 30);
        cb.addItem("User");
        cb.addItem("Organizer");
        c.add(cb);

        textuser = new JTextField();
        textuser.setBounds(450, 150, 200, 30);
        c.add(textuser);

        textpass= new JPasswordField();
        textpass.setBounds(450, 200, 200, 30);
        c.add(textpass);

        buttonlogin = new JButton("Login");
        buttonlogin.setBounds(450, 300, 80, 30);
        buttonlogin.setBackground(Color.BLACK);
        buttonlogin.setForeground(Color.WHITE);
        buttonlogin.addActionListener(this);
        c.add(buttonlogin);

        buttonclear = new JButton("Clear");
        buttonclear.setBounds(540, 300, 80, 30);
        buttonclear.setBackground(Color.BLACK);
        buttonclear.setForeground(Color.WHITE);
        buttonclear.addActionListener(this);
        c.add(buttonclear);

        buttonsignup = new JButton("Sign Up");
        buttonsignup.setBounds(500, 340, 80, 30);
        buttonsignup.setBackground(Color.BLACK);
        buttonsignup.setForeground(Color.WHITE);
        buttonsignup.addActionListener(this);
        c.add(buttonsignup);


    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonlogin)
        {
            String username = textuser.getText();
            String password = new String(textpass.getPassword());
            String useras = cb.getSelectedItem().toString();
            try{
                Conn c=new Conn();
                String query="select * from Signup where username='"+username+"' and password='"+password+"' and useras='"+useras+"'";
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next())
                {
                    setVisible(false);
                    String form=rs.getString("formo");
                    new Dashboardclient(useras,form);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    
                }
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==buttonclear)
        {
            textuser.setText("");
            textpass.setText("");
        }
        
        else if(e.getSource()==buttonsignup)
        {
            setVisible(false);
            new Signup().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}