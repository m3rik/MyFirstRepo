import java.io.*;
/**
 * 
 * Clasa Main
 * 
 * @author Andru
 *
 */
public class Main {
	
	/**
	 * 
	 * Metoda main
	 * 
	 * @param args
	 * Argumentele primite de program
	 */
	public static void main(String[] args) {
		Dictionary d;
		/** Folosim try/catch pentru a verifica daca am primit ca argument un string.
		 * 
		 */
		try
		{
			d = new Dictionary(args[0]);
		}
		catch (Exception e)
		{
			System.out.println("Exceptie: " + e);
			return;
		}
		
		Trie t=d.getTrie();
		
		System.out.println("Avem " + d.getnumEntries() + " intrari in dictionar");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Interogare i=new Interogare(t);
		
		try {
			while ((s = in.readLine())!=null)
			{
				if(s.equals("exit")) break;
				
				if(s.length()>0)
				{
					ArrayOfNumbers answer=i.ask(s);
					if(answer!=null)System.out.println(answer);
					else System.out.println("");
				}
				
			}
						
			
		} catch (IOException e) {
			System.out.println("Exception IO: " + e);
		}
		finally
		{
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("Exception IO: " + e);
			}
		}
	}

}
