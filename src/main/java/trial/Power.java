package trial;


/**
 * 
 * Given width of a piece of paper, calculate total width in mm and km after 'k' folds.
 * 
 * @author Edwin Anto
 *
 */
public class Power
{

	public static double pow(double thickness, int k)
	{
		return Math.pow(2, k) * thickness;
	}

	public static void main(String[] args)
	{

		System.out.println(Power.pow(0.1, 40)/1000000 + " km");
	}

}
