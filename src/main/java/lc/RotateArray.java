package lc;

public class RotateArray
{
	private static void Lrotate(int[] arr, int n)
	{
		reverse(arr, 0, n - 1);
		reverse(arr, n, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	private static void Rrotate(int[] arr, int n)
	{
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, n - 1);
		reverse(arr, n, arr.length - 1);
	}

	private static void reverse(int[] arr, int start, int end)
	{
		while (start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++; end--; 
		}
	}

	public static void main(String[] args)
	{
		RotateArray ra = new RotateArray();
		int[]  a = new int[]{1 , 2,3,4,5};
		Lrotate(a, 4);

		for (int i = 0 ; i < a.length ; i ++)
			System.out.print(a[i] + " ");
		
		Rrotate(a, 4);
		System.out.println();
		for (int i = 0 ; i < a.length ; i ++)
			System.out.print(a[i] + " ");
	}

}
