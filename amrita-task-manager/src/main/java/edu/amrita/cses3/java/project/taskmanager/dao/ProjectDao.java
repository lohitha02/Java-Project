package edu.amrita.cses3.java.project.taskmanager.dao;

import edu.amrita.cses3.java.project.taskmanager.model.ProjectModel;

import java.util.*;

public class ProjectDao extends BaseDao {

	public static void saveOrUpdate(ProjectModel project) 
    {
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.saveOrUpdate(project);
            
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } 
        catch (Exception sqlException) 
        {
            if (null != sessionObj && null != sessionObj.getTransaction()) 
            {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            
            sqlException.printStackTrace();
        } 
        finally 
        {
            if (sessionObj != null) 
            {
                sessionObj.close();
            }
        }
        
    }
    
    public static void delete(ProjectModel project)
    {
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.delete(project);
            
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } 
        catch (Exception sqlException) 
        {
            if (null != sessionObj && null != sessionObj.getTransaction()) 
            {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            
            sqlException.printStackTrace();
        } 
        finally 
        {
            if (sessionObj != null) 
            {
                sessionObj.close();
            }
        }
    }
    
    public static ProjectModel getProjectById(int id)
    {
    	ProjectModel project = null;
    	
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            project = (ProjectModel) sessionObj.get(ProjectModel.class, id);
            
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } 
        catch (Exception sqlException) 
        {
            if (null != sessionObj && null != sessionObj.getTransaction()) 
            {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            
            sqlException.printStackTrace();
        } 
        finally 
        {
            if (sessionObj != null) 
            {
                sessionObj.close();
            }
        }
        
        return project;
    }
       
    @SuppressWarnings("unchecked")
	public static List<ProjectModel> getProjectList()
    {
    	List<ProjectModel> projectList = null; 
    	
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            projectList = sessionObj.createQuery("from ProjectModel").list();
            
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } 
        catch (Exception sqlException) 
        {
            if (null != sessionObj && null != sessionObj.getTransaction()) 
            {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            
            sqlException.printStackTrace();
        } 
        finally 
        {
            if (sessionObj != null) 
            {
                sessionObj.close();
            }
        }
        
        return projectList;
    }    
}
