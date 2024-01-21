package customer.relationship.management;


import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddLead extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tfphone, tfadhaar, tfpan, tfnominee, tfpickuplocation, tfleaseperiod, tfemail;
    JDateChooser dcdob;
    JComboBox cbwarehouselocation;
    JLabel lblclientId;
    JButton add, back;
    
    AddLead() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Lead Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        
        
        JLabel labelphone = new JLabel("Phone Number");
        labelphone.setBounds(400, 150, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 150, 150, 30);
        add(tfphone);
        
        
        
        JLabel labeladhaar = new JLabel("Adhaar Card");
        labeladhaar.setBounds(50, 200, 150, 30);
        labeladhaar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladhaar);
        
        tfadhaar = new JTextField();
        tfadhaar.setBounds(200, 200, 150, 30);
        add(tfadhaar);
        
        
        
        JLabel labelpan = new JLabel("PAN Card");
        labelpan.setBounds(400, 200, 150, 30);
        labelpan.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpan);
        
        tfpan = new JTextField();
        tfpan.setBounds(600, 200, 150, 30);
        add(tfpan);
        
        
        
        JLabel labelnominee = new JLabel("Nominee Name");
        labelnominee.setBounds(50, 250, 150, 30);
        labelnominee.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelnominee);
        
        tfnominee = new JTextField();
        tfnominee.setBounds(200, 250, 150, 30);
        add(tfnominee);
        
        
        
        JLabel labelpickuplocation = new JLabel("Pickup Location");
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
        
        
            
        JLabel labelwarehouselocation = new JLabel("Warehouse Location");
        labelwarehouselocation.setBounds(400, 300, 150, 30);
        labelwarehouselocation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelwarehouselocation);
        
        String courses[] = {"Noida", "Delhi", "Gurgaon"};
        cbwarehouselocation = new JComboBox(courses);
        cbwarehouselocation.setBackground(Color.WHITE);
        cbwarehouselocation.setBounds(600, 300, 150, 30);
        add(cbwarehouselocation);
        
        
        
        JLabel labelleaseperiod = new JLabel("Lease Period");
        labelleaseperiod.setBounds(50, 350, 150, 30);
        labelleaseperiod.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelleaseperiod);
        
        tfleaseperiod = new JTextField();
        tfleaseperiod.setBounds(200, 350, 150, 30);
        add(tfleaseperiod);
        
        
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(400, 350, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 350, 150, 30);
        add(dcdob);
        
        
        
        JLabel labelclientId = new JLabel("Employee id");
        labelclientId.setBounds(50, 400, 150, 30);
        labelclientId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelclientId);
        
        lblclientId = new JLabel("" + number);
        lblclientId.setBounds(200, 400, 150, 30);
        lblclientId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblclientId);
        
        
        
        add = new JButton("Add Details");
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
            String name = tfname.getText();
            String phone = tfphone.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String nominee = tfnominee.getText();
            String pickuplocation = tfpickuplocation.getText();
            String leaseperiod = tfleaseperiod.getText();
            String email = tfemail.getText();
            String warehouselocation = (String) cbwarehouselocation.getSelectedItem();
            String pan = tfpan.getText();
            String adhaar = tfadhaar.getText();
            String clientId = lblclientId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into leads values('"+name+"', '"+phone+"', '"+dob+"', '"+nominee+"', '"+pickuplocation+"', '"+leaseperiod+"', '"+email+"', '"+warehouselocation+"', '"+pan+"', '"+adhaar+"', '"+clientId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new AddLead();
    }
}
