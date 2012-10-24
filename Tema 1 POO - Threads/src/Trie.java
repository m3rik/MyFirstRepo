/**	Implementeaza conceptul Trie.
 * 
 * @author Urziceanu Paul
 * @version 1.0
 *
 */

public class Trie {

    private Trie[] t;
	private char c;
	private ArrayOfNumbers a;
	
	public Trie()
	{
		c=' ';
		a=null;
		t=null;
	}
	public Trie(char c)
	{
		this.c=c;
		a=null;
		t=null;
	}
	public Trie(char c, ArrayOfNumbers a, Trie[] t)
	{
		this.c=c;
		this.a=a;
		this.t=t;
	}
	private char getChar()
	{
		return c;
	}
	public void setArray(ArrayOfNumbers a)
	{
		this.a=a;
	}
	public ArrayOfNumbers getArray()
	{
		return a;
	}
	private Trie containsChar(char c)
	{
		if(t!=null)
			for(int i=0;i<t.length;i++)
			{
				if(t[i].getChar()==c) return t[i];
			}
		
		return null;
	}
	
	
	private Trie addTrie(char c)
	{
		if(t==null){
			t=new Trie[1];
			t[0]=new Trie(c);
			return t[0];
		}
		else
		{
			Trie[] aux=t.clone();
			int i;
			t = new Trie[aux.length+1];
			for(i=0;i<aux.length;i++)
				t[i]=aux[i];
			t[i]=new Trie(c);
			return t[i];
		}
		
	}
	public void addKey(String name,ArrayOfNumbers array)
	{
	
		Trie temp=containsChar(name.toCharArray()[0]);
		
		if (temp==null) temp=addTrie(name.toCharArray()[0]);
		
		if(name.toCharArray().length==1)temp.setArray(array);
		else temp.addKey(name.substring(1), array);
	}
	public ArrayOfNumbers findKey(String name)
	{
		Trie temp;
		try
		{
			temp = containsChar(name.toCharArray()[0]);
		}
		catch (Exception e)
		{
			System.out.println("Exceptie: " + e);
			temp=null;
		}
		
		if(temp==null)return null;
		else 
			if(name.toCharArray().length==1)
				return temp.getArray();
			else 
				return temp.findKey(name.substring(1));
						
	}
		

}