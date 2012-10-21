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
		System.out.println(t.findKey("maria"));
	}

}
