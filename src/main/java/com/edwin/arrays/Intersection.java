package com.edwin.arrays;

import java.util.HashSet;
import java.util.Set;

public class Intersection
{

	public int[] intersection(int[] nums1, int[] nums2) 
	{
		Set<Integer> firstSet = new HashSet<Integer>();
		Set<Integer> intersection = new HashSet<Integer>();

		for (int i = 0; i < nums1.length; i++)
		{
			firstSet.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++)
		{
			if (firstSet.contains(nums2[i]))
				intersection.add(nums2[i]);
		}

		int[] result = new int[intersection.size()];

		int idx =0;
		for (int i : intersection)
			result[idx++] = i;

		return result;
	}

	public static void main(String[] args)
	{
		Intersection i = new Intersection();
		System.out.println(i.intersection(new int[]{1}, new int[]{1}));
	}

}
