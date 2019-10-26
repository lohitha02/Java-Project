package edu.amrita.cses3.java.project.taskmanager.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame{

	WelcomePage welcome;
	
	public LoginPage()
	{
		JLabel loginMsg = new JLabel("Login", SwingConstants.CENTER);
		
		Font font = new Font ("TimesRoman", Font.BOLD, 40);
		
		loginMsg.setFont(font);
	
		JPanel p1 = new JPanel (new GridLayout(2, 2, 5, 5));
		
		p1.add(new JLabel("Username:"));
		JTextField username = new JTextField(10);
		p1.add(username);
	
		p1.add(new JLabel("Password"));
		JPasswordField password = new JPasswordField(10);
		p1.add(password);
		
		JPanel p2 = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 10));
		
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");
		
		p2.add(okButton);
		p2.add(cancelButton);
		
		setLayout(new GridLayout (3, 1, 10, 10));
		
		add(loginMsg);
		add(p1);
		add(p2);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				
				welcome = new WelcomePage();
				
				welcome.setTitle("Task Manager - Welcome Page");
				welcome.setSize(400, 400);
				welcome.setLocationRelativeTo(null);
				welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				welcome.setVisible(true);
			}	
		}
		);
		
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				
				DashboardPage frame = new DashboardPage();

				frame.setTitle("Task Manager - Dashboard");
				frame.setSize(800, 600);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}	
		}
		);
	}
	
	public static void main(String args[])
	{
		LoginPage frame = new LoginPage();
		
		frame.setTitle("Task Manager - Login Page");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
