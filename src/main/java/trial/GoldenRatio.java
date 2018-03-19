package trial;

public class GoldenRatio
{


	private static double findGR(int i)
	{
		if(i == 0)
			return 1;
		return 1 + 1/findGR(i-1);
	}

	public static void main(String[] args)
	{
		for (int i = 0 ; i < 10000;i ++)
			System.out.println("i: " + i + " " + findGR(i));

	}
}
