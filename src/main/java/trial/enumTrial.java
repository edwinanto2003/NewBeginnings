package trial;

public class enumTrial
{	
	private int[] CONSTANTS = {30441, 30442};	
		
	public static void main(String[] args)
	{
		int value = 30443;
		enumTrial et = new enumTrial();
		
		for (int val : et.CONSTANTS)
		{
			if (value == val)
			{
				System.out.println("true");
			}
		}
	}

}
