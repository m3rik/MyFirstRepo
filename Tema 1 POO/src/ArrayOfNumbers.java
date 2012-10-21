import java.util.StringTokenizer;


public class ArrayOfNumbers {
	private int[] a;
	public ArrayOfNumbers(String line)
	{
		StringTokenizer st=new StringTokenizer(line);
		int i=0;
		
		try
		{ a=new int[st.countTokens()];}
		catch(Exception e)
		{	System.out.println("Exceptie: "+e);}
		
		 try
		 {
			 
			 while(st.hasMoreTokens())
			 {
				 a[i++]=Integer.parseInt(st.nextToken());
			 }
		 }
		 catch (Exception e)
		 {
		 	System.out.println("Exceptie: " + e);
		 }		 
	 }
	@Override
	public String toString()
	{
		String value="";
		for(int i=0;i<a.length;i++)
			value+=a[i];
		return value;
		
	}
	
}
