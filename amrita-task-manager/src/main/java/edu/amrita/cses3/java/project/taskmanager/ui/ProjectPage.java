package edu.amrita.cses3.java.project.taskmanager.ui;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.amrita.cses3.java.project.taskmanager.dao.ProjectDao;
import edu.amrita.cses3.java.project.taskmanager.model.ProjectModel;

public class ProjectPage extends JFrame{
	
	ProjectDetails project; 
	DashboardPage dashboard = null; // new DashboardPage();
	DashboardPage db;
	
	DefaultListModel  model= new DefaultListModel();
	
	JTextField projectNameField, projectStartDateField, projectEndDateField, memberCountField, listOfMembersField;
	JTextArea projectDescriptionField;
	
	ProjectDao projectDao;
	List<ProjectModel> list;
	ProjectModel projectModel;
	
		
	public ProjectPage()
	{
		setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("New Project", SwingConstants.CENTER);
		Font font = new Font("TimesRoman", Font.BOLD, 30);
		title.setFont(font);
		
		panel.add(title);
		
		
		
		JPanel p1 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel projectNameLabel = new JLabel("Project Name:");
		projectNameField = new JTextField();
		
		JLabel projectDescriptionLabel = new JLabel("Project Description:");
		projectDescriptionField = new JTextArea();
		
		p1.add(projectNameLabel);
		p1.add(projectNameField);
		p1.add(projectDescriptionLabel);
		p1.add(projectDescriptionField);
		
		
		
		JPanel p2 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel projectStartDateLabel = new JLabel("Start Date of Project:");
		projectStartDateField = new JTextField();
		
		JLabel projectEndDateLabel = new JLabel ("End Date of Project:");
		projectEndDateField = new JTextField();
		
		p2.add(projectStartDateLabel);
		p2.add(projectStartDateField);
		p2.add(projectEndDateLabel);
		p2.add(projectEndDateField);
		
		
		
		JPanel p3 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel memberCountLabel = new JLabel("Number of Group Members");
		memberCountField = new JTextField();
		
		JLabel listOfMembersLabel = new JLabel("Group Members List:");
		listOfMembersField = new JTextField();
		
		p3.add(memberCountLabel);
		p3.add(memberCountField);
		p3.add(listOfMembersLabel);
		p3.add(listOfMembersField);
		
		
		
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton createButton = new JButton("Create Project");
		JButton cancelButton = new JButton("Cancel");
		
		p4.add(createButton);
		p4.add(cancelButton);
		
		
		add(panel);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}	
		}
		);
		
		createButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProjectModel newProjectModel = createProject();
				
				dashboard.projectMap.put(newProjectModel.getProjectName(), newProjectModel);
				dashboard.projectListModel.addElement(newProjectModel.getProjectName());
				
				dispose();
			}
		}
		
		);
	}
	
	
	public ProjectPage(DashboardPage page)
	{	
		this.dashboard = page;
		
		setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("New Project", SwingConstants.CENTER);
		Font font = new Font("TimesRoman", Font.BOLD, 30);
		title.setFont(font);
		
		panel.add(title);
		
		
		
		JPanel p1 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel projectNameLabel = new JLabel("Project Name:");
		projectNameField = new JTextField();
		
		JLabel projectDescriptionLabel = new JLabel("Project Description:");
		projectDescriptionField = new JTextArea();
		
		p1.add(projectNameLabel);
		p1.add(projectNameField);
		p1.add(projectDescriptionLabel);
		p1.add(projectDescriptionField);
		
		
		
		JPanel p2 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel projectStartDateLabel = new JLabel("Start Date of Project:");
		projectStartDateField = new JTextField();
		
		JLabel projectEndDateLabel = new JLabel ("End Date of Project:");
		projectEndDateField = new JTextField();
		
		p2.add(projectStartDateLabel);
		p2.add(projectStartDateField);
		p2.add(projectEndDateLabel);
		p2.add(projectEndDateField);
		
		
		
		JPanel p3 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel memberCountLabel = new JLabel("Number of Group Members");
		memberCountField = new JTextField();
		
		JLabel listOfMembersLabel = new JLabel("Group Members List:");
		listOfMembersField = new JTextField();
		
		p3.add(memberCountLabel);
		p3.add(memberCountField);
		p3.add(listOfMembersLabel);
		p3.add(listOfMembersField);
		
		
		
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton createButton = new JButton("Create Project");
		JButton cancelButton = new JButton("Cancel");
		
		p4.add(createButton);
		p4.add(cancelButton);
		
		
		add(panel);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}	
		}
		);
		
		createButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProjectModel newProjectModel = createProject();
				
				dashboard.projectMap.put(newProjectModel.getProjectName(), newProjectModel);
				dashboard.projectListModel.addElement(newProjectModel.getProjectName());
				
				
				dispose();
			}
		}
		
		);
	}
	
	public ProjectPage(DashboardPage page, ProjectModel p) //edit
	{	
		this.dashboard = page;
		
		setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Edit Project", SwingConstants.CENTER);
		Font font = new Font("TimesRoman", Font.BOLD, 30);
		title.setFont(font);
		
		panel.add(title);
		
		
		
		JPanel p1 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel projectNameLabel = new JLabel("Project Name:");
		projectNameField = new JTextField(p.getProjectName());
		
		JLabel projectDescriptionLabel = new JLabel("Project Description:");
		projectDescriptionField = new JTextArea(p.getProjectDescription());
		
		p1.add(projectNameLabel);
		p1.add(projectNameField);
		p1.add(projectDescriptionLabel);
		p1.add(projectDescriptionField);
		
		
		
		JPanel p2 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel projectStartDateLabel = new JLabel("Start Date of Project:");
		projectStartDateField = new JTextField(p.getStartDate());
		
		JLabel projectEndDateLabel = new JLabel ("End Date of Project:");
		projectEndDateField = new JTextField(p.getEndDate());
		
		p2.add(projectStartDateLabel);
		p2.add(projectStartDateField);
		p2.add(projectEndDateLabel);
		p2.add(projectEndDateField);
		
		
		
		JPanel p3 = new JPanel(new GridLayout(2, 2, 10, 10));
		
		JLabel memberCountLabel = new JLabel("Number of Group Members");
		memberCountField = new JTextField(p.getGroupMemberCount());
		
		JLabel listOfMembersLabel = new JLabel("Group Members List:");
		listOfMembersField = new JTextField(p.getGroupMemberList());
		
		p3.add(memberCountLabel);
		p3.add(memberCountField);
		p3.add(listOfMembersLabel);
		p3.add(listOfMembersField);
		
		
		
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton confirmButton = new JButton("Confirm Edit");
		JButton cancelButton = new JButton("Cancel");
		
		p4.add(confirmButton);
		p4.add(cancelButton);
		
		
		add(panel);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}	
		}
		);
		
		confirmButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				project = new ProjectDetails(projectNameField.getText(), projectDescriptionField.getText(), projectStartDateField.getText(), projectEndDateField.getText(), memberCountField.getText(), listOfMembersField.getText());
				
				projectModel = new ProjectModel();
				
				projectModel.setId(p.getId());
				projectModel.setProjectName(project.name);
				projectModel.setProjectDescription(project.description);
				projectModel.setStartDate(project.startDate);
				projectModel.setEndDate(project.endDate);
				projectModel.setGroupMemberCount(project.memberCount);
				projectModel.setGroupMemberList(project.members);
				
				page.projectMap.put(project.name, projectModel);
					
				page.projectListModel.addElement(project.name);
				
				page.projectMap.remove(p.getProjectName());
				
				page.projectListModel.removeElement(p.getProjectName());
				
				projectDao.saveOrUpdate(projectModel);
				
				dispose();
			}
		}
		
		);
	}
	
	private ProjectModel createProject()
	{
        ProjectModel projectObj = new ProjectModel();
        
        projectObj.setProjectName(projectNameField.getText());
        projectObj.setProjectDescription(projectDescriptionField.getText());
        projectObj.setStartDate(projectStartDateField.getText());
        projectObj.setEndDate(projectEndDateField.getText());
        projectObj.setGroupMemberCount(memberCountField.getText());
        projectObj.setGroupMemberList(listOfMembersField.getText());
        projectObj.setLastModifiedBy("admin");
        projectObj.setLastModifiedDateTime(new Date());

        ProjectDao.saveOrUpdate(projectObj);
        
        return projectObj;
	}
	
	public static void main(String args[])
	{
		ProjectPage frame = new ProjectPage();
		
		frame.setTitle("Task Manager - New Project");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
