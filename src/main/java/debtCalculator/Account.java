package debtCalculator;

public class Account
{
	private String name;
	
	private float apr;
	
	private float balance;
	
	public Account(String name, float apr, float balance)
	{
		this.name = name;
		this.apr = apr;
		this.balance = balance;				
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getApr()
	{
		return apr;
	}

	public void setApr(float apr)
	{
		this.apr = apr;
	}

	public float getBalance()
	{
		return balance;
	}

	public void setBalance(float balance)
	{
		this.balance = balance;
	}
}
