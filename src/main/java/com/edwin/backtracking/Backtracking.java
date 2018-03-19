package com.edwin.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking
{
	//=================   Subsets   ==============================================
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//  Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<Integer>(tempList));
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	//==============================================================================

	//=================   Permutations   ==============================================
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<Integer>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		if((tempList.size() == nums.length)){
			list.add(new ArrayList<Integer>(tempList));
		} else{
			for(int i = 0; i < nums.length; i++){ 
				if(!tempList.contains(nums[i])) // element already exists, skip
				{
					tempList.add(nums[i]);
					backtrack(list, tempList, nums);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	} 
	//=====================================================================================

	//=================   Combinations sum   ==============================================
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<Integer>(tempList));
		else{ 
			for(int i = start; i < nums.length; i++){
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	//=====================================================================================
	
	
	 private static final String[] map = {"","","abc","def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
	    public List<String> letterCombinations(String digits) 
	    {
	        List<String> combinations = new ArrayList<String>();
	        if (digits.isEmpty())
	            return combinations;
	        letterCombinations(digits, combinations, 0, new StringBuilder());
	        return combinations;
	    }
	    
	    private void letterCombinations(String digits, List<String> combinations, int index, StringBuilder sb) 
	    {
	        if (index == digits.length())
	            combinations.add(sb.toString());
	        else {
	            int digit = digits.charAt(index) - '0';
	            String chars = map[digit];
	            for (int i = 0; i < chars.length(); i++) 
	            {
	                sb.append(chars.charAt(i));
	                letterCombinations(digits, combinations, index + 1, sb);
	                sb.setLength(sb.length() - 1);
	            }
	        }
	    }

	public static void main(String[] args)
	{
		Backtracking bt = new Backtracking();

		String digits = "12";
		
		int dVal = digits.charAt(0) - '0';
		System.out.println(dVal);
		
		dVal = digits.charAt(1) - '0';
		System.out.println(dVal);
		
		
		char c = 'a';
		System.out.println("");
		System.out.println(c^'b');
		
		System.out.println(bt.subsets(new int[]{1,2,3}));

	//	System.out.println(bt.permute(new int[]{1,2,3}));

	//	System.out.println(bt.combinationSum(new int[]{1,2,3,6,7}, 7));
	}

}
