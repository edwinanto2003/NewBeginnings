package com.edwin.strings;

/**
 * https://leetcode.com/problems/robot-return-to-origin/
 * 
 * @author edwinanto
 *
 */
public class RobotMove 
{
	 /**
	    *  -1,1   1,0   1,1
	    *  -1,0   0,0   0,1
	    *  -1,-1  0,-1  1,-1
	    */
	    public boolean judgeCircle(String moves) 
	    {
	        int x = 0;
	        int y = 0;
	        
	        for (int i = 0; i < moves.length(); i++)
	        {
	            char c = moves.charAt(i);
	            if (c == 'L')
	                x--;
	            if (c == 'D')
	                y--;
	            if (c == 'R')
	                x++;
	            if (c == 'U')
	                y++;
	        }
	        
	        return (x==0 && y==0);
	            
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
