package edu.amrita.cses3.java.project.taskmanager.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPage extends JFrame {

	public UserPage()
	{
		JLabel welcomeMsg = new JLabel ("Hello Virat Kohli!", SwingConstants.CENTER);
		
		Font font = new Font ("TimesRoman", Font.BOLD, 40);
		
		welcomeMsg.setFont(font);

		JPanel p1 = new JPanel (new GridLayout(5, 2, 5, 5));
		
		p1.add(new JLabel("Username:  "));
		p1.add(new JLabel("Virat18"));

		p1.add(new JLabel("Email id:  "));
		p1.add(new JLabel("virat18@gmail.com"));

		p1.add(new JLabel("Gender:   "));
		p1.add(new JLabel("M"));

		p1.add(new JLabel("Change email:"));
		JTextField email = new JTextField(10);
		p1.add(email);

		p1.add(new JLabel("Change password:"));
		JTextField password = new JTextField(10);
		p1.add(password);

		JPanel p2 = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 10));
		
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");
		
		p2.add(okButton);
		p2.add(cancelButton);

		setLayout(new GridLayout (3, 1, 10, 10));

		add(welcomeMsg);
		add(p1);
		add(p2);

	}
	
	public static void main (String args[])
	{
		UserPage frame = new UserPage();
		
		frame.setTitle("Task Manager - UserPage");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}
