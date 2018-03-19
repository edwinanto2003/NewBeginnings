package trial;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
	
	
	public static int findItClever(int[] A)
	{
		int xor =0;
		
		for (int i = 0; i < A.length; i++)
			xor ^= A[i];
		
		return xor;
	}
	
	public static int findIt(int[] A) 
	{
		Set<Integer> vals = new HashSet<Integer>();
		for (int i = 0 ;i < A.length; i++)
		{
			if (vals.contains(A[i]))
				vals.remove(A[i]);
			else
				vals.add(A[i]);
		}
		Iterator<Integer> it =  vals.iterator();
		return it.next(); 
	}
	public static void main(String[] args) 
	{
		System.out.println(Test.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));

		System.out.println(Test.findItClever(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));	

	}

}
