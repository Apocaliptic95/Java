package Model;

public class Project {
	public String Id;
	public String Name;
	public String StartDate;
	public String Status;
	public String Category;
	
	public static String[] columnHeaders = { "Name","Start Date","Status","Category"};
	public static String SQL_All = "SELECT * FROM Project";
	
	public Project(String id, String name,String startDate,String status,String category)
	{
		this.Id = id;
		this.Name = name;
		this.StartDate = startDate;
		this.Status = status;
		this.Category = category;
	}
	
	public Project()
	{
	}
	
	public String[] toArray()
	{
		String[] temp = new String[4];
		temp[0]=this.Name;
		temp[1]=this.StartDate;
		temp[2]=this.Status;
		temp[3]=this.Category;
		return temp;
	}
}
