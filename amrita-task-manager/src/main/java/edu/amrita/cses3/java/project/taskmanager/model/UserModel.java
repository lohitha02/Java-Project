package edu.amrita.cses3.java.project.taskmanager.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class UserModel 
{
    @Id
    @Column(name = "id")
    private int id;
 
    @Column(name = "user_name")
    private String userName;
 
    @Column(name = "first_name")
    private String firstName;

	@Column(name = "last_name")
    private String lastName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
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
 
    public String getUserName() 
    {
        return userName;
    }
 
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getFirstName() 
    {
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
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