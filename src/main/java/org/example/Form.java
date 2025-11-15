package org.example;
//import Javax.swing.JTree;
import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

public class Form {

    JFrame frame;
    JPanel panel;
    JTextField Firstname, Email_Address;
    JPasswordField Password;
    JLabel FirstnameLab, EmailLabel, DateOfBirthLab, PasswordLa, DepartmentLab;
    JComboBox<String> Department;
    JCalendar DateOfBirth;
    JButton button;
    JButton resetButton;
    String [] Place= {"Department","Human Resource", "General Direction"};

    public Form() {
        this.cFrame();
    }

    public JFrame cFrame(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Registration Form");
        frame.setSize(800, 800);
        frame.add(this.pannel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public JTree MyTree(){
        DefaultMutableTreeNode rootnode = new DefaultMutableTreeNode("Organization Structure");
        rootnode.add(new DefaultMutableTreeNode("Human Resource"));
        rootnode.add(new DefaultMutableTreeNode("General Direction"));
        JTree Structure = new JTree(rootnode);
        Structure.setBounds(450, 30, 300, 400);
        return Structure;
    }


    public JPanel pannel(){
        panel = new JPanel();
        panel.setLayout(null);

        panel.add(this.FirstnameLabel());
        panel.add(this.FirstnameField());
        panel.add(this.EmailLabel());
        panel.add(this.EmailField());
        panel.add(this.PasswordLabel());
        panel.add(this.PasswordField());
        panel.add(this.DepartmentLabel());
        panel.add(this.Department());
        panel.add(this.DatEOfBirthLabel());
        panel.add(this.DateOfBirthCal());
        panel.add(this.CreateButton());
        panel.add(this.createReset());
        panel.add(this.MyTree());

        return panel;
    }

    public JLabel FirstnameLabel(){
        FirstnameLab = new JLabel("FirstName");
        FirstnameLab.setBounds(20, 30, 100, 30);
        return FirstnameLab;
    }

    public JTextField FirstnameField(){
        Firstname = new JTextField();
        Firstname.setBounds(130, 30, 200, 30);
        return Firstname;
    };

    public JLabel EmailLabel(){
        EmailLabel = new JLabel("Email Address");
        EmailLabel.setBounds(20, 70, 100, 30);
        return EmailLabel;
    }

    public JTextField EmailField(){
        Email_Address = new JTextField();
        Email_Address.setBounds(130, 70, 200, 30);
        return Email_Address;
    };

    public JLabel PasswordLabel() {
        PasswordLa = new JLabel("Password");
        PasswordLa.setBounds(20, 110, 100, 30);
        return PasswordLa;
    }

    public JPasswordField PasswordField(){
        Password = new JPasswordField();
        Password.setBounds(130, 110, 200, 30);
        return Password;
    }

    public JLabel DepartmentLabel() {
        DepartmentLab = new JLabel("Department");
        DepartmentLab.setBounds(20, 150, 100, 30);
        return DepartmentLab;
    }

    public JComboBox<String> Department() {
        Department = new JComboBox<>(Place);
        Department.setBounds(130, 150, 200, 30);
        return Department;
    }

    public JLabel DatEOfBirthLabel() {
        DateOfBirthLab = new JLabel("Date of Birth");
        DateOfBirthLab.setBounds(20, 190, 100, 30);
        return DateOfBirthLab;
    }

    public JCalendar DateOfBirthCal() {
        DateOfBirth = new JCalendar();
        DateOfBirth.setBounds(130, 190, 250, 200);
        return DateOfBirth;
    }

    public JButton CreateButton() {
        button = new JButton("Submit");
        button.setBounds(130, 420, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    String firstName = Firstname.getText();
                    String address = Email_Address.getText();
                    String password = new String(Password.getPassword());

                    if (firstName.trim().isEmpty() || address.trim().isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog( panel,"All fields are required");
                    } else {
                        JOptionPane.showMessageDialog(panel,"Registration Successful!\n"
                                        + "Address: " + address + "\n"
                                        + "FirstName: " + firstName
                                , "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        return button;
    }

    public JButton createReset() {
        resetButton = new JButton("Reset");
        resetButton.setBounds(240, 420, 90, 30);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == resetButton) {
                    Firstname.setText("");
                    Email_Address.setText("");
                    Password.setText("");
                    DateOfBirth.setDate(new java.util.Date());
                }
            }
        });
        return resetButton;
    }


}
