package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Controllers.Statistics;

/**
 * Klasa Wykresu.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class Chart extends JPanel 
{
	private static final long serialVersionUID = 3664721088482817163L;
	private double[] values;
	private String[] names;
	private String title;
	private int elementQuantity;
	private Color barColor = Color.BLUE;
	
	public static enum chartType
	{
		Word,Letter,Special,WhiteSpace
	}
	
	public Chart()
	{
		
	}
	
	public Chart(double[] v, String[] n, String t, int e) 
	{
		names = n;
		values = v;
		title = t;
		//Zabezpieczenie przed wprowadzeniem za du¿ej liczby elementów do wyœwietlenia
		if(e > values.length || e > names.length)
		{
			if(values.length > names.length)
				elementQuantity = names.length;
			else
				elementQuantity = values.length;
		}
		else
			elementQuantity = e;
	}
	public Chart(double[] v, String[] n, String t, int e, Color c) 
	{
		names = n;
		values = v;
		title = t;
		barColor = c;
		//Zabezpieczenie przed wprowadzeniem za du¿ej liczby elementów do wyœwietlenia
		if(e > values.length || e > names.length)
		{
			if(values.length > names.length)
				elementQuantity = names.length;
			else
				elementQuantity = values.length;
		}
		else
			elementQuantity = e;
		
	}
	
	public Chart(double[] v, String[] n, String t) 
	{
		names = n;
		values = v;
		title = t;
		elementQuantity = values.length;
	}
	
	/**	Metoda tworz¹ca wykres.
	 * 
	 * @param stats Statystyki
	 * @param type	Typ wykresu
	 * @param container Panel na wykres
	 */
	
	public void makeChart(Statistics stats, chartType type, JPanel container)
	{
		String label = "";
		if(type == chartType.Word)
		{
			label = "S³owa";
			values = new double[stats.getWordsList().size()];
		    names = new String[stats.getWordsList().size()];
			for(int i=0; i<stats.getWordsList().size();i++)
			{
				names[i] = stats.getWordsList().get(i).getWord();
				values[i] = (double) stats.getWordsList().get(i).getQuantity();
			}
		}
		else if(type == chartType.WhiteSpace)
		{
			label = "Bia³e znaki";
			values = new double[stats.getWhiteSpacesList().size()];
		    names = new String[stats.getWhiteSpacesList().size()];
			for(int i=0; i<stats.getWhiteSpacesList().size();i++)
			{
				names[i] = stats.getWhiteSpacesList().get(i).getWhiteSpaceName();
				values[i] = (double) stats.getWhiteSpacesList().get(i).getQuantity();
			}
		}
		else if(type == chartType.Letter)
		{
			label = "Litery";
			values = new double[stats.getLettersList().size()];
		    names = new String[stats.getLettersList().size()];
			for(int i=0; i<stats.getLettersList().size();i++)
			{
				names[i] = "" + stats.getLettersList().get(i).getCharacter();
				values[i] = (double) stats.getLettersList().get(i).getQuantity();
			}
		}
		else if(type == chartType.Special)
		{
			label = "Znaki Specjalne";
			values = new double[stats.getSpecialsList().size()];
		    names = new String[stats.getSpecialsList().size()];
			for(int i=0; i<stats.getSpecialsList().size();i++)
			{
				names[i] = "" + stats.getSpecialsList().get(i).getCharacter();
				values[i] = (double) stats.getSpecialsList().get(i).getQuantity();
			}
		}
		
		
		container.removeAll();
		container.add(new Chart(values,names,label,30,Color.BLUE));
		container.revalidate();
	}
	
	/**
	 * Metoda rysowania wykresu.
	 */

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Dimension d = getSize();
		int clientWidth = d.width;
		int clientHeight = d.height;
		
		//Skracanie zbyt d³ugich s³ów
		for (int i = 0; i < elementQuantity; i++) 
		{
			if(names[i].length() > 10)
			{
				names[i] = names[i].substring(0, 8);
				names[i] += "...";
			}
		}
		
		//Ustawienie czcionek i pobranie w³aœciwoœci czcionek
		Font titleFont = new Font("SansSerif", Font.BOLD, 20);
		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
		
		//Ustawienie koloru t³a i ramki
		g.setColor(this.getParent().getParent().getBackground());
		g.fillRect(0, 0, d.width, d.height);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		if(values == null || elementQuantity == 0 || values[0] == 0)
		{
			int titleWidth = titleFontMetrics.stringWidth("Brak elementów "+title);
			int y = titleFontMetrics.getAscent();
			int x = (clientWidth - titleWidth) / 2;
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("Brak elementów "+title, x, y);
			return;
		}
		
		double minValue = 0;
		double maxValue = 0;
		//Wybór maksymalnej i minimalnej wartoœci przed obliczeniem skali
		for (int i = 0; i < elementQuantity; i++) 
		{
			if (minValue > values[i])
				minValue = values[i];
			if (maxValue < values[i])
				maxValue = values[i];
		}
		
		//Liczenie szerokoœci s³upka
		int barWidth = clientWidth / elementQuantity;

		//Liczenie pozycji tytu³u i jego rysowanie
		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (clientWidth - titleWidth) / 2;
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString(title, x, y);
    
		//Liczenie D³ugoœci najd³u¿szego wyrazu z names w pikselach
		double minFontLength = 0;
		double maxFontLength = 0;
		for (int i = 0; i < elementQuantity; i++) {
			if (minFontLength > labelFontMetrics.stringWidth(names[i]))
				minFontLength = labelFontMetrics.stringWidth(names[i]);
			if (maxFontLength < labelFontMetrics.stringWidth(names[i]))
				maxFontLength = labelFontMetrics.stringWidth(names[i]);
		}

		//Wyliczenie obszaru na wykres
		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight()+10+(int)maxFontLength;
		if (maxValue == minValue)
			return;
		
		//Liczenie skali
		double scale = (clientHeight - top - bottom) / (maxValue - minValue);
		
		//Liczenie pionowej wspó³rzêdnej podpisów s³upków i ustawienie czcionki podpisów
		y = clientHeight - labelFontMetrics.getDescent()-10-(int)maxFontLength;
		g.setFont(labelFont);

		for (int i = 0; i < elementQuantity; i++) 
		{
			//Liczenie wspó³rzêdnych s³upka i wysokoœci
			int valueX = i * barWidth + (d.width-barWidth*elementQuantity)/2;
			int valueY = top;
			int height = (int) (values[i] * scale);
			if(i==0)
			{
				valueY-=1;
			}
			if (values[i] >= 0)
				valueY += (int) (scale * (maxValue - values[i]));
			else 
			{
				//Ujemna wysokoœæ dla ujemnej wartoœci
				valueY += (int) (maxValue * scale);
				height = -height;
			}
			
			//Rysowanie s³upka
			g.setColor(barColor);
			g.fillRect(valueX, valueY, barWidth - 2, height);
			g.setColor(Color.black);
			g.drawRect(valueX, valueY, barWidth - 2, height);
     
			//Rysowanie podpisu
			x = i * barWidth +(barWidth-labelFontMetrics.getDescent())/2+ (d.width-barWidth*elementQuantity)/2;
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(Math.toRadians(90), 0, 0);
			Font rotatedFont = labelFont.deriveFont(affineTransform);
			g.setFont(rotatedFont);
			g.drawString(names[i], x, y);
		}
	}
}