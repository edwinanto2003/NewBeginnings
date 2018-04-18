package com.edwin.backtracking;

public class Permutation
{
	int count = 0;
	private void permuteHelper(String s, String chosen)
	{		
		System.out.println("PermuteHelper: " + s + ", " + chosen);
		
		if (s.isEmpty())
		{
			count++;
			System.out.println(chosen);
			return;
		}

		for (int i = 0; i < s.length(); i++)
		{
//			char c = s.charAt(i);
//			
//			chosen += c;
//			
//			s = s.substring(i + 1);
//			permuteHelper(s, chosen);
//			
//			s = c + s;
//			chosen = chosen.substring(0, chosen.length() - 1);
			
			permuteHelper(s.substring(0, i) + s.substring(i+1), chosen + s.charAt(i));
			
		}
	}

	private void permute(String s)
	{
		permuteHelper(s, "");

		System.out.println("count: " + count);
		//permute("", s);
	}
	
	private void permute(String soFar, String rem){
		if(rem.isEmpty()){
			System.out.println(soFar);
			return;
		}
		
		for(int i=0; i<rem.length(); i++){
			permute(soFar + rem.charAt(i), rem.substring(0,i) + rem.substring(i+1));
		}
	}
	

	public static void main(String[] args)
	{
		Permutation p = new Permutation();
		p.permute("EDWIN");

	}

}
