package Model;

public class TeamProject {
	public String Team;
	public String Project;
	
	public static String[] columnHeaders = {"Team","Project"};
	public static String SQL_All = "SELECT t.Name AS TeamName, p.Name AS ProjectName FROM Team_Project tp INNER JOIN Team t ON tp.Team_Id = t.Id INNER JOIN Project p ON tp.Project_Id = p.Id;";
	
	public TeamProject(String team, String project)
	{
		this.Team = team;
		this.Project = project;
	}
	
	public TeamProject()
	{
	}
	
	public String[] toArray()
	{
		String[] temp = new String[2];
		temp[0]=this.Team;
		temp[1]=this.Project;
		return temp;
	}
}
