package Model;

public class Team {
	public String Id;
	public String Name;
	public String Room;
	public String Speciality;
	public String Level;
	
	public static String[] columnHeaders = { "Name","Room","Speciality","Level"};
	public static String SQL_All = "SELECT * FROM Team";
	
	public Team(String id, String name,String room,String speciality,String level)
	{
		this.Id = id;
		this.Name = name;
		this.Room = room;
		this.Speciality = speciality;
		this.Level = level;
	}
	
	public Team()
	{
	}
	
	public String[] toArray()
	{
		String[] temp = new String[4];
		temp[0]=this.Name;
		temp[1]=this.Room;
		temp[2]=this.Speciality;
		temp[3]=this.Level;
		return temp;
	}
}
