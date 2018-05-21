package math;

import java.util.ArrayList;
import java.util.List;

public class Braces
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<String> lists = new ArrayList<String>();
		braces(3, 0, 0, "", lists);
		System.out.println(lists);
		
		System.out.println(countCoins(new int[]{1,2,5}, 5, 0));
	}
	
	
	private static int countCoins(int[] coins, int n, int index)
    {
        if(index >= coins.length)
        {
            return 0;
        }
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int count = 0;
        count += countCoins(coins, n - coins[index], index);
        count += countCoins(coins, n, index + 1);
        
        return count;
    }
	
	private static void braces(int n, int start, int end, String str, List<String> lists){
		if(str.length() == 2*n){
			lists.add(str);
		}
		if(start< n){
			braces(n, start+1, end, str+"(", lists);
		}
		if(end < start){
		braces(n,start, end+1, str+")", lists);
		}
	}
}
