package Views;
import java.awt.*;
import Controllers.Statistics;

import javax.swing.*;
import javax.swing.border.Border;

import Views.WordChartFrame;
import Views.FinalTableModel.tableType;

/**
 * Klasa okna g³ównego.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class Window 
{
	private Chart cp = new Chart();
	private Table tb = new Table();
	private final String name = "Word Chart";
	public String getName()
	{
		return name;
	}
	
	private OpenFileButton openButton = new OpenFileButton(this);
	public OpenFileButton getOpenButton()
	{
		return openButton;
	}
	
	private DataBaseButton dataBaseButton = new DataBaseButton(this);
	public DataBaseButton getDataBaseButton()
	{
		return dataBaseButton;
	}
	
	private WordChartFrame frame = new WordChartFrame(name);
	public WordChartFrame getFrame()
	{
		return frame;
	}
	
	private JPanel letterChartPanel = new JPanel();
	public JPanel getLetterChartPanel()
	{
		return letterChartPanel;
	}
	
	private JPanel wordsChartPanel = new JPanel();
	public JPanel getWordsChartPanel()
	{
		return wordsChartPanel;
	}
	
	private JPanel whiteChartPanel = new JPanel();
	public JPanel getWhiteChartPanel()
	{
		return whiteChartPanel;
	}
	
	private JPanel specialChartPanel = new JPanel();
	public JPanel getSpecialChartPanel()
	{
		return specialChartPanel;
	}
	
	private JPanel wordTablePanel = new JPanel();
	private JPanel letterTablePanel = new JPanel();
	private JPanel whiteTablePanel = new JPanel();
	private JPanel specialTablePanel = new JPanel();
	private final JProgressBar dataBaseProgress = new JProgressBar();
	
	public JProgressBar getDataBaseProgressBar()
	{
		return dataBaseProgress;
	}
	
	private String fileContent;
	public String getFileContent()
	{
		return fileContent;
	}
	public void setFileContent(String _fc)
	{
		fileContent = _fc;
	}
	
	public void CreateWindow()
	{
		frame.setDefaultFrameParam();
		frame.setSize(335, 90);
		openButton.setLocation(10, 10);
		dataBaseButton.setLocation(170, 10);
		frame.add(openButton);
		frame.add(dataBaseButton);
		
	}
	
	/**
	 * Metoda ustawiaj¹ca domyœlne parametry panelu z wykresem  
	 * @param panel Panel do przetworzenia.
	 */
	
	private void setDefaultChartPanelParam(JPanel panel)
	{
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
	}
	
	/**
	 * Metoda tworzy tabelê z wyrazami
	 * @param stats Statystyki
	 */
	
	public void setWordTable(Statistics stats)
	{
		int tableHeightLevel = wordsChartPanel.getHeight() + whiteChartPanel.getHeight() + openButton.getHeight() + 40;
		wordTablePanel.setLocation(10, tableHeightLevel);
		wordTablePanel.setLayout(new BorderLayout());
		wordTablePanel.setVisible(true);
		wordTablePanel.setSize((frame.getWidth()/4)-12, frame.getHeight() - tableHeightLevel - 50);
		String[] names = new String[]{"S³owa","Iloœæ"};
		frame.add(wordTablePanel);
		wordTablePanel.removeAll();
		tb.createTable(names, stats.getWordsList(), wordTablePanel, tableType.Word);
		wordTablePanel.revalidate();
	}
	
	/**
	 * Metoda tworzy tabelê z literami
	 * @param stats Statystyki
	 */
	
	public void setLetterTable(Statistics stats)
	{
		int tableHeightLevel = wordsChartPanel.getHeight() + whiteChartPanel.getHeight() + openButton.getHeight() + 40;
		letterTablePanel.setLocation(wordTablePanel.getWidth() + 20, tableHeightLevel);
		letterTablePanel.setLayout(new BorderLayout());
		letterTablePanel.setVisible(true);
		letterTablePanel.setSize((frame.getWidth()/4)-13, frame.getHeight() - tableHeightLevel - 50);
		String[] names = new String[]{"Litery","Iloœæ"};
		frame.add(letterTablePanel);
		letterTablePanel.removeAll();
		tb.createTable(names, stats.getLettersList(), letterTablePanel, tableType.Letter);
		letterTablePanel.revalidate();
	}
	
	/**
	 * Metoda tworzy tabelê ze znakami specjalnymi
	 * @param stats Statystyki
	 */
	
	public void setSpecialTable(Statistics stats)
	{
		int tableHeightLevel = wordsChartPanel.getHeight() + whiteChartPanel.getHeight() + openButton.getHeight() + 40;
		specialTablePanel.setLocation(wordTablePanel.getWidth() + letterTablePanel.getWidth() + 30, tableHeightLevel);
		specialTablePanel.setLayout(new BorderLayout());
		specialTablePanel.setVisible(true);
		specialTablePanel.setSize((frame.getWidth()/4)-12, frame.getHeight() - tableHeightLevel - 50);
		String[] names = new String[]{"Znaki Specjalne","Iloœæ"};
		frame.add(specialTablePanel);
		specialTablePanel.removeAll();
		tb.createTable(names, stats.getSpecialsList(), specialTablePanel, tableType.Special);
		specialTablePanel.revalidate();
	}
	
	/**
	 * Metoda tworzy tabelê z bia³ymi znakami
	 * @param stats Statystyki
	 */
	
	public void setWhiteTable(Statistics stats)
	{
		int tableHeightLevel = wordsChartPanel.getHeight() + whiteChartPanel.getHeight() + openButton.getHeight() + 40;
		whiteTablePanel.setLocation(wordTablePanel.getWidth() + letterTablePanel.getWidth() + specialTablePanel.getWidth() + 40, tableHeightLevel);
		whiteTablePanel.setLayout(new BorderLayout());
		whiteTablePanel.setVisible(true);
		whiteTablePanel.setSize((frame.getWidth()/4)-13, frame.getHeight() - tableHeightLevel - 50);
		String[] names = new String[]{"Bia³e Znaki","Iloœæ"};
		frame.add(whiteTablePanel);
		whiteTablePanel.removeAll();
		tb.createTable(names, stats.getWhiteSpacesList(), whiteTablePanel, tableType.WhiteSpace);
		whiteTablePanel.revalidate();
	}
	
	/**
	 * Metoda tworzy wykres z wyrazami
	 * @param stats Statystyki
	 */
	
	public void setWordsChartParam(Statistics stats)
	{
		wordsChartPanel.setLocation(10, 10);
		wordsChartPanel.setVisible(true);
		wordsChartPanel.setLayout(new BorderLayout());
		wordsChartPanel.setSize((frame.getWidth()/2)-15,(int)((2.5f)*(frame.getHeight()/10)));
		frame.add(wordsChartPanel);
		cp.makeChart(stats, Chart.chartType.Word, wordsChartPanel);
	}
	
	/**
	 * Metoda tworzy wykres z literami
	 * @param stats Statystyki
	 */
	
	public void setLetterChartParam(Statistics stats)
	{
		letterChartPanel.setLocation(wordsChartPanel.getWidth()+15, 10);
		setDefaultChartPanelParam(letterChartPanel);
		letterChartPanel.setSize((frame.getWidth()/2)-15,2*(frame.getHeight()/10));
		frame.add(letterChartPanel);
		cp.makeChart(stats, Chart.chartType.Letter, letterChartPanel);
	}
	
	/**
	 * Metoda tworzy wykres z bia³ymi znakami.
	 * @param stats Statystyki
	 */
	
	public void setWhiteChartParam(Statistics stats)
	{
		whiteChartPanel.setLocation(10, wordsChartPanel.getHeight()+20);
		setDefaultChartPanelParam(whiteChartPanel);
		whiteChartPanel.setSize((frame.getWidth()/2)-15, (int)((1.5f)*(frame.getHeight()/10)));
		frame.add(whiteChartPanel);
		cp.makeChart(stats, Chart.chartType.WhiteSpace, whiteChartPanel);
	}
	
	/**
	 * Metoda tworzy wykres ze znakami specjalnymi.
	 * @param stats Statystyki
	 */
	
	public void setSpecialChartParam(Statistics stats)
	{
		specialChartPanel.setLocation(whiteChartPanel.getWidth()+15, letterChartPanel.getHeight()+20);
		setDefaultChartPanelParam(specialChartPanel);
		specialChartPanel.setSize((frame.getWidth()/2)-15, 2*(frame.getHeight()/10));
		frame.add(specialChartPanel);
		cp.makeChart(stats, Chart.chartType.Special, specialChartPanel);
	}
	
	/**
	 * Metoda tworzy pasek postêpu wczytywania do bazy.
	 */
	
	public void setDefaultDataBaseProgressBarParam()
	{
		Border border = BorderFactory.createTitledBorder("Importowanie rekordów do bazy...");
		dataBaseProgress.setBorder(border);
		dataBaseProgress.setBackground(new Color(85,85,85));
		dataBaseProgress.setSize(frame.getWidth()-340, 40);
		dataBaseProgress.setLocation(10, wordsChartPanel.getHeight()+ whiteChartPanel.getHeight()+30);
		dataBaseProgress.setVisible(true);
		frame.add(dataBaseProgress);
	}
}
