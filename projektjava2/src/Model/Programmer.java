package Model;

public class Programmer {
	public String Pesel;
	public String FirstName;
	public String SecondName;
	public String Salary;
	public String Team;
	
	public static String[] columnHeaders = { "Pesel","First Name","Last Name","Salary","Team"};
	public static String SQL_All = "SELECT Pesel,FirstName,SecondName,Salary,t.Name AS TeamName FROM Programmer p INNER JOIN Team t ON p.Team = t.Id;";
	
	public Programmer(String pesel,String firstName,String secondName,String salary,String team)
	{
		this.Pesel = pesel;
		this.FirstName = firstName;
		this.SecondName = secondName;
		this.Salary = salary;
		this.Team = team;
	}
	
	public Programmer()
	{
	}
	
	public String[] toArray()
	{
		String[] temp = new String[5];
		temp[0]=this.Pesel;
		temp[1]=this.FirstName;
		temp[2]=this.SecondName;
		temp[3]=this.Salary;
		temp[4]=this.Team;
		return temp;
	}
}
