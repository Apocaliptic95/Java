package Controler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Programmer;
import Model.Project;
import Model.Team;
import Model.TeamProject;

public class dbController {
		final public String TeamTableSQL = "CREATE TABLE Team (Id INTEGER PRIMARY KEY UNIQUE NOT NULL,Name TEXT NOT NULL UNIQUE,Room INTEGER NOT NULL,Speciality TEXT NOT NULL,Level INTEGER NOT NULL);";
		final public String ProgrammerTableSQL = "CREATE TABLE Programmer (Pesel TEXT PRIMARY KEY UNIQUE,FirstName TEXT NOT NULL,SecondName TEXT NOT NULL,Salary DOUBLE NOT NULL,Team INTEGER REFERENCES Team (Id) ON UPDATE CASCADE);";
		final public String ProjectTableSQL = "CREATE TABLE Project (Id INTEGER PRIMARY KEY UNIQUE,Name TEXT NOT NULL UNIQUE,StartDate DATE NOT NULL,Status TEXT NOT NULL,Category TEXT NOT NULL);";
		final public String TeamProjectTableSQL = "CREATE TABLE Team_Project (Project_Id INTEGER REFERENCES Project (Id) ON UPDATE CASCADE NOT NULL,Team_Id INTEGER REFERENCES Team (Id) ON UPDATE CASCADE NOT NULL);";
		
		public Connection conection = null;
		public boolean Connected = false; 
		
		public dbController(String name)
		{
			Connected = Connect(name);
			createTables();
			try
			{
			    Statement statement = conection.createStatement();
			    statement.execute("INSERT INTO Team (Id,Name,Room,Speciality,Level) VALUES (1,'Incredible',22,'LowLevel',5);");
		        statement.execute("INSERT INTO Programmer (Pesel,FirstName,SecondName,Salary,Team) VALUES ('95070909432','Sebastian','Majewski',4500,1);");
		        statement.execute("INSERT INTO Project (Id,Name,StartDate,Status,Category) VALUES (1,'New Project','14.01.2016','In Progress','Java');");
		        statement.execute("INSERT INTO Team_Project (Project_Id,Team_Id) VALUES (1,1);");
			}
			catch(Exception e)
			{
				
			}
		}
		
		public Object[][] executeStatement(String sql,Class<?> cls)
		{
			try
			{
				Statement statement = conection.createStatement();
				statement.clearWarnings();
				ResultSet rs = statement.executeQuery(sql);
				if(cls == Model.Programmer.class)
				{
					List<Model.Programmer> list = new ArrayList<Model.Programmer>();
					while(rs.next())
					{
						list.add(new Programmer(rs.getString("Pesel"),rs.getString("FirstName"),rs.getString("SecondName"),rs.getString("Salary"),rs.getString("TeamName")));
					}
					Object[][] array = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
					  array[i] = list.get(i).toArray();
					}
					rs.close();
					statement.close();
					return array;
				}
				else if(cls == Model.Project.class)
				{
					List<Model.Project> list = new ArrayList<Model.Project>();
					while(rs.next())
					{
						list.add(new Project(rs.getString("Id"),rs.getString("Name"),rs.getString("StartDate"),rs.getString("Status"),rs.getString("Category")));
					}
					Object[][] array = new String[list.size()][4];
					for (int i = 0; i < list.size(); i++) {
					  array[i] = list.get(i).toArray();
					}
					rs.close();
					statement.close();
					return array;
				}
				else if(cls == Model.Team.class)
				{
					List<Model.Team> list = new ArrayList<Model.Team>();
					while(rs.next())
					{
						list.add(new Team(rs.getString("Id"),rs.getString("Name"),rs.getString("Room"),rs.getString("Speciality"),rs.getString("Level")));
					}
					Object[][] array = new String[list.size()][4];
					for (int i = 0; i < list.size(); i++) {
					  array[i] = list.get(i).toArray();
					}
					rs.close();
					statement.close();
					return array;
				}
				else if(cls == Model.TeamProject.class)
				{
					List<Model.TeamProject> list = new ArrayList<Model.TeamProject>();
					while(rs.next())
					{
						list.add(new TeamProject(rs.getString("TeamName"),rs.getString("ProjectName")));
					}
					Object[][] array = new String[list.size()][2];
					for (int i = 0; i < list.size(); i++) {
					  array[i] = list.get(i).toArray();
					}
					rs.close();
					statement.close();
					return array;
				}
				rs.close();
				statement.close();
				return null;
			}
			catch( Exception e )
			{
				return null;
			}
		}
		
		private boolean Connect(String name)
		{
			boolean result = false;
			try 
		    {
		      Class.forName("org.sqlite.JDBC");
		      conection = DriverManager.getConnection("jdbc:sqlite:"+name+".db");
		      result = true;
		    } 
		    catch ( Exception e ) 
		    {
		    	try 
			    {
			      Class.forName("org.sqlite.JDBC");
			      conection = DriverManager.getConnection("jdbc:sqlite:"+name+".db");
			      result = true;
			    } 
			    catch ( Exception f ) 
			    {
			    	result = false;
			    }
		    }
			return result;
		 }
		
		private boolean createTables()
		{
			boolean result = false;
			try 
		     {
	        	Statement statement = conection.createStatement();
	            statement.execute(TeamTableSQL);
	            statement.execute(ProgrammerTableSQL);
	            statement.execute(ProjectTableSQL);
	            statement.execute(TeamProjectTableSQL);
	            result = true;
	            statement.close();
		     } 
		     catch (Exception e) 
		     {
	            result = false;
		     }
			return result;
		}
		
		
}
