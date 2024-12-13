import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Dashboardclient extends JFrame implements ActionListener{
    ImageIcon i1,i2,i3,donation1,donation2;
    JLabel label,labelwelcome,labeldonate;
    JMenuBar mb;
    JButton buttondonate;
    String atype,form;
    Dashboardclient(String atype,String form){
        this.atype=atype;
        this.form=form;
        setTitle("Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fund.jpg"));
        i2= new ImageIcon(i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        i3=new ImageIcon(i2.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        label = new JLabel(i3);
        add(label);

        //Menu Bar Start
        mb = new JMenuBar();
        setJMenuBar(mb);
        setLayout(new FlowLayout());

        JMenu m1 = new JMenu("Master");
        
        JMenuItem nc = new JMenuItem("New Client");
        nc.setFont(new Font("monospaced",Font.PLAIN,12));
        nc.setBackground(Color.WHITE);
        nc.setForeground(Color.BLACK);
        nc.setMnemonic('D');
        nc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        nc.addActionListener(this);
        m1.add(nc);

        JMenuItem details = new JMenuItem("Donation Details");
        details.setFont(new Font("monospaced",Font.PLAIN,12));
        details.setBackground(Color.WHITE);
        details.setForeground(Color.BLACK);
        details.setMnemonic('D');
        details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        details.addActionListener(this);
        m1.add(details);

        

        JMenuItem dd = new JMenuItem("Deposits Details");
        dd.setFont(new Font("monospaced",Font.PLAIN,12));
        dd.setBackground(Color.WHITE);
        dd.setForeground(Color.BLACK);
        dd.setMnemonic('N');
        dd.addActionListener(this);
        dd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        m1.add(dd);

        JMenu info = new JMenu("Info");
        
        

        JMenuItem vi = new JMenuItem("View Information");
        vi.setFont(new Font("monospaced",Font.PLAIN,12));
        vi.setBackground(Color.WHITE);
        vi.setForeground(Color.BLACK);
        vi.setMnemonic('L');
        vi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        vi.addActionListener(this);
        info.add(vi);

        JMenu user = new JMenu("User");
        
        JMenuItem dn = new JMenuItem("Donate Now");
        dn.setFont(new Font("monospaced",Font.PLAIN,12));
        dn.setBackground(Color.WHITE);
        dn.setForeground(Color.BLACK);
        dn.setMnemonic('B');
        dn.addActionListener(this);
        dn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        user.add(dn);

        

        //JMenu report = new JMenu("Report");
        
        

        JMenu exit=new JMenu("Exit");
        
        JMenuItem ex=new JMenuItem("Exit");
        ex.setFont(new Font("monospaced",Font.PLAIN,12));
        ex.setBackground(Color.WHITE);
        ex.setForeground(Color.BLACK);
        ex.setMnemonic('E');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        exit.add(ex);
        ex.addActionListener(this);
        //Menu Bar End

        
        
        

        
        

        if(atype.equals("Organizer")){
            mb.add(m1); 
        }
        else{
        mb.add(exit);
        //mb.add(report); 
        mb.add(user); 
        mb.add(info);

        labelwelcome=new JLabel("Welcome to PFCCW");
        labelwelcome.setBounds(400, 100, 600, 100);
        labelwelcome.setFont(new Font("ARIAL",Font.BOLD,40));
        labelwelcome.setForeground(Color.WHITE);
        label.add(labelwelcome);

        labeldonate=new JLabel("Click Here To Donate Now");
        labeldonate.setBounds(450, 150, 300, 100);
        labeldonate.setFont(new Font("ARIAL",Font.BOLD,20));
        labeldonate.setForeground(Color.WHITE);
        label.add(labeldonate);

        
        
        buttondonate=new JButton("Donate Now");
        buttondonate.setBounds(490, 220, 120, 30);
        label.add(buttondonate);
        buttondonate.addActionListener(this);

        }
        //mb.add(report);
        mb.add(exit);


    }

    

    public void actionPerformed (ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Client")){
            new newdonater();
        }

        
        
        else if(msg.equals("Deposits Details")){
            new DepositsDetails();   
        } 
        
        else if(msg.equals("View Information")){
            new viewinfo(form);
            
        }
        else if(msg.equals("Donate Now")){
            new donatenow();
        }
        else if(msg.equals("Donation Details")){
            new donationdetails();
        }
        
        else if(msg.equals("Exit")){
            new Login();

            setVisible(false);
        }

    }
    

    public static void main(String[] args) {
        new Dashboardclient("", "");
    }
}
