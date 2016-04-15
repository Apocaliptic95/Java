package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Views.FinalTableModel.tableType;

/**
 * Klasa tabel.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class Table 
{
	public void createTable(String[] colNames, List<?> data, JPanel container,tableType type)
	{
		JTable table = new JTable();
		table.getAutoscrolls();
		table.setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setForeground(Color.black);
		table.setEnabled(false);
		table.setShowVerticalLines(false);
		table.setModel(new FinalTableModel(data,type,colNames));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.setBackground(new Color(85,85,85));
		
		container.setLayout(new BorderLayout());
		container.setBackground(new Color(85,85,85));
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.getViewport().setBackground(new Color(85,85,85));
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.setViewportBorder(BorderFactory.createLineBorder(table.getGridColor()));
		
		container.add(scroll);
	}
}
