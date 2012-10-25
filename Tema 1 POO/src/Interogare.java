import java.util.StringTokenizer;
/**Clasa interogare se ocupa cu rezolvarea stringului citit si interogarea instantei Trie.
 * Clasa salveaza anumite rezultate intr-un obiect de tip Trie auxiliar.
 * 
 * @author Urziceanu Paul
 *
 */

public class Interogare {
	private Trie t;
	private Trie aux;
	
	/**
	 * initializeaza un obiect aux de tip Trie pentru rezultate temporare
	 * @param t - instanta clasei Trie unde se vor cauta informatiile
	 */
	public Interogare(Trie t)
	{
		this.t=t;
	}
	/**
	 * Evalueaza o interogare simpla de tipul "a AND b" sau "a or b"
	 * 
	 * @param s - String-ul care contine interogarea dorita
	 * @return - returneaza rezultatul de tip ArrayOfNumbers
	 */
	private ArrayOfNumbers evaluate(String s)
	{
		
		StringTokenizer st=new StringTokenizer(s);
		ArrayOfNumbers a,b;
		String aName,operator,bName;
		try
		{
			aName=st.nextToken();
			operator=st.nextToken();
			bName=st.nextToken();
			a=t.findKey(aName);
			if(a==null)a=aux.findKey(aName);
			b=t.findKey(bName);
			if(b==null)b=aux.findKey(bName);
			
			if((a==null||b==null) && operator.equals("and"))return null;
			if(a==null&&operator.equals("or")) return b;
			if(b==null&&operator.equals("or")) return a;
			
			if(operator.equals("and"))return a.AND(b);
			else return a.OR(b);
			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Exceptie: " + e);
		}
		return null;
		
	}
	/**
	 * Functia care proceseaza orice tip de interogare si returneaza rezultatul sub forma unui obiect de tip ArrayOfNumbers
	 * @param s - Stringul care contine interogarea introdusa de la tastatura
	 * @return - intoarce rezultatul sub forma unui obiect de tip ArrayOfNumbers
	 */
	public ArrayOfNumbers ask(String s)
	{
		int index=0;
		Trie aux=new Trie();
		/**
		 * Daca nu exista nicio paranteza inseamna ca avem o interogare de un singur element.
		 */
		if(s.lastIndexOf('(')==-1)
			return t.findKey(s);
	
		/**
		 * Bucla care se ocupa cu procesatul interogarii.
		 * EX: ((ana and andrei) or (ion and dan))  
		 * primul pas: ia ultima paranteza rotunda '(' si prima ')' de dupa si va folosi evaluate("ion and dan")
		 * stringul nostru devine: ((ana and andrei) or _1)
		 * _1 este adaugat in aux de tip Trie impreuna cu ArrayOfNumbers calculata de evaluate.
		 * al 2 lea pas similar: (_2 or _1)
		 * si in final _3 care o sa-l gasim in aux
		 */
		while(s.lastIndexOf('(')!=-1)
		{
			int b=s.lastIndexOf('('), e=s.indexOf(')',b);
			
			aux.addKey("_"+index, evaluate(s.substring(b+1,e)));
			s=s.substring(0,b)+"_"+index +s.substring(e+1, s.length());
			index++;
		}
		return aux.findKey(s);
	}
}
