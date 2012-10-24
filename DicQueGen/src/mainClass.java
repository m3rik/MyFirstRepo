
import java.io.*;

public class mainClass {
	
	public static void main(String args[]) throws IOException
	{
		FileWriter fstream = new FileWriter("dictMillion.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		for(long i=0;i<1000000;i++)
		{
			out.write(RandomThings.nextString()+" "+RandomThings.nextArray()+"\n");
		}
		out.close();
		
	}
}
