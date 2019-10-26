package edu.amrita.cses3.java.project.taskmanager.dao;

import edu.amrita.cses3.java.project.taskmanager.model.UserModel;
import java.util.*;

public class UsersDao extends BaseDao 
{
    public static void saveOrUpdate(UserModel user) 
    {
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.saveOrUpdate(user);
            
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
    
    public static void delete(UserModel user)
    {
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.delete(user);
            
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
    
    
    public static UserModel getUserById(int id)
    {
    	UserModel user = null;
    	
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            user = (UserModel) sessionObj.get(UserModel.class, id);
            
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
        
        return user;
    }
    
    @SuppressWarnings("unchecked")
	public static List<UserModel> getUserList()
    {
    	List<UserModel> userList = null; 
    	
        try 
        {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            userList = sessionObj.createQuery("from Users").list();
            
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
        
        return userList;
    }    
}
