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

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class register extends JFrame {

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
					register frame = new register();
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
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(285, 94, 253, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password  = passwordField.getText();
			  
				try
				
				{
					 Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/heart_gamedb","root","");
					 Statement stat = con.createStatement();
					 String insertQuery = "insert into userid values(null, '"+username+"', '"+password+"')";
					 stat.executeUpdate(insertQuery);  
					 JOptionPane.showMessageDialog(null," Your Details is Successful entered !!", "Authentication", JOptionPane.INFORMATION_MESSAGE);
				 	 dispose();	
					 login frame = new login();
					 frame.setLocationRelativeTo(null);
					 frame.setVisible(true);
				
				  }
						 catch(Exception y){
							 JOptionPane.showMessageDialog(null," Your Login Details Already Exit!!", "Alert", JOptionPane.INFORMATION_MESSAGE);
						 	 dispose();
							 login frame = new login();
							 frame.setLocationRelativeTo(null);
							 frame.setVisible(true);;	
								    	
						 }	

				
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 15));
		btnNewButton.setBounds(430, 270, 144, 61);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign in instead");
		btnNewButton_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login frame = new login();
			    frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				}
		});
		btnNewButton_1.setBounds(24, 270, 144, 61);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Create Username");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(17, 91, 130, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Create Password");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 15));
		lblNewLabel_1.setBounds(17, 182, 151, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create your Account");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(187, 33, 325, 50);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 182, 253, 45);
		contentPane.add(passwordField);
	}
}
