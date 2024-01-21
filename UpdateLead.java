package customer.relationship.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateLead extends JFrame implements ActionListener{
    
    JTextField tfphone, tfadhaar, tfpan, tfnominee, tfemail, tfpickuplocation, tfleaseperiod, tfwarehouselocation;
    JLabel lblclientId;
    JButton add, back;
    String clientId;
    
    UpdateLead(String clientId) {
        this.clientId = clientId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Lead Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        
        
        JLabel labelphone = new JLabel("Phone Number");
        labelphone.setBounds(400, 150, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 150, 150, 30);
        add(tfphone);
        
        
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        
        
        JLabel labelpan = new JLabel("PAN Number");
        labelpan.setBounds(400, 200, 150, 30);
        labelpan.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpan);
        
        tfpan = new JTextField();
        tfpan.setBounds(600, 200, 150, 30);
        add(tfpan);
        
        
        
        JLabel labelnominee = new JLabel("Nominee");
        labelnominee.setBounds(50, 250, 150, 30);
        labelnominee.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelnominee);
        
        tfnominee = new JTextField();
        tfnominee.setBounds(200, 250, 150, 30);
        add(tfnominee);
        
        
        
        JLabel labelpickuplocation = new JLabel("Phone");
        labelpickuplocation.setBounds(400, 250, 150, 30);
        labelpickuplocation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpickuplocation);
        
        tfpickuplocation = new JTextField();
        tfpickuplocation.setBounds(600, 250, 150, 30);
        add(tfpickuplocation);
        
        
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        
        
        JLabel labelleaseperiod = new JLabel("Lease Period");
        labelleaseperiod.setBounds(400, 300, 150, 30);
        labelleaseperiod.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelleaseperiod);
        
        tfleaseperiod = new JTextField();
        tfleaseperiod.setBounds(600, 300, 150, 30);
        add(tfleaseperiod);
        
        
        
        JLabel labelwarehouselocation = new JLabel("Warehouse Location");
        labelwarehouselocation.setBounds(50, 350, 150, 30);
        labelwarehouselocation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelwarehouselocation);
        
        tfwarehouselocation = new JTextField();
        tfwarehouselocation.setBounds(200, 350, 150, 30);
        add(tfwarehouselocation);
        
        
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfadhaar = new JTextField();
        tfadhaar.setBounds(600, 350, 150, 30);
        add(tfadhaar);
        
        
        
        JLabel labelclientId = new JLabel("Client id");
        labelclientId.setBounds(50, 400, 150, 30);
        labelclientId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelclientId);
        
        lblclientId = new JLabel();
        lblclientId.setBounds(200, 400, 150, 30);
        lblclientId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblclientId);
        
        try {
            Conn c = new Conn();
            String query = "select * from leads where clientId = '"+clientId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tfphone.setText(rs.getString("phone"));
                lbldob.setText(rs.getString("dob"));
                tfleaseperiod.setText(rs.getString("leaseperiod"));
                tfpan.setText(rs.getString("pan"));
                tfnominee.setText(rs.getString("nominee"));
                tfemail.setText(rs.getString("email"));
                tfpickuplocation.setText(rs.getString("pickuplocation"));
                tfwarehouselocation.setText(rs.getString("warehouselocation"));
                tfadhaar.setText(rs.getString("aadhar"));
                lblclientId.setText(rs.getString("clientId"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String phone = tfphone.getText();
            String pan = tfpan.getText();
            String nominee = tfnominee.getText();
            String pickuplocation = tfpickuplocation.getText();
            String leaseperiod = tfleaseperiod.getText();
            String email = tfemail.getText();
            String adhaar = tfadhaar.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update leads set phone = '"+phone+"', pan = '"+pan+"', nominee = '"+nominee+"', pickuplocation = '"+pickuplocation+"', leaseperiod =  '"+leaseperiod+"', email = '"+email+"', adhaar = '"+adhaar+"' where clientId = '"+clientId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateLead("");
    }
}