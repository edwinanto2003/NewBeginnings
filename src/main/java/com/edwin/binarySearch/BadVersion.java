package com.edwin.binarySearch;

public class BadVersion
{
	int badVersion;
	
	public BadVersion(int b)
	{
		this.badVersion = b;
	}
	
	 public int firstBadVersion(int n) 
	    {
	        int start = 1;   
	        int end = n;
	        

	        while (start < end)
	        {
	            int mid = start + (end - start)/2;
	        
	            if (isBadVersion(mid))
	            {
	                end = mid ;
	            }else 
	            {
	                start = mid + 1;
	            }
	        }
	        
	        return start;
	    }

	private boolean isBadVersion(int b)
	{
		System.out.println("Called isBadVersion ");
		return b >= badVersion;
	}

	public static void main(String[] args)
	{
		BadVersion bb = new BadVersion(6);
		
		System.out.println(bb.firstBadVersion(25));
	}

}
