package com.edwin.strings;

public class ReverseString
{
	
	//// <https://leetcode.com/problems/reverse-string-ii/description/>
	 void reverse(char[] sCArr, int s, int e)
	    {
	        while (s<e)
	        {
	            char temp = sCArr[s];
	            sCArr[s] = sCArr[e];
	            sCArr[e] = temp;
	            s++; e--;
	        }
	    }
	    
	    public String reverseStr(String s, int k) 
	    {
	        if(s == null || s.length() ==1)
	            return s;
	        
	        int sInd = 0;
	        char[] sCArr = s.toCharArray();
	        int i = 0;
	        while (i < s.length())
	        {
	            if ((sInd + k - 1) >= s.length())
	            {
	                reverse (sCArr, sInd, s.length() -1);
	                break;
	            }else
	            {
	                reverse(sCArr, sInd, sInd + k - 1);
	            }
	            i = i + 2*k;
	            sInd = i;
	        }
	        return new String(sCArr);
	    }
	    
	   ///////</https://leetcode.com/problems/reverse-string-ii/description// 

	public static void main(String[] args)
	{
		ReverseString rs = new ReverseString();
		
		// https://leetcode.com/problems/reverse-string-ii/description/
		String s = "abcdefg";
		int k = 8;
		System.out.println(rs.reverseStr(s, k));
		
		

	}

}
