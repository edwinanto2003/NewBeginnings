package com.edwin.backtracking;

public class RecursionProbs
{
	String decimalToBinary(int n)
	{
		if (n/2 == 0)
			return Integer.toString(n%2);
		
		return decimalToBinary(n/2) + Integer.toString(n%2); 
	}
	
	int power(int n, int pow)
	{
		if (pow == 1)
			return n;
		
		return n * power(n, pow-1);
	}
	
	
	int sum(int n)
	{
		if (n%10 == 0)
			return n;
		return (n%10) + sum(n/10);
	}

	public static void main(String[] args)
	{
		RecursionProbs s= new RecursionProbs();
		
		System.out.println(s.sum(25));
		
		System.out.println(s.decimalToBinary(15));
		
		System.out.println(s.power(7, 2));
	}

}
