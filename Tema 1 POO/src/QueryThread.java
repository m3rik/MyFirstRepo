
public class QueryThread extends Thread{
	private Interogare i;
	public static int currentQuery=1;
	private int current;
	private String s;
	public boolean isFinished=false;
	public QueryThread(Interogare i,String s,int current)
	{
		this.i=i;
		this.s=s;
		this.current=current;
	}
	public void run()
	{
		ArrayOfNumbers answer=i.ask(s);
		while(current!=QueryThread.currentQuery);
		if(answer!=null)System.out.println(answer);
		else System.out.println("");
		QueryThread.currentQuery++;
		isFinished=true;
	}

}
