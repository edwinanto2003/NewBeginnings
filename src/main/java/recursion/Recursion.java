package recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion
{
	/*
	 * http://codingbat.com/prob/p154669
	 */
	public int factorial(int n) 
	{
		if (n < 3)
			return n;

		return n * factorial(n-1);
	}

	/*
	 * http://codingbat.com/prob/p183649
	 */
	public int bunnyEars(int bunnies) 
	{
		if (bunnies == 0)
			return 0;

		return 2 +  bunnyEars(bunnies -1);
	}

	private static int countCoins(int[] coins, int n, int index, List<Integer> list, List<List<Integer>> lists)
    {
        if(index >= coins.length)
        {
            return 0;
        }
        if(n < 0)
        {
            return 0;
        }
        if(n == 0)
        {
            lists.add(new ArrayList<Integer>(list));

            return 1;
        }
        int count = 0;
        list.add(coins[index]);
        count += countCoins(coins, n - coins[index], index, list, lists);
        list.remove(list.size() - 1);
        count += countCoins(coins, n, index + 1, list, lists);

        return count;
    }

	public static void main(String[] args)
	{
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int[] coins = new int[]{1,2,5,10};
		int target = 10;
		System.out.println(countCoins(coins, target, 0, new ArrayList<Integer>(), lists));
		
		System.out.println(lists);

	}

}
