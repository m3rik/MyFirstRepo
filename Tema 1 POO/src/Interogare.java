import java.util.StringTokenizer;


public class Interogare {
	private Trie t;
	private Trie aux;
	
	public Interogare(Trie t)
	{
		this.t=t;
		aux=new Trie();
	}
	
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
	
	public ArrayOfNumbers ask(String s)
	{
		int index=0;
		if(s.lastIndexOf('(')==-1)
			return t.findKey(s);
	
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
