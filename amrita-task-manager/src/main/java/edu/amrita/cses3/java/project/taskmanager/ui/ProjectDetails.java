package edu.amrita.cses3.java.project.taskmanager.ui;
import javax.swing.*;

import edu.amrita.cses3.java.project.taskmanager.model.ProjectModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ProjectDetails extends JFrame {

	int id;
	String name;
	String description = "";
	String startDate, endDate;
	String memberCount;
	String members;
	
	ProjectDetails project;
	
	public ProjectDetails(ProjectModel p)
	{
		id = p.getId();
		name = p.getProjectName();
		description = p.getProjectDescription();
		startDate = p.getStartDate();
		endDate = p.getEndDate();
		memberCount = p.getGroupMemberCount();
		members = p.getGroupMemberList();
	}
	
	public ProjectDetails(String n, String d, String sd, String ed, String i, String arr)
	{
		name = n;
		description = d;
		startDate = sd;
		endDate = ed;
		memberCount = i;
		members = arr;
	}
	
	public ProjectDetails(String key, ProjectDetails value) {
		// TODO Auto-generated constructor stub
		
		name = key;
		project = value;
	}
	
	void setId (int id)
	{
		this.id = id;
	}
	
	int getId()
	{
		return id;
	}

	void setProjectName(String name)
	{
		this.name = name;
	}
	
	
	String getProjectName()
	{
		return name;
	}
	
	
	void setProjectDescription(String d)
	{
		description = d;
	}
	
	
	String getProjectDescription()
	{
		return description;
	}
	
	
	void setStartDate(String date)
	{
		startDate = date;
	}
	
	
	String getStartDate()
	{
		return startDate;
	}
	
	
	void setEndDate(String date)
	{
		endDate = date;
	}
	
	
	String getEndDate()
	{
		return endDate;
	}
	
	
	void setMemberCount(String count)
	{
		memberCount = count;
	}
	
	
	String getMemberCount()
	{
		return memberCount;
	}
	
	
	void setMembers(String arr)
	{
		members = arr;
	}
	
	
	String getMembers()
	{
		return members;
	}
	
	
	public String toString()
	{
		return name;
	}
	
	boolean isEmpty()
	{
		if (name == null || startDate == null || endDate == null || memberCount == null || members == null)
			return true;
		
		return false;
	}
}
