package trial;

import java.util.Collections;

public class ProfitCalc
{
	enum TERM
	{
		DAY, MONTH, YEARS
	}

	double calcProfitDay(double principle, double profitPerc, double serviceCharge, int duration)
	{
		for (int i = 0; i < duration; i++)
		{
			principle += (principle * profitPerc);
			principle -= principle * serviceCharge*2;
		}
		
		return principle;
	}

	double calcProfitMonth(double principle, double profitPerc, int duration)
	{
		return 0;
	}

	double calcProfitYears(double principle, double profitPerc, int duration)
	{
		return 0;
	}

	double calcProfit(double principle, double profitPerc, int duration, double serviceCharge, TERM term)
	{
		switch (term)
		{
			case DAY:
				return calcProfitDay(principle, profitPerc,  serviceCharge, duration);
			case MONTH:
				return calcProfitMonth(principle, profitPerc, duration);
			case YEARS:
				return calcProfitYears(principle, profitPerc, duration);
			default:
				return 0;
		}

	}

	double calcSellPrice(long buyPrice, double percent, double n)
	{
		return 0;
	}

	public static void main(String[] args)
	{
		ProfitCalc pc = new ProfitCalc();
		double initial = 5000;
		double interest = 0.01;
		double serviceCharge = 0.003;
		int duration = 30;
		double total = pc.calcProfit(initial, interest, duration, serviceCharge, TERM.DAY);
		System.out.println("Total Return: " + total + " Profit: " + (total - initial));


	}

}
