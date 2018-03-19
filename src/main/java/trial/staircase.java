package trial;

public class staircase 
{

	public void print(int n)
	{
		for (int i = n-1; i >= 0; i--)
		{
			for(int j =0; j <n;j++)
				if(j<i)
					System.out.print(" ");
				else
					System.out.print("#");
		System.out.println();
		}
		
	}


	public static void main (String[] args)
	{
		String s = "I had a,word:till now. but-dont";
		
		String[] words = s.split("\\s+|-|\\.|:");
		System.out.println(words.length);
		staircase st = new staircase();
		st.print(6);
	}
}
