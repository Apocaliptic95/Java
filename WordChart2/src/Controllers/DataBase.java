package Controllers;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Models.Characters;
import Models.WhiteSpace;
import Models.Words;
import Views.Window;

/** Klasa odpowiedzialna za po³¹czenie z baz¹ danych.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 *
 */

public class DataBase
{
	private Connection conection = null;
	
	public DataBase(String name)
	{
		try 
	    {
	      Class.forName("org.sqlite.JDBC");
	      conection = DriverManager.getConnection("jdbc:sqlite:"+name+".db");
	    } 
	    catch ( Exception e ) 
	    {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	 }
	
	/**
	 * Metoda buduj¹ca tabele w bazie.
	 */
	  
	 public void createTables()  
	 {
		 String createWords = "CREATE TABLE IF NOT EXISTS words (word varchar(255), quantity int)";
	     String createLetters = "CREATE TABLE IF NOT EXISTS letters (letter char, quantity int)";
	     String createSpecials = "CREATE TABLE IF NOT EXISTS specials (special char, quantity int)";
	     String createWhiteSpaces = "CREATE TABLE IF NOT EXISTS whitespaces (whitespacename varchar(255), whitespace char, quantity int)";
	     try 
	     {
        	Statement statement = conection.createStatement();
            statement.execute(createWords);
            statement.execute(createLetters);
            statement.execute(createSpecials);
            statement.execute(createWhiteSpaces);
	     } 
	     catch (Exception e) 
	     {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
	     }
	 }
	 
	 /** Typy danych.
	  */
	 
	 public static enum dataType
	 {
		  Word,Letter,Special,WhiteSpace
	 }
	  
	 /** Metoda zwraca listê danego typu.
	  * @param type Typ danych który ma byæ zwrócony.
	  * @return Lista danych pobranych z bazy.
	  */
	  public ArrayList<?> getData(dataType type)
	  {
		  try{
			  if(type == dataType.Word)
			  {
				  Statement statement = conection.createStatement();
			      ResultSet result = statement.executeQuery("SELECT * FROM words;");
			      ArrayList<Words> lista = new ArrayList<Words>();
			      while ( result.next() ) {
			    	  lista.add(new Words(result.getString("word"), result.getInt("quantity")));
			      }
			      result.close();
			      statement.close();
			      return lista;
			  }
			  
			  if(type == dataType.Letter)
			  {
				  Statement statement = conection.createStatement();
			      ResultSet result = statement.executeQuery("SELECT * FROM letters;");
			      ArrayList<Characters> lista = new ArrayList<Characters>();
			      while ( result.next() ) {
			    	  lista.add(new Characters(result.getString("letter").charAt(0), result.getInt("quantity")));
			      }
			      result.close();
			      statement.close();
			      return lista;
			  }
			  
			  if(type == dataType.Special)
			  {
				  Statement statement = conection.createStatement();
			      ResultSet result = statement.executeQuery("SELECT * FROM specials;");
			      ArrayList<Characters> lista = new ArrayList<Characters>();
			      while ( result.next() ) {
			    	  lista.add(new Characters(result.getString("special").charAt(0), result.getInt("quantity")));
			      }
			      result.close();
			      statement.close();
			      return lista;
			  }
			  
			  if(type == dataType.WhiteSpace)
			  {
				  Statement statement = conection.createStatement();
			      ResultSet result = statement.executeQuery("SELECT * FROM whitespaces;");
			      ArrayList<WhiteSpace> lista = new ArrayList<WhiteSpace>();
			      while ( result.next() ) {
			    	  lista.add(new WhiteSpace(result.getString("whitespacename"),result.getString("whitespace").charAt(0), result.getInt("quantity")));
			      }
			      result.close();
			      statement.close();
			      return lista;
			  }
			  else
				  return null;
		  }
		  catch ( Exception e ) 
		  {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      createTables();
		      System.exit(0);
		      return null;
		  }
	  }
	  
	  /** Metoda importuj¹ca statystyki do bazy danych. Dzia³a w odrêbnym w¹tku.
	   * 
	   * @param stats	Statystyki do zaimportowania.
	   * @param w 		Klasa okna zawieraj¹ca progressBar
	   */
	  
	  public void insertStatistics(Statistics stats,Window w)
	  {
		  Runnable runner = new Runnable()
		   {
		        public void run() 
		        {
			        try 
			        {
			        	w.getDataBaseButton().setEnabled(false);
			        	int elementQuantity = stats.getWordsList().size() + stats.getLettersList().size() + stats.getSpecialsList().size() + stats.getWhiteSpacesList().size();
			        	int currentElement = 0;
			        	Statement statement = conection.createStatement();
			        	for(int i=0; i<stats.getWordsList().size(); i++,currentElement++)
			        	{
			        		String findWords = "SELECT word ,quantity FROM words WHERE word = '"+stats.getWordsList().get(i).getWord()+"';";
			        		ResultSet result = statement.executeQuery(findWords);
			        		if(result.isAfterLast())
			        		{
			        			String addWords = "INSERT INTO words (word, quantity) VALUES('"+stats.getWordsList().get(i).getWord()+"','"+stats.getWordsList().get(i).getQuantity()+"')";
			        			statement.execute(addWords);
			        		}
			        		else
			        		{
			        			String updateWords = "UPDATE words SET quantity = '"+(stats.getWordsList().get(i).getQuantity()+result.getInt("quantity"))+"' WHERE word = '"+result.getString("word")+"';";
			        			statement.execute(updateWords);
			        		}
			        		Border border = BorderFactory.createTitledBorder("Importowanie rekordów do bazy (S³owa)...");
			        		w.getDataBaseProgressBar().setBorder(border);
			        		w.getDataBaseProgressBar().setValue((int)(100*((double)currentElement/(double)elementQuantity)));
			        		w.getDataBaseProgressBar().update(w.getDataBaseProgressBar().getGraphics());
			        	}

			        	for(int i=0; i<stats.getLettersList().size(); i++,currentElement++)
			        	{
			        		String findLetters = "SELECT letter, quantity FROM letters WHERE letter = '"+stats.getLettersList().get(i).getCharacter()+"';";
			        		ResultSet result = statement.executeQuery(findLetters);
			        		if(result.isAfterLast())
			        		{
			        			String addLetters = "INSERT INTO letters (letter, quantity) VALUES('"+stats.getLettersList().get(i).getCharacter()+"','"+stats.getLettersList().get(i).getQuantity()+"')";
				        		statement.execute(addLetters);
			        		}
			        		else
			        		{
			        			String updateLetters = "UPDATE letters SET quantity = '"+(stats.getLettersList().get(i).getQuantity()+result.getInt("quantity"))+"' WHERE letter = '"+result.getString("letter")+"';";
			        			statement.execute(updateLetters);
			        		}
			        		Border border = BorderFactory.createTitledBorder("Importowanie rekordów do bazy (Litery)...");
			        		w.getDataBaseProgressBar().setBorder(border);
			        		w.getDataBaseProgressBar().setValue((int)(100*((double)currentElement/(double)elementQuantity)));
			        		w.getDataBaseProgressBar().update(w.getDataBaseProgressBar().getGraphics());
			        	}
			        	
			        	for(int i=0; i<stats.getWhiteSpacesList().size(); i++,currentElement++)
			        	{
			        		String findWhiteSpaces = "SELECT whitespacename, quantity FROM whitespaces WHERE whitespacename = '"+stats.getWhiteSpacesList().get(i).getWhiteSpaceName()+"';";
			        		ResultSet result = statement.executeQuery(findWhiteSpaces);
			        		if(result.isAfterLast())
			        		{
			        			String addWhiteSpaces = "INSERT INTO whitespaces (whitespacename, whitespace, quantity) VALUES('"+stats.getWhiteSpacesList().get(i).getWhiteSpaceName()+"','"+stats.getWhiteSpacesList().get(i).getWhiteSpace()+"','"+stats.getWhiteSpacesList().get(i).getQuantity()+"')";
				        		statement.execute(addWhiteSpaces);
			        		}
			        		else
			        		{
			        			String updateWhiteSpaces = "UPDATE whitespaces SET quantity = '"+(stats.getWhiteSpacesList().get(i).getQuantity()+result.getInt("quantity"))+"' WHERE whitespacename = '"+result.getString("whitespacename")+"';";
			        			statement.execute(updateWhiteSpaces);
			        		}
			        		Border border = BorderFactory.createTitledBorder("Importowanie rekordów do bazy (Bia³e Znaki)...");
			        		w.getDataBaseProgressBar().setBorder(border);
			        		w.getDataBaseProgressBar().setValue((int)(100*((double)currentElement/(double)elementQuantity)));
			        		w.getDataBaseProgressBar().update(w.getDataBaseProgressBar().getGraphics());
			        	}
			        	
			        	for(int i=0; i<stats.getSpecialsList().size(); i++,currentElement++)
			        	{
			        		String SQL = "SELECT special, quantity FROM specials WHERE special = ?;";
			        		PreparedStatement selectPreparedStatement = conection.prepareStatement(SQL);
			        		selectPreparedStatement.setString(1, ""+ stats.getSpecialsList().get(i).getCharacter());
			        		ResultSet result = selectPreparedStatement.executeQuery();
			        		
			        		if(result.isAfterLast())
			        		{
				        		SQL = "INSERT INTO specials (special, quantity) VALUES(?,?)";
				        		PreparedStatement insertPreparedStatement = conection.prepareStatement(SQL);
				        		insertPreparedStatement.setString(1, ""+stats.getSpecialsList().get(i).getCharacter());
				        		insertPreparedStatement.setString(2, ""+stats.getSpecialsList().get(i).getQuantity());
				        		insertPreparedStatement.executeUpdate();
			        		}
			        		else
			        		{
			        			SQL = "UPDATE specials SET quantity = ? WHERE special= ?;";
				        		PreparedStatement updatePreparedStatement = conection.prepareStatement(SQL);
				        		updatePreparedStatement.setString(1, ""+stats.getSpecialsList().get(i).getQuantity()+result.getInt("quantity"));
				        		updatePreparedStatement.setString(2, ""+result.getString("special"));
				        		updatePreparedStatement.executeUpdate();
			        		}
			        		Border border = BorderFactory.createTitledBorder("Importowanie rekordów do bazy (Znaki Specjalne)...");
			        		w.getDataBaseProgressBar().setBorder(border);
			        		w.getDataBaseProgressBar().setValue((int)(100*((double)currentElement/(double)elementQuantity)));
			        		w.getDataBaseProgressBar().update(w.getDataBaseProgressBar().getGraphics());
			        	}
			        	
			        	w.getDataBaseProgressBar().setValue(100);
		        		w.getDataBaseProgressBar().update(w.getDataBaseProgressBar().getGraphics());
			        	w.getDataBaseButton().setEnabled(true);
		    	        w.getDataBaseProgressBar().setVisible(false);
			        } 
			        catch (Exception e) 
			        {
			            System.err.println("B³ad przy tworzeniu tabeli.");
			            e.printStackTrace();
			        }
				}
		    };
		    Thread thread = new Thread(runner);
		    thread.start();
	  }
}
