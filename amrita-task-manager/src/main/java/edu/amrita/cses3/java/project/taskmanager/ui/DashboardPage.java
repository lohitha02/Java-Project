package edu.amrita.cses3.java.project.taskmanager.ui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import edu.amrita.cses3.java.project.taskmanager.dao.ProjectDao;
import edu.amrita.cses3.java.project.taskmanager.model.ProjectModel; 

public class DashboardPage extends JFrame {

	WelcomePage welcome;
	ProjectPage newProject;
	UserPage profile;
	
	static DefaultListModel projectListModel = new DefaultListModel();

	static Map <String, ProjectModel> projectMap = new HashMap <String, ProjectModel>();
	
	JList projectList = new JList(projectListModel);
	
	ProjectDao projectDao;

	
	public DashboardPage()
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 270, 5));
		
		JLabel title = new JLabel("Task Manager");
		
		Font font1 = new Font("TimesRoman", Font.BOLD, 25);
		title.setFont(font1);
		
		p1.add(title, SwingConstants.CENTER);
		
		p1.setBorder(new LineBorder(Color.BLACK, 1));
		
		
		Box buttonBox = Box.createVerticalBox();
		
		//must change so that it uses the user's name, through database and add an icon
		JButton profileButton = new JButton("Profile");

		JButton signOutButton = new JButton("Sign Out");
		
		buttonBox.add(profileButton);
		buttonBox.add(signOutButton);
		
		p1.add(buttonBox);
		

		
		Font font2 = new Font("TimesRoman", Font.BOLD, 15);
		
		
		JPanel p2 = new JPanel(new GridLayout(3, 1, 10, 5));
		
		JLabel projectListLabel = new JLabel("Project List", SwingConstants.CENTER);
		projectListLabel.setFont(font2);
		p2.add(projectListLabel);
		
		Box projectButtonBox = Box.createHorizontalBox();
		
		JButton addProjectButton = new JButton("Add Project");
		JButton editProjectButton = new JButton("Edit Project");
		JButton deleteProjectButton = new JButton("Delete Project");
		
		projectButtonBox.add(addProjectButton);
		projectButtonBox.add(editProjectButton);
		projectButtonBox.add(deleteProjectButton);	
		
		java.util.List<ProjectModel> list = projectDao.getProjectList();
		projectMap.clear();
		projectListModel.removeAllElements();
		projectListModel.clear();
		
		for (int i=0; i<list.size(); i++)
		{
			projectMap.put(list.get(i).getProjectName(), list.get(i));
			projectListModel.addElement(projectMap.get(list.get(i).getProjectName()).getProjectName());
		}
	
		p2.add(projectList);
		p2.add(projectButtonBox);
	
		
		
		
		JPanel p3 = new JPanel(new GridLayout(3, 1, 10, 5));
		
		JLabel reminderListLabel = new JLabel("Reminder List", SwingConstants.CENTER);
		reminderListLabel.setFont(font2);
		p3.add(reminderListLabel);
		
		JList reminderList = new JList();
		
		Box reminderButtonBox = Box.createHorizontalBox();
		
		JButton addReminderButton = new JButton("Add Reminder");
		JButton editReminderButton = new JButton("Edit Reminder");
		JButton deleteReminderButton = new JButton("Delete Reminder");
		
		reminderButtonBox.add(addReminderButton);
		reminderButtonBox.add(editReminderButton);
		reminderButtonBox.add(deleteReminderButton);
		
		p3.add(reminderList);
		p3.add(reminderButtonBox);
		
		
		
		
		
		JPanel p4 = new JPanel (new FlowLayout(FlowLayout.CENTER, 10, 10));
		p4.add(p2);
		p4.add(p3);
		
		
		springLayout.putConstraint(SpringLayout.SOUTH, p4, 250, SpringLayout.NORTH, p1);
		
		
		add(p1, SwingConstants.CENTER);
		add(p4);
		
		signOutButton.addActionListener(new ActionListener()
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
		
		profileButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				profile = new UserPage();
				
				profile.setTitle("Task Manager - Welcome Page");
				profile.setSize(400, 400);
				profile.setLocationRelativeTo(null);
				profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				profile.setVisible(true);
			}
		}
		);
		
		
		addProjectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				newProject = new ProjectPage();
				
				newProject.setTitle("Task Manager - New Project");
				newProject.setSize(400, 400);
				newProject.setLocationRelativeTo(null);
				newProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newProject.setVisible(true);
			}
		}
		);
		
		deleteProjectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				projectDao.delete(projectMap.get(projectList.getSelectedValue()));
				
				projectMap.remove(projectList.getSelectedValue());
				
				projectListModel.removeElement(projectList.getSelectedValue());
			}
		}
		);
		
		editProjectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				newProject = new ProjectPage(DashboardPage.this, projectMap.get(projectList.getSelectedValue()));
				
				System.out.println(projectList.getSelectedValue());
				
				newProject.setTitle("Task Manager - New Project");
				newProject.setSize(400, 400);
				newProject.setLocationRelativeTo(null);
				newProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newProject.setVisible(true);
			}
		}
		);
	}
	
	
	public static void main(String args[])
	{
		DashboardPage frame = new DashboardPage();

		frame.setTitle("Task Manager - Dashboard");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
