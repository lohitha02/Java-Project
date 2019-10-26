package edu.amrita.cses3.java.project.taskmanager.ui;

import javax.swing.*;

import edu.amrita.cses3.java.project.taskmanager.dao.UsersDao;
import edu.amrita.cses3.java.project.taskmanager.model.UserModel;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class SignUpPage extends JFrame {

	WelcomePage welcome;
	JTextField firstname, lastname, username, emailid, password;   

	  public SignUpPage() {

	    JLabel signUpMsg = new JLabel("SignUp", SwingConstants.CENTER);
	    
	    Font font = new Font ("TimesRoman", Font.BOLD, 40);
	    
	    signUpMsg.setFont(font);

	    JPanel s1 = new JPanel (new GridLayout(5, 2, 5, 5));

	    s1.add(new JLabel("Firstname:"));
	    firstname = new JTextField(10);
	    s1.add(firstname);
	  
	    s1.add(new JLabel("Lastname:"));
	    lastname = new JTextField(10);
	    s1.add(lastname);
	    
	    s1.add(new JLabel("Username:"));
	    username = new JTextField(10);
	    s1.add(username);

	    s1.add(new JLabel("Email id:"));
	    emailid = new JTextField(15);
	    s1.add(emailid);

	    s1.add(new JLabel("Password"));
	    password = new JTextField(10);
	    s1.add(password);

	    JPanel s2 = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 10));

	    JButton okButton = new JButton("Ok");
	    JButton cancelButton = new JButton("Cancel");

	    s2.add(okButton);
	    s2.add(cancelButton);
	    
	    setLayout(new GridLayout (3, 1, 10, 10));
	    
	    add(signUpMsg);
	    add(s1);
	    add(s2);

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
	    		createUser();
	    		
	    		JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame, "Account has been created successfully");
	    		
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
	  }
	  
	private void createUser()
	{
        UserModel userObj = new UserModel();
        
        userObj.setUserName(username.getText());
        userObj.setFirstName(firstname.getText());
        userObj.setLastName(lastname.getText());
        userObj.setPassword(password.getText());
        userObj.setEmail(emailid.getText());
        userObj.setLastModifiedBy("admin");
        userObj.setLastModifiedDateTime(new Date());

        UsersDao.saveOrUpdate(userObj);
	}


	  public static void main(String[] args) {

	    SignUpPage frame = new SignUpPage();

	    frame.setTitle("Task Manager - SignUp Page");
	    frame.setSize(400, 400);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

	  }
}
