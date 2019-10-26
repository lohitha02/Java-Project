package edu.amrita.cses3.java.project.taskmanager.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "project")
public class ProjectModel 
{
    @Id
    @Column(name = "id")
    private int id;
 
    @Column(name = "project_name")
    private String projectName;
 
    @Column(name = "project_description")
    private String projectDescription;

	@Column(name = "start_date")
    private String startDate;
    
    @Column(name = "end_date")
    private String endDate;
    
    @Column(name = "number_of_group_members")
    private String groupMemberCount;
    
    @Column(name = "group_member_list")
    private String groupMemberList;
    
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
 
    @Column(name = "last_modified_date_time")
    private Date lastModifiedDateTime;
 
    public int getId() 
    {
        return id;
    }
 
    public void setId(int id) 
    {
        this.id = id;
    }
 
    public String getProjectName() 
    {
        return projectName;
    }
 
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectDescription() 
    {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) 
	{
		this.projectDescription = projectDescription;
	}

	public String getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(String startDate) 
	{
		this.startDate = startDate;
	}

	public String getEndDate() 
	{
		return endDate;
	}

	public void setEndDate(String endDate) 
	{
		this.endDate = endDate;
	}

	public String getGroupMemberCount() 
	{
		return groupMemberCount;
	}

	public void setGroupMemberCount(String groupMemberCount) 
	{
		this.groupMemberCount = groupMemberCount;
	}
	
	public String getGroupMemberList() 
	{
		return groupMemberList;
	}

	public void setGroupMemberList(String groupMemberList) 
	{
		this.groupMemberList = groupMemberList;
	}
    
    public String getLastModifiedBy() 
    {
        return lastModifiedBy;
    }
 
    public void setLastModifiedBy(String lastModifiedBy) 
    {
        this.lastModifiedBy = lastModifiedBy;
    }
 
    public Date getLastModifiedDateTime() 
    {
        return lastModifiedDateTime;
    }
 
    public void setLastModifiedDateTime(Date lastModifiedDateTime) 
    {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }
}