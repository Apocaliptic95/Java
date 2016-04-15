package Models;

/**
 * Klasa modelu danych typu wyrazowego.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class Words implements Comparable<Words>
{
	private String word;
	private long quantity;
	
	public String getWord()
	{
		return word;
	}
	
	public long getQuantity()
	{
		return quantity;
	}
	
	public void setWord(String s)
	{
		word = s;
	}
	
	public void setQuantity(long i)
	{
		quantity = i;
	}
	
	public Words()
	{
		
	}
	
	public Words(String _word,int _quantity)
	{
		word = _word;
		quantity = _quantity;
	}
	
	@Override
    public int compareTo(Words w) 
	{
        if(w.quantity < quantity)
        	return -1;
        else if(w.quantity == quantity)
        	return 0;
        else
        	return 1;
    }
}
