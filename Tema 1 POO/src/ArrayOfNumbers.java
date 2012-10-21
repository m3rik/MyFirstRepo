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
	public ArrayOfNumbers()
	{
		a=null;
	}
	public int getLength()
	{
		return a.length;
	}
	public int getIndex(int i)
	{
		return a[i];
	}
	private void addValue(int value)
	{
		if(a!=null)
		{
			int temp[] = a.clone();
			int i;
			a=new int[a.length+1];
			for(i=0;i<temp.length;i++)
				a[i]=temp[i];
			a[i]=value;
		}
		else
		{
			a=new int[1];
			a[0]=value;
		}
	}
	public ArrayOfNumbers OR (ArrayOfNumbers b)
	{
		ArrayOfNumbers result=new ArrayOfNumbers();
		int i=0,j=0;
		while(i<getLength()&&j<b.getLength())
		{
			if(getIndex(i)<b.getIndex(j)) result.addValue( getIndex(i++));
			else if(getIndex(i)>b.getIndex(j)) result.addValue(b.getIndex(j++));
			else i++;
		}
		while(i<getLength())
			result.addValue( getIndex(i++));
		while(j<b.getLength())
			 result.addValue(b.getIndex(j++));
		return result;
	}
	public ArrayOfNumbers AND (ArrayOfNumbers b)
	{
		ArrayOfNumbers result=new ArrayOfNumbers();
		int i=0,j=0;
		while(i<getLength()&&j<b.getLength())
		{
			if(getIndex(i)<b.getIndex(j)) i++;
			else if(getIndex(i)>b.getIndex(j)) j++;
			else {result.addValue(getIndex(i++));j++;}
		}
		
		return result;
	}
	
	@Override
	public String toString()
	{
		String value="";
		for(int i=0;i<a.length;i++)
			value+=a[i]+" ";
		return value;
		
	}
	
}
