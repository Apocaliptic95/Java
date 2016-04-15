package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** Klasa tworz�ca okno g��wne.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 */

public class WordChartFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public WordChartFrame(String name) {
		super(name);
	}
	
	/**
	 * Metoda ustawiaj�ca parametry domy�lne.
	 */

	public void setDefaultFrameParam()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(GetIcon());
		setResizable(false);
		getContentPane().setBackground(new Color(85,85,85));
		setLayout(null);
		centreWindow();
	}
	
	/**
	 * Metoda centruj�ca okno
	 */
	
	private void centreWindow() 
	{
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    setLocation(x, y);
	}
	
	/**
	 * Metoda ustawiaj�ca ikon� okna.
	 * @return Ikona okna.
	 */

	private Image GetIcon()
	{
		Image image = null;
		try 
		{
			if(getClass().getResource("/chart59.jpg") != null)
				image = ImageIO.read(getClass().getResource("/chart59.jpg"));
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "B��d pliku ikony.", JOptionPane.INFORMATION_MESSAGE);
		}
		return image;
	}
}
