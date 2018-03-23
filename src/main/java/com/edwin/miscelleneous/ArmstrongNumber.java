package com.edwin.miscelleneous;

/**
 * An armstrong number is a special number which equals to the sum of the individual digits to the power of the
 * number of digits in the number
 * 
 * example: 1634 = 1^4 + 6^4 + 3^4 + 4^4 
 * 
 * @author hm
 *
 */
public class ArmstrongNumber
{

	private boolean isArmstrongNumber(int n)
	{
		if (n < 0)
			return false;

		int pow = 3;
		int temp = n;
//		while (temp > 0)
//		{
//			pow++;
//			temp = temp/10;
//		}

		temp = n;
		int sum = 0;
		while (temp > 0)
		{
			int rem = temp % 10;
			sum+= Math.pow(rem, pow);
			temp = temp/10;
		}

		return sum == n;
	}


	private void printArmstrongNumbers(int n)
	{
		for (int i = 0; i <= n;i ++)
		{
			if (isArmstrongNumber(i))
				System.out.println(i);
		}

	}

	public static void main(String[] args)
	{
		ArmstrongNumber a = new ArmstrongNumber();

		System.out.println(a.isArmstrongNumber(371));

		a.printArmstrongNumbers(1000);
	}
}
