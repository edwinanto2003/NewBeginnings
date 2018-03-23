package com.edwin.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon
{
	// Returns maximum sum in a subarray of size k.
		int maxSum(int arr[], int n, int k)
		{
			// Initialize result
			int max_sum = Integer.MIN_VALUE ;

			// Consider all blocks starting with i.
			for (int i=0; i<n-k+1; i++)
			{
				int current_sum = 0;
				for (int j=0; j<k; j++)
					current_sum = current_sum + arr[i+j];

				// Update result if required.
				max_sum = Math.max(current_sum , max_sum );
			}

			return max_sum;
		}

		List<String> subString(String str, int num) 
		{
			List<String> result = new ArrayList<String>();

			for (int i = 0; i < str.length() - num +1; i++)
			{
				Map<Character, Integer> letterMap = new HashMap<Character, Integer>();
				StringBuilder sb = new StringBuilder();

				for (int j = 0 ; j < num; j++)
				{
					Character c = str.charAt(i+j);
					sb.append(c);
					if(letterMap.containsKey(c))
					{
						int val = letterMap.get(c);
						letterMap.put(c, val + 1);
					}else
					{
						letterMap.put(c, 1);
					}				

					if (sb.length() == num)
					{
						int sum = 0;
						for (Map.Entry<Character, Integer> entry : letterMap.entrySet())
						{
							sum += entry.getValue();
						}

						if (sum == num && (letterMap.size() == num - 1))
							result.add(sb.toString());
					}				
				}			
			}		
			return result;		
		}
		
		List<String> subStringSliding(String str, int num) 
		{
			List<String> result = new ArrayList<String>();
			Map<Character, Integer> letterMap = new HashMap<Character, Integer>();
			int startIndex = 0;
			for (int i = 0; i < str.length() - num +1; i++)
			{

					Character c = str.charAt(i);
					if(letterMap.containsKey(c))
					{
						int val = letterMap.get(c);
						letterMap.put(c, val + 1);
					}else
					{
						letterMap.put(c, 1);
					}				

					if (i - startIndex + 1 == num)
					{
						
						if (letterMap.size() == num - 1)
							result.add(str.substring(startIndex, i + 1));
						int count = letterMap.get(str.charAt(startIndex));
						if (count == 1)
							letterMap.remove(str.charAt(startIndex));
						else
							letterMap.put(str.charAt(startIndex), count - 1);
						startIndex++;
					}				
							
			}		
			return result;		
		}

		
		public List<Integer> getTagIndex(List<String> targetList, List<String> availableList)
		{
			List<Integer> result = new ArrayList<Integer>();		
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for (String word : targetList)
			{
				map.put(word, -1);
			}
			int len_sub = Integer.MAX_VALUE;
			int count = 0;
			int local_start = 0, local_end = 0;
			
			for (int i = 0; i < availableList.size(); i++ )
			{
				if (map.containsKey(availableList.get(i)))
				{
					// If this is the first occurrence
					int index = map.get(availableList.get(i));
					if (index == -1)
						count++;

					// Store latest index
					map.put(availableList.get(i), i);

					// If all words matched
					if (count == targetList.size()) 
					{
						// Find smallest index
						int min = Integer.MAX_VALUE;
						for (Map.Entry<String, Integer> m :
							map.entrySet()) 
						{
							int val = m.getValue();
							if (val < min)
								min = val;
						}

						// Check if current length is smaller
						// then length so far
						int s = i - min;
						if (s < len_sub) 
						{
							len_sub = s;
							local_start = min;
							local_end = i;
						}
					}
				}
			}
			
			result.add(local_start);
			result.add(local_end);
			
			return result;
		}

		public static void main(String[] args) 
		{

			String str = "Edwin";
			int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
			int k = 4;
			Amazon t = new Amazon();
			//  System.out.println(t.maxSum(arr, 9, k));

			String input = "awaglk";
			String input2 = "aabb";

			List<String> result = t.subString(input, 4);
			System.out.println(result);
			
			
			List<String> targetList = new ArrayList<String>();
			targetList.add("made");
			targetList.add("in");
			targetList.add("spain");
			
			List<String> availableList = new ArrayList<String>();
			
			availableList.add("made");	//0
			availableList.add("for");	//1 
			availableList.add("in");	//2
			availableList.add("world");	//3
			availableList.add("spain");	//4
			availableList.add("made");	//5
			availableList.add("of");	//6
			availableList.add("in");	//7
			availableList.add("of");	//8
			availableList.add("made");	//9
			availableList.add("Jack");	//10
			availableList.add("truce");	//11
			
			List<Integer> indices = t.getTagIndex(targetList, availableList);
			
			System.out.println(indices);

		}

}
