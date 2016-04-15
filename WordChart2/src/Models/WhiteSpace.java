package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa modelu danych typu bia³e znaki.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class WhiteSpace implements Comparable<WhiteSpace>
{
	private char whiteSpace;
	private long quantity;
	private String whiteSpaceName; 
	
	public char getWhiteSpace()
	{
		return whiteSpace;
	}
	
	public long getQuantity()
	{
		return quantity;
	}
	
	public void setWhiteSpace(char s)
	{
		whiteSpace = s;
	}
	
	public void setQuantity(long i)
	{
		quantity = i;
	}
	
	public void setWhiteSpaceName(String s)
	{
		whiteSpaceName=s;
	}
	
	public String getWhiteSpaceName()
	{
		return whiteSpaceName;
	}
	
	public WhiteSpace()
	{
		
	}
	
	public WhiteSpace(String _whiteSpaceName,char _whiteSpace,int _quantity)
	{
		whiteSpaceName = _whiteSpaceName;
		whiteSpace = _whiteSpace;
		quantity = _quantity;
	}
	
	/** Metoda tworz¹ca podstawow¹ listê bia³ych znaków.
	 * 
	 * @return Lista bia³ych znaków.
	 */
	
	public static List<WhiteSpace> createWhiteSpacesList()
	{
		List<WhiteSpace> temp = new ArrayList<WhiteSpace>();
		WhiteSpace Space = new WhiteSpace();
		Space.setQuantity(0);
		Space.setWhiteSpaceName("Space");
		Space.setWhiteSpace((char)32);
		temp.add(Space);
		
		WhiteSpace Tab = new WhiteSpace();
		Tab.setQuantity(0);
		Tab.setWhiteSpaceName("Tab");
		Tab.setWhiteSpace((char)9);
		temp.add(Tab);
		
		WhiteSpace Enter = new WhiteSpace();
		Enter.setQuantity(0);
		Enter.setWhiteSpaceName("Enter");
		Enter.setWhiteSpace((char)10);
		temp.add(Enter);
		
		return temp;
		
	}
	
	@Override
    public int compareTo(WhiteSpace w) 
	{
        if(w.quantity < quantity)
        	return -1;
        else if(w.quantity == quantity)
        	return 0;
        else
        	return 1;
    }
}
