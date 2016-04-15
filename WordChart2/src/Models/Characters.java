package Models;

/**
 * Klasa modelu danych typu znakowego.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class Characters implements Comparable<Characters>
{
	private char character;
	private long quantity;
	
	public char getCharacter()
	{
		return character;
	}
	
	public long getQuantity()
	{
		return quantity;
	}
	
	public void setCharacter(char s)
	{
		character = s;
	}
	
	public void setQuantity(long i)
	{
		quantity = i;
	}
	
	public Characters()
	{
		
	}
	
	public Characters(char _character,int _quantity)
	{
		character = _character;
		quantity = _quantity;
	}
	
	@Override 
	public int compareTo(Characters w) 
	{
        if(w.quantity < quantity)
        	return -1;
        else if(w.quantity == quantity)
        	return 0;
        else
        	return 1;
    }
}
