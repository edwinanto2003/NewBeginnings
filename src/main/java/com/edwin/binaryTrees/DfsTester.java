package com.edwin.binaryTrees;

public class DfsTester
{

	private boolean search(int[][] grid)
	{
		if (grid.length ==0)
			throw new IllegalArgumentException("grid cannot be empty");
		
		return search(grid, 0, 0);
	}
	
	private boolean search(int[][] grid, int r, int c)
	{
		// check boundary
		if (r < 0 || r > grid.length-1 || c < 0 || c > grid[0].length - 1 || grid[r][c]==1 )
			return false;
		
		if (r == grid.length -1 && c == grid[0].length -1  && grid[r][c] == 0)
			return true;
		
		return search(grid, r+1,c) || search(grid, r, c+1);
	}

	public static void main(String[] args)
	{
		int[][] arr = {{0,0,0,0,1}, {1,1,0,1,0}, {0,1,0,1,0}, {0,1,0,0,0}};
		
		DfsTester d = new DfsTester();
		System.out.println(d.search(arr));
	}

}
