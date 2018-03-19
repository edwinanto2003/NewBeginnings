package trial;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci
{
	int[] fibVals = new int[60];
	
	public void printFib(int n)
	{
		int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < n; i++)
		{
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		for (int i = 0; i < n; i++)
			System.out.print(fib[i] + " ");
	}

	public int getFib(int n)
	{
		if (n <= 1)
			return n;
		else
			return getFib(n - 1) + getFib(n - 2);
	}

	public int getFibMem(int n)
	{
		if (n <= 1)
			return n;
		
		if (fibVals[n] == 0)
			return fibVals[n];
		else
		{
			fibVals[n] = getFibMem(n - 1) + getFibMem(n - 2);
			return fibVals[n];
		}
		
	}
	
	public static void main(String[] args)
	{
		Fibonacci f = new Fibonacci();
		f.printFib(10);
		System.out.println();
		System.out.println(f.getFibMem(60));

	}

}
