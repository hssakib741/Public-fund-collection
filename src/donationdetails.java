import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // this is for the table

public class donationdetails extends JFrame implements ActionListener{
    Container c;
    Choice username,appno;
    JLabel labeltext, labeluser,labelmonth;
    JTable table;
    JScrollPane sp;
    JButton buttonsearch,buttonback;
    donationdetails(){
        super("Donation Details");
        setBounds(400, 100, 700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        labeluser = new JLabel("Search by Username");
        labeluser.setBounds(20, 20, 150, 20);
        c.add(labeluser);

        username = new Choice();
        username.setBounds(180, 20, 150, 20);
        c.add(username);
        
        try{
            
           
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from amount1");
            while(rs.next()){
                username.add(rs.getString("username"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }



        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from amount1") ;
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        sp = new JScrollPane(table);
        sp.setBounds(20, 100, 650, 600);
        c.add(sp);
        
        buttonsearch = new JButton("Search");
        buttonsearch.setBounds(20, 70, 80, 20);
        c.add(buttonsearch);
        buttonsearch.addActionListener(this);

        buttonback = new JButton("Back");
        buttonback.setBounds(110, 70, 80, 20);
        c.add(buttonback);
        buttonback.addActionListener(this);
  
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == buttonsearch){
            String query = "select * from amount1 where name = '"+username.getSelectedItem()+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }    
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == buttonback){
            new DepositsDetails();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new donationdetails();
    }
}
