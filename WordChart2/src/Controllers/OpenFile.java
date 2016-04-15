package Controllers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**	Klasa operuj¹ca na pliku z danymi.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 */

public class OpenFile 
{
	private File file;
	private String content = null;
	
	public String getContent()
	{
		return content;
	}

	public OpenFile(File f)
	{
		file=f;
		if(file.canRead())
		{
			content = readFile(file);
		}
	}
	/**	Metoda zwracaj¹ca zawartoœæ pliku.
	 * 
	 * @param file	Plik do odczytu.
	 * @return	Dane z pliku.
	 */
	private String readFile(File file)
	{
	    String tempContent = null;
	    FileReader reader = null;
	    try 
	    {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        tempContent = new String(chars);
	        reader.close();
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    } 
	    return tempContent;
	}
}
