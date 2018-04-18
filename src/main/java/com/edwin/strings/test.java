package com.edwin.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test
{

	List<String> retrieve(String s, List<String> exclude)
	{
		Set<String> excludeSet = new HashSet<String>();
		int maxFreq = 0;
		Map<String, Integer> myMap = new HashMap<String, Integer>();

		List<String> result = new ArrayList<String>();
		if (exclude != null)
		{
			for (String word : exclude)
			{
				excludeSet.add(word.toLowerCase());
			}
		}
		String[] words = s.split("\\W+");

		for (String word : words)
		{
			word = word.toLowerCase();
			if (!excludeSet.contains(word))
			{
				int count = myMap.getOrDefault(word, 0) + 1;
				myMap.put(word, count);
				maxFreq = Math.max(maxFreq, count);
			}
		}

		for (Map.Entry<String, Integer> entry : myMap.entrySet())
		{
			if (entry.getValue() == maxFreq)
				result.add(entry.getKey());
		}

		return result;

	}

	public static void main(String[] args)
	{
		String s =
				"Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food";

		List<String> exclude = new ArrayList<String>();
		exclude.add("and");
		exclude.add("he");
		exclude.add("the");
		exclude.add("to");
		exclude.add("is");
		exclude.add("jack");
		exclude.add("jill");

		test t = new test();

		for (String word : t.retrieve(s, exclude))
			System.out.println(word);
		
		exclude.sort(new Comparator<String>()
		{
			public int compare(String o1, String o2)
			{
				return o1.compareTo(o2);
			}
		});


	}

}
