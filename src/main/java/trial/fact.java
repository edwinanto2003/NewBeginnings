package trial;

public class fact 
{
	public double factorial(int n) 
	{
		int fact = 1;
		
		// 5! = 5 * 4 * 3 * 2
		// 5! = 5 * 4! -> n * (n-1)!
		
		if (n <= 2)
			return n;
		
		return n * factorial(n-1);		
	}
	
	public static void main (String[] args)
	{
		fact f = new fact();
		System.out.println(f.factorial(56));
	}
}
