package edu.amrita.cses3.java.project.taskmanager.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame {

	LoginPage login;
	
	public WelcomePage()
	{
		JLabel welcomeMsg = new JLabel ("Welcome!", SwingConstants.CENTER);
		
		Font font = new Font ("TimesRoman", Font.BOLD, 40);
		
		welcomeMsg.setFont(font);
		
		JButton signInButton = new JButton ("Sign In");
		signInButton.setSize(20, 40);
		
		JButton newUserButton = new JButton ("New User");
		newUserButton.setSize(20, 40);
		
		add(welcomeMsg);
		add(signInButton);
		add(newUserButton);
		
		setLayout(new GridLayout(3, 1, 5, 20));
		
		signInButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				
				login = new LoginPage();
				
				login.setTitle("Task Manager - Login Page");
				login.setSize(400, 400);
				login.setLocationRelativeTo(null);
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setVisible(true);
			}
		}
				
		);
		
		
		newUserButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				
				SignUpPage signup = new SignUpPage();
				
				signup.setTitle("Task Manager - SignUp Page");
				signup.setSize(400, 400);
				signup.setLocationRelativeTo(null);
				signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				signup.setVisible(true);
			}
		}
		);
	}
	
	public static void main (String args[])
	{
		WelcomePage frame = new WelcomePage();
		
		frame.setTitle("Task Manager - Welcome Page");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}
