package Controllers;
import javax.swing.SwingUtilities;

import Views.Window;

/**	Klasa rozpoczynaj�ca prac� programu.
 * 
 * Program tworzy statystyk� zawarto�ci plik�w tekstowych i j� wy�wietla.
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

