package trial;

public class Trialpros
{

	public static void checkEqual(int a, int b, int x, int y)
	{

		System.out.println("a =" + a + " b = " + b + " x=" + x + " y= " + y);
		while (a != x || y != b)
		{
			if (a > x)
				a--;
			else if (a < x)
				a++;
			if (b > y)
				b--;
			else if (b < y)
				b++;
		}

		System.out.println("a =" + a + " b = " + b + " x=" + x + " y= " + y);
	}

	public void checkArr(int[] a)
	{
		a = new int[3];
		a[0] = 1;
		a[1] = 1;
		a[2] = 1;

	}

	public static void main(String[] args)
	{
//		checkEqual(3, 5, 6, 7);
//		Trialpros tp = new Trialpros();
//		int[] a = null;
//		tp.checkArr(a);

//		System.out.println(a.length);

		@SuppressWarnings("unused")
		boolean[] test = new boolean[3];
		
		System.out.println("done");
	}

}
