import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 * 
 * Clasa ce defineste tipul dictionar
 * 
 * @author Andru
 *
 */
public class Dictionary {
	
	/**
	 * 
	 * Numarul de intrari din dictionar
	 * 
	 */
	private int numEntries = 0;
	private Trie t=new Trie();
	
	/**
	 * 
	 * Constructor pentru dictionar. Primeste ca parametru numele fisierului text (dictionarului) si il citeste linie cu linie
	 * 
	 * @param inputFile
	 * Numele fisierului text
	 */
	public Dictionary(String inputFile) {
		try{
			File dictFile = new File(inputFile);
			Scanner reader = new Scanner(dictFile);
			String strLine;
			
 			while (reader.hasNextLine()) {
				strLine = reader.nextLine(); // in strLine este linia curenta din dictionar
				System.out.println(strLine);
				numEntries++;
				// TO DO: aici veti procesa fiecare linie din dictionar
				// HINT: String tokenizer
				StringTokenizer st=new StringTokenizer(strLine);
				String name=st.nextToken();
				try
				{
					t.addKey(name, new ArrayOfNumbers(strLine.substring(name.length()+1)));
				}
				catch (Exception e)
				{
					System.out.println("Exceptie: "+ e);
				}
				
			}
			reader.close();
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * Metoda ce returneaza numarul de intrari din dictionar
	 * 
	 * @return
	 * Numarul de intrari din dictionar
	 */
	public int getnumEntries() {
		return numEntries;
	}
	public Trie getTrie() {
		return t;
	}
}
