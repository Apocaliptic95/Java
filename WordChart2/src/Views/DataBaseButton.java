package Views;

/**
 * Klasa przycisku bazy danych.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Controllers.DataBase;
import Controllers.DataBase.dataType;
import Controllers.Statistics;
import Models.Characters;
import Models.WhiteSpace;
import Models.Words;

public class DataBaseButton extends JButton
{
	private static final long serialVersionUID = 1L;
	private Window w;

	DataBaseButton(Window _w)
	{
		w=_w;
		setText("Statystyka zbiorcza");
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
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e)
			{
				Statistics stats = new Statistics();
				DataBase DB = new DataBase("statistics");
				
				stats.setWordsList((ArrayList<Words>)DB.getData(dataType.Word));
				stats.setLettersList((ArrayList<Characters>)DB.getData(dataType.Letter));
				stats.setSpecialsList((ArrayList<Characters>)DB.getData(dataType.Special));
				stats.setWhiteSpacesList((ArrayList<WhiteSpace>)DB.getData(dataType.WhiteSpace));
				
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
			}
		});
	}
}
