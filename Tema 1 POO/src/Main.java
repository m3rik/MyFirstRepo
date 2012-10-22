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
		Dictionary d = new Dictionary(args[0]);
		Trie t=d.getTrie();
		System.out.println("Avem " + d.getnumEntries() + " intrari in dictionar");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Interogare i=new Interogare(t);
		try {
			while ((s = in.readLine())!=null)
			{
				System.out.println(s);
				if(s.equals("exit")) break;
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
