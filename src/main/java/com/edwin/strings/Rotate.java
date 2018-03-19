package com.edwin.strings;

public class Rotate
{

	   void reverse(char[] arr, int s, int e)
	    {
	        while (s < e)
	        {
	            char temp = arr[s];
	            arr[s] = arr[e];
	            arr[e] = temp;
	            s++; e--;
	        }
	    }
	    
	    String rotate(char[] arr, int k)
	    {
	        reverse(arr, 0, k - 1);
	        reverse(arr, k, arr.length -1);
	        reverse(arr, 0, arr.length -1);
	        
	        return new String(arr);
	    }
	    
	    public boolean rotateString(String A, String B) 
	    {
	        if (A == null && B != null)
	            return false;
	        
	        if (A.equals(B))
	            return true;
	        
	        int k = 1;
	        char[] aCArr = A.toCharArray();
	        while (k < A.length())
	        {
	            if (rotate(aCArr, 1).equals(B))
	                return true;
	            k++;
	        }
	   
	        return false;        
	    }
	public static void main(String[] args)
	{
		Rotate r = new Rotate();
		System.out.println(r.rotateString("gcmbf", "fgcmb"));
	}

}
