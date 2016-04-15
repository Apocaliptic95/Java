package Controler;

import Model.Programmer;
import Model.Project;
import Model.Team;
import Model.TeamProject;

public class TableData 
{
	public String[] ProjectColNames;
	public String[] ProgrammerColNames;
	public String[] TeamColNames;
	public String[] TeamProjectColNames;
	
	public Object[][] ProjectData;
	public Object[][] ProgrammerData;
	public Object[][] TeamData;
	public Object[][] TeamProjectData;
	
	public TableData()
	{
		fillTables();
	}
	
		@SuppressWarnings("static-access")
		public void fillTables()
		{
			Model.Programmer x = new Model.Programmer();
			Model.Project y = new Model.Project();
			Model.Team z = new Model.Team();
			Model.TeamProject a = new Model.TeamProject();
			Controler.dbController db = new Controler.dbController("Database");
			
			ProgrammerColNames = x.columnHeaders;
			ProgrammerData = db.executeStatement(x.SQL_All, Programmer.class);
			
			ProjectColNames = y.columnHeaders;
			ProjectData = db.executeStatement(y.SQL_All, Project.class);
			
			TeamColNames = z.columnHeaders;
			TeamData = db.executeStatement(z.SQL_All, Team.class);
			
			TeamProjectColNames = a.columnHeaders;
			TeamProjectData = db.executeStatement(a.SQL_All, TeamProject.class);
		}
}
