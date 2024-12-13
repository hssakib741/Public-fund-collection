
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class donatenow extends JFrame implements ActionListener{
    JPanel p;
    JLabel heading,jamount,name,jname,jevent;
    JTextField textamount,textname,textevent;
    JButton donate,back;

    public donatenow() {
        super("Donate Now");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 500);
        setVisible(true);

        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        

        heading = new JLabel("Donate Now");
        heading.setBounds(250, 50, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        name=new JLabel("Name");
        name.setBounds(100, 100, 100, 30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(name);

        jamount=new JLabel("Amount");
        jamount.setBounds(100, 140, 100, 30);
        jamount.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jamount);

        jevent=new JLabel("Event");
        jevent.setBounds(100, 180, 100, 30);
        jevent.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jevent);

        
        
        textname = new JTextField();
        textname.setBounds(250, 100, 200, 30);
        textname.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textname);    


        textamount = new JTextField();
        textamount.setBounds(250, 140, 200, 30);
        textamount.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textamount);

        textevent = new JTextField();
        textevent.setBounds(250, 180, 200, 30);
        textevent.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(textevent);

        jamount = new JLabel("Amount");
        jamount.setBounds(100, 140, 100, 30);
        jamount.setFont(new Font("Raleway",Font.BOLD,20));
        p.add(jamount);

        donate = new JButton("Donate");
        donate.setBounds(250, 300, 200, 30);
        donate.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(donate);
        donate.addActionListener(this);

        


        back = new JButton("Back");
        back.setBounds(250, 250, 200, 30);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        p.add(back);
        back.addActionListener(this);

    }

    

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==donate){
            String amount = textamount.getText();
            String name = textname.getText();
            String event=textevent.getText();

            try{
                Conn c1 = new Conn();
                String q = "insert into amount1 values('"+name+"','"+amount+"','"+event+"')";
                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Donation is Successful");
                this.setVisible(false);
                new Dashboardclient("", "");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            this.setVisible(false);
            new Dashboardclient("", "");
        }
    }

    
           
    
    public static void main(String[] args) {
        new donatenow();
    }
}


