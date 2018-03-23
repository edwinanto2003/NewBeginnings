package com.edwin.arrays;

public class MagicElement
{
	private Integer findMagicElement(int[][] arr)
	{
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException("Ivalid input");
		
		Integer result = null;
		
		for (int i = 0; i < arr.length; i++)
		{
			int cdx = findMinInRow(arr, i);
			
			int idx = findMaxRowInCol(arr, cdx);
			
			if (idx == i)
			{
				result = arr[idx][cdx];
				break;
			}
		}		
		
		return result;
	}
	
	private int findMaxRowInCol(int[][] arr, int c)
	{
		int rIdx = 0;
		int max = Integer.MIN_VALUE;
		
		for (int r = 0; r < arr[0].length; r++)
		{
			if (arr[r][c] > max)
			{
				max = arr[r][c];
				rIdx = r;
			}
		}
		return rIdx;
	}

	private int findMinInRow(int[][] arr, int i)
	{
		int colIdx = 0;
		int min = Integer.MAX_VALUE;
		for (int c = 0; c < arr.length; c++)
		{
			if (arr[i][c] < min)
			{
				min = arr[i][c];
				colIdx = c;
			}
		}
		
		return colIdx;
	}

	public static void main(String[] args)
	{
		int[][] arr = new int[][]{ 
			{100, 20, 30, 22},
			{20, 15, 40, 25},
			{50, 5, 50, 70},
			{70, 10, 20, 30}			
			};
		
		MagicElement me = new MagicElement();
		
		System.out.println(me.findMagicElement(arr));
			
	}
}
