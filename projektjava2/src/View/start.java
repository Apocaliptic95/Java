package View;
import javax.swing.SwingUtilities;

import Controler.dbController;

public class start {
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
            public void run() 
            {
            	dbController db = new dbController("Database");
            	if(db.Connected) 
            	{
            		@SuppressWarnings("unused")
					Window window = new Window();
            	}
            }
		});
	}
}
