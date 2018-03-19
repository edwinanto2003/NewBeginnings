package intv.q;

/**
 * Given an array of colors (R,G,B), create a method which will return the color based on the probability of its being
 * chosen.
 * for example if arr[]= {R,R,R,R,R,G,G,B,B,B}
 * returnColor should return R with prob 5/10 = 0.5, G with prob 2/10 = 0.2, B = 0.3
 * 
 */
public class ColorProb
{

	/**
	 * 
	 * @param colorArr
	 * @return
	 */
	private static char[] getColor(char[] colorArr)
	{
		
		
	}

	public static void main(String[] args)
	{
		char[] colorArr = new char[]{'R','R','R','R','R','G','G','B','B','B'};
		
		System.out.println(getColor(colorArr));
	}
}
