package trial;

public class mergeArrays {

	public int[] merge(int[] a, int[] b) 
	{
		int[] c = new int[a.length + b.length];
		int aL = 0;
		int bL = 0;
		int cL = 0;

		while (aL < a.length && bL < b.length)
		{
			if (a[aL] <= b[bL])
				c[cL++] = a[aL++];
			else 
				c[cL++] = b[bL++];
		}


		while (cL < a.length + b.length)	
			if (aL == a.length)
				c[cL++] = b[bL++];
			else if (bL == b.length)
				c[cL++] = a[aL++];

		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeArrays ma = new mergeArrays();
		int[] a = { 2, 4, 5, 9, 9 };

		int[] b = { 0, 1, 2, 3, 4 };
		int[] c = ma.merge(a, b);
		for ( int i = 0; i < c.length; i++)
		{
			System.out.print(c[i] + " ");
		}
	}

}
