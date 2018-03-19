package trial;

public class GDPCalc
{
	private void gdpcalc(double gdp)
	{
		System.out.println("The current GDP in 2016 is "+ gdp);
	
		for (int i = 0; i < 25; i++)
		{
			gdp += gdp*0.1;
			System.out.println("The GDP in "+ (int ) (2017 + i) + " is "+ gdp);			
		}
	}

	public static void main(String[] args)
	{
		GDPCalc gdp = new GDPCalc();
		gdp.gdpcalc(11.77);
	}

}
