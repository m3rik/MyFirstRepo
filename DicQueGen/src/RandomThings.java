import java.util.Random;


public class RandomThings {
	static public Random gen=new Random();
	static public String nextString()
	{
		char[] value;
		value=new char[gen.nextInt(8)+8];
		String result="";
		for(int i=0;i<value.length;i++)
		{
			value[i]=(char)(gen.nextInt(26)+97);
			result+=value[i];
		}	
		return result;
		
		
	}
	static public String nextArray()
	{
		int[] value;
		value=new int[gen.nextInt(15)+5];
		value[0]=gen.nextInt(5);
		String result="";
		for(int i=1;i<value.length;i++)
		{
			value[i]=gen.nextInt(5)+value[i-1]+1;
			result+=value[i]+" ";
		}
		return result;
		
	}
}
