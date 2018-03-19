package trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CandyShop
{

	 private static void printMinMax(int n, int k, List<Integer> price)
	    {
	        Collections.sort(price);
	        int minPrice = 0, maxPrice = 0;
	        int iInd, jInd = 0;
	        iInd = n - 1;
	        for (int i = 0,j=n-1; i < n;i++,j--)
	        {
	            if (iInd < i || jInd > j)
	                break;
	            minPrice += price.get(i);
	            maxPrice += price.get(j);
	            
	            iInd -= k;
	            jInd += k;
	        }
	        
	        System.out.println(minPrice + " " + maxPrice);
	        
	    }
	    
		public static void main (String[] args) 
		{
			Scanner sc = new Scanner(System.in);
			
			int testCases = sc.nextInt();
			
			for (int i =0; i < testCases; i++)
			{
			    int n = sc.nextInt();
			    int k = sc.nextInt();
			    List<Integer> price = new ArrayList<Integer>();
			    for (int j = 0; j < n; j++)
			    {
			        price.add(sc.nextInt());
			    }
			    
			    printMinMax(n, k, price);
			}
		}
}
