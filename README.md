# Java-Project

“Plan your work and work your plan” – Napoleon Hill
 
No matter how you work or what type of business you run, being productive is a must. But techniques and strategies aren’t enough if you don’t have the tools needed to implement them.

In the market, there are many small productivity apps available but they are not integrated. This project takes two most important features namely to-do list management and remainder management and integrates them.

Features
The main features of this application are:

✔ The user can declare, list out and describe the tasks needed to be done within a single project. As the user performs these tasks, the status of each task will be updated as To Do, Doing and Done.

✔ This web app will give the user a reminder from time-to-time regarding the tasks that are still pending. Hence, the user will never forget about the task. These notification timings will be set by the user.

Technology Stack
Java, Java Swing, Eclipse IDE, RESTlet, Jackson, Weblogic Server, MySQL DB Server, Maven, Balsamiq, draw.io (Google Doc plugin), Hibernate.

This project is a client-server application. The client or front end is implemented as a web application using Java Swing.

The server or back end is implemented using application servers like WebLogic, Tomcat, JBoss, etc. MySQL database server is also used in the back end to store the data. HIbernate Java library will be used to communicate with the database and to obtain the data as Java Objects. RESTlets will be used to communicate between the client and server in JavaScript Object Notation (JSON) format. The Jackson Java library is used to convert JSON to Java objects and vice versa.

Classes Used:
The following classes are used in this application:

LoginPage: 
 Once authentication is successful, it allows the user to access the dashboard.
Dashboard: 
 It shows the list of available projects. It also allows access to the user’s profile page.
ProfilePage: 
 It contains the details of the user.
ProjectManager: It allows the user to create, edit and/or delete a project.
Project: 
 It contains the details of the project.
TaskManager: 
 It allows the user to create, edit and/or delete tasks belonging to a specific project.
Task: 
 It contains details of the task.
RemainderManager: 
 It allows the user to create, edit and/or delete a remainder.
Remainder: 
 It contains the details of the remainder.

 There will also be a few more classes to get the data from the database. This is for the back end.
