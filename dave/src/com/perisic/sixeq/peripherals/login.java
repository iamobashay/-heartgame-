package com.perisic.sixeq.peripherals;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 387);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(227, 61, 327, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textField.getText();
				String password  = passwordField.getText();
	             try          
				
				{
					 Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/heart_gamedb","root","");
					 Statement stat = con.createStatement();					 
					 String sql = "select * from userid where username='"+username+"' and password = '"+password+"'";
                     ResultSet rs = stat.executeQuery(sql);  
					
                     if(rs.next()) {
                    	  
                        JOptionPane.showMessageDialog(null,"Your Login was Successful!!", "Authentication", JOptionPane.INFORMATION_MESSAGE);
    				 	dispose();	
    				 	GameGUI myGUI = new GameGUI();
    					myGUI.setVisible(true);;
    				    myGUI.setLocationRelativeTo(null);
    					
                     }else {
                    	 JOptionPane.showMessageDialog(null,"Invalid Login Details", "Authentication", JOptionPane.INFORMATION_MESSAGE);
                    	 textField.setText("");
            			 passwordField.setText("");
                	     con.close();
                     }
                   
				
				  }
						 catch(Exception y){
				         System.out.print(y);
				         
								    	
						 }	
				
			}
		});
		btnNewButton.setBounds(438, 227, 116, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				register frame = new register();
			    frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		btnNewButton_1.setBounds(227, 227, 122, 55);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 59, 157, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 163, 157, 41);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 157, 325, 47);
		contentPane.add(passwordField);
	}
}
