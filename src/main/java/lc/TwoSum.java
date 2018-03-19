package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are not zero-based.
	
	You may assume that each input would have exactly one solution and you may not use the same element twice.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 * 
 * @author Edwin Anto
 */
public class TwoSum
{
	 public int[] twoSum(int[] nums, int target) 
	    {
	        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < nums.length; i++)
	        {
	            myMap.put(nums[i], i);   
	        }
	        
	        for (int j = 0; j < nums.length; j++)
	        {
	            if(myMap.get(target - nums[j]) != null)
	            {
	                if(j != myMap.get(target - nums[j]))
	                    return new int[]{j, myMap.get(target - nums[j])};
	            }
	        }
	        
	        return null;
	    }
	 
	 public static void main(String[] args)
	 {
		 TwoSum ts = new TwoSum();
		 
		 int[] inds = ts.twoSum(new int[]{3,2,4}, 6);
		 System.out.println(inds[0] + " " + inds[1]);
	 }
}
