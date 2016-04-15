package Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controllers.DataBase;
import Controllers.OpenFile;
import Controllers.Statistics;

/**
 * Klasa przycisku otwierania pliku.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class OpenFileButton extends JButton
{
	private static final long serialVersionUID = 1L;
	private Window w;

	OpenFileButton(Window _w)
	{
		w=_w;
		setText("Statystyka pliku");
		setSize(150,40);
		setVisible(true);
		setForeground(Color.BLACK);
		setBackground(new Color(0,128,255));
		Border line = null;
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		setBorder(compound);
		addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				CreateOpenFileDialog(e);
				if(w.getFileContent() != null)
				{
					Statistics stats = new Statistics(w.getFileContent());
					DataBase DB = new DataBase("statistics");
				
					w.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH); 
					w.setWordsChartParam(stats);
					w.setLetterChartParam(stats);
					w.setWhiteChartParam(stats);
					w.setSpecialChartParam(stats);
					w.setWordTable(stats);
					w.setLetterTable(stats);
					w.setSpecialTable(stats);
					w.setWhiteTable(stats);
					w.getOpenButton().setLocation(w.getFrame().getWidth()-w.getOpenButton().getWidth()-w.getDataBaseButton().getWidth()-20, w.getLetterChartPanel().getHeight()+w.getSpecialChartPanel().getHeight()+30);
					w.getDataBaseButton().setLocation(w.getFrame().getWidth()-w.getDataBaseButton().getWidth()-15, w.getLetterChartPanel().getHeight()+w.getSpecialChartPanel().getHeight()+30);
					w.setDefaultDataBaseProgressBarParam();
					w.getFrame().revalidate();
					w.getFrame().repaint();
					 
					DB.insertStatistics(stats,w);
				}
			}
		});
	}
	/**
	 * Metoda tworz¹ca okno otwierania pliku.
	 * @param e Zdarzenie wejœciowe. 
	 */
	private void CreateOpenFileDialog(ActionEvent e)
	{
		JFileChooser openDialog = new JFileChooser();
		openDialog.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
		if (e.getSource() == this) 
		{
	        int returnVal = openDialog.showDialog(null, "Otwórz plik");
	        if (returnVal == JFileChooser.APPROVE_OPTION) 
	        {
	            File file = openDialog.getSelectedFile();
	            OpenFile oF = new OpenFile(file);
	            w.setFileContent(oF.getContent());
	        }
	        else
	        {
	        	w.setFileContent(null);
	        }
		}
	}
}
