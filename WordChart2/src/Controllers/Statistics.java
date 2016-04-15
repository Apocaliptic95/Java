package Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Models.Characters;
import Models.WhiteSpace;
import Models.Words;

/**	Klasa tworz¹ca statystyki.
 * 
 * @author Sebastian Majewski
 * @version 1.0
 *
 */

public class Statistics 
{
	private List<Words> wordsList = new ArrayList<Words>();
	private List<Characters> lettersList = new ArrayList<Characters>();
	private List<Characters> specialList = new ArrayList<Characters>();
	private List<WhiteSpace> whiteSpacesList;
	private String content;
	
	public Statistics(String contents)
	{
		content = contents;
		content = content.toLowerCase();
		whiteSpacesList = WhiteSpace.createWhiteSpacesList();
		getStatistics();
		Collections.sort(wordsList);
		Collections.sort(lettersList);
		Collections.sort(specialList);
		Collections.sort(whiteSpacesList);
	}
	
	public Statistics()
	{
	}
	
	public List<Words> getWordsList()
	{
		return wordsList;
	}
	
	public List<Characters> getLettersList()
	{
		return lettersList;
	}
	
	public List<WhiteSpace> getWhiteSpacesList()
	{
		return whiteSpacesList;
	}
	
	public List<Characters> getSpecialsList()
	{
		return specialList;
	}
	
	public void setWordsList(ArrayList<Words> list)
	{
		wordsList=list;
		Collections.sort(wordsList);
	}
	
	public void setLettersList(ArrayList<Characters> list)
	{
		lettersList=list;
		Collections.sort(lettersList);
	}
	
	public void  setWhiteSpacesList(ArrayList<WhiteSpace> list)
	{
		whiteSpacesList=list;
		Collections.sort(whiteSpacesList);
	}
	
	public void setSpecialsList(ArrayList<Characters> list)
	{
		specialList=list;
		Collections.sort(specialList);
	}
	
	/**	Metoda sprawdzaj¹ca czy znak nale¿y do specjalnych.
	 * 
	 * @param s Znak do sprawdzenia.
	 * @return	Spe³nienie warunku.
	 */
	
	private boolean isSpecial(char s)
	{
		if(!Character.isDigit(s) 
				&& !Character.isLetter(s) 
				&& !Character.isWhitespace(s))
			return true;
		else
			return false;
	}
	
	/**
	 * Metoda tworz¹ca statystykê.
	 */
	
	private void getStatistics()
	{
		String tempWord = "";
		boolean founded = false; 
		for(int i=0; i<content.length(); i++)
		{
			if(Character.isLetter(content.charAt(i)))
			{
				if(!isSpecial(content.charAt(i)))
				{
					tempWord += content.charAt(i);
				}
				Characters ch = new Characters();
				ch.setCharacter(content.charAt(i));
				
				int index=0;
				
				if(!lettersList.isEmpty())
				{
					for(Characters d : lettersList)
					{
						if(d.getCharacter() == ch.getCharacter())
						{
							index = lettersList.indexOf(d);
							ch = lettersList.get(index);
							ch.setQuantity(ch.getQuantity()+1);
							lettersList.set(index, ch);
							founded = true;
							break;
				        }
				    }
					if(!founded)
					{
						ch.setQuantity(1);
						lettersList.add(ch);
					}
					founded = false;
				}
				else
				{
					ch.setQuantity(1);
					lettersList.add(ch);
				}
			}
			
			if(Character.isWhitespace(content.charAt(i)))
			{
				WhiteSpace ws = new WhiteSpace();
				ws.setWhiteSpace(content.charAt(i));
				
				int index=0;
			
				if(!whiteSpacesList.isEmpty())
				{
					for(WhiteSpace d : whiteSpacesList)
					{
						if(d.getWhiteSpace() == ws.getWhiteSpace())
						{
							index = whiteSpacesList.indexOf(d);
							ws = whiteSpacesList.get(index);
							ws.setQuantity(ws.getQuantity()+1);
							whiteSpacesList.set(index, ws);
							break;
				        }
				    }
				}
				index = 0;
			}

			if(tempWord.length() > 1 
					&& (i != content.length()-1 
					&& (Character.isWhitespace(content.charAt(i+1)) 
					|| isSpecial(content.charAt(i+1)))
					|| i == content.length()-1)
					)
			{
				Words wd = new Words();
				wd.setWord(tempWord.toLowerCase());
				
				int index=0;
				if(!wordsList.isEmpty())
				{
					for(Words d : wordsList)
					{
						if(d.getWord().equals(wd.getWord()))
						{
							index = wordsList.indexOf(d);
							wd = wordsList.get(index);
							wd.setQuantity(wd.getQuantity()+1);
							wordsList.set(index, wd);
							founded = true;
							break;
				        }
				    }
					if(!founded)
					{
						wd.setQuantity(1);
						wordsList.add(wd);
					}
					founded = false;
				}
				else
				{
					wd.setQuantity(1);
					wordsList.add(wd);
				}
				founded = false;
				index = 0;
				tempWord = "";
			}
			
			if(isSpecial(content.charAt(i)))
			{
				Characters sp = new Characters();
				sp.setCharacter(content.charAt(i));
				
				int index=0;
				
				if(!specialList.isEmpty())
				{
					for(Characters d : specialList)
					{
						if(d.getCharacter() == sp.getCharacter())
						{
							index = specialList.indexOf(d);
							sp = specialList.get(index);
							sp.setQuantity(sp.getQuantity()+1);
							specialList.set(index, sp);
							founded = true;
							break;
				        }
				    }
					if(!founded)
					{
						sp.setQuantity(1);
						specialList.add(sp);
					}
					founded = false;
				}
				else
				{
					sp.setQuantity(1);
					specialList.add(sp);
				}
			}
		}
	}
}
