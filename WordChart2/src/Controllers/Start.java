package Controllers;
import javax.swing.SwingUtilities;

import Views.Window;

/**	Klasa rozpoczynaj¹ca pracê programu.
 * 
 * Program tworzy statystykê zawartoœci plików tekstowych i j¹ wyœwietla.
 * 
 * 08.11.2015
 * @author Sebastian Majewski
 * @version 1.0
 */

public class Start 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
            public void run() 
            {
            	Window window = new Window();
            	window.CreateWindow();
            }
		});
	}
}

