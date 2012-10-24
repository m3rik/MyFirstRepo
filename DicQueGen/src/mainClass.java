
import java.io.*;

public class mainClass {
	
	public static void main(String args[]) throws IOException
	{
		FileWriter fstream = new FileWriter("FourZero.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		FileWriter qstream = new FileWriter("query_FourZero.txt");
		BufferedWriter q_out = new BufferedWriter(qstream);
		
		String[] cuvinte=new String[100];
		
		for(int i=0;i<200000;i++)
		{
			cuvinte[i%100]=RandomThings.nextString();
			out.write(cuvinte[i%100]+" "+RandomThings.nextArray()+"\n");
			if(i>100 && i%3==0)
			{
				int total=RandomThings.gen.nextInt(15);
				String query="";
				query=cuvinte[RandomThings.gen.nextInt(100)];
				for(int j=0;j<total;j++)
				{
					if(RandomThings.gen.nextBoolean())
					{
						if(RandomThings.gen.nextBoolean()) query="("+ query + " and " + cuvinte[RandomThings.gen.nextInt(100)] + ")";
						else query="("+ query + " or " + cuvinte[RandomThings.gen.nextInt(100)] + ")";
					}
					else
					{
						if(RandomThings.gen.nextBoolean()) query="("+  cuvinte[RandomThings.gen.nextInt(100)] + " and " + query +  ")";
						else query="("+ cuvinte[RandomThings.gen.nextInt(100)] + " or " + query + ")";
					}
				}
				q_out.write(query+"\n");
				
			}
		}
		q_out.write("exit"+"\n");
		out.close();
		q_out.close();
		
	}
}
