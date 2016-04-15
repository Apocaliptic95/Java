package Views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Characters;
import Models.WhiteSpace;
import Models.Words;

/**
 * Klasa modelu tabel.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class FinalTableModel extends AbstractTableModel 
{

	private static final long serialVersionUID = 1L;

	public static enum tableType
	{
		Word,Letter,Special,WhiteSpace
	}
	
    private List<?> li = new ArrayList<Object>();
    private tableType type;
    
    private String[] columnNames;

    public FinalTableModel(List<?> list, tableType _type, String[] colNames)
    {
         li = list;
         type = _type;
         columnNames = colNames;
    }

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }

    @Override     
    public int getRowCount() {
        return li.size();
    }

    @Override        
    public int getColumnCount() {
        return 2; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
    	if(type == tableType.Word)
    	{
    		Words obj = (Words) li.get(rowIndex);
    		switch (columnIndex) {
            case 0: 
                return obj.getWord();
            case 1:
                return obj.getQuantity();
           }
           return null;
    	}
    	else if(type == tableType.Letter)
    	{
    		Characters obj = (Characters) li.get(rowIndex);
    		switch (columnIndex) {
            case 0: 
                return ""+obj.getCharacter();
            case 1:
                return obj.getQuantity();
           }
           return null;
    	}
    	else if(type == tableType.Special)
    	{
    		Characters obj = (Characters) li.get(rowIndex);
    		switch (columnIndex) {
            case 0: 
                return ""+obj.getCharacter();
            case 1:
                return obj.getQuantity();
           }
           return null;
    	}
    	else if(type == tableType.WhiteSpace)
    	{
    		WhiteSpace obj = (WhiteSpace) li.get(rowIndex);
    		switch (columnIndex) {
            case 0: 
                return obj.getWhiteSpaceName();
            case 1:
                return obj.getQuantity();
           }
           return null;
    	}
    	else
    		return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
             case 0:
               return String.class;
             case 1:
               return Integer.class;
             }
             return null;
      }
 }