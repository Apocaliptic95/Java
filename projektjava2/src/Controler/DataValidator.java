package Controler;

public class DataValidator 
{
	public boolean StringValidator(String arg)
	{
		if(arg.matches("^\\b(?:[A-Z]\\w+\\b(?:\\s*)?)+$"))
			return true;
		else
			return false;
	}
	
	public boolean DateValidator(String arg)
	{
		if(arg.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"))
			return true;
		else
			return false;
	}
	
	public boolean IntegerValidator(String arg)
	{
		if(arg.matches("^[1-9]\\d*$"))
			return true;
		else
			return false;
	}
	
	public boolean DoubleValidator(String arg)
	{
		
		if(arg.matches("(\\d{1,3},)*\\d+\\.\\d{2}"))
			return true;
		else
			return false;
	}
	
	public boolean PeselValidator(String arg)
	{
		if(arg.matches("^\\d{11}$"))
			return true;
		else
			return false;
	}
}
