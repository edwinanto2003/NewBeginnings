package debtCalculator;

import java.util.ArrayList;
import java.util.List;

public class DebtCalculator
{
	private void printTotalInterest(Profile p)
	{
		
	}
	
	private void printEachInterst(Profile p)
	{
		
	}
	
	private List<Account> addAccounts(Profile p)
	{
		List<Account> accounts = new ArrayList<>();
		
		accounts.add(new Account("Bank Of America", 14.99f, 4691f));

		accounts.add(new Account("US Bank", 24.99f, 4058f));

		accounts.add(new Account("American Express", 29.99f, 4057f));

		accounts.add(new Account("Citi Bank - Simplicity", 24.99f, 3304f));

		accounts.add(new Account("Citi Bank - Diamond", 24.99f, 593f));

		accounts.add(new Account("Chase Bank", 24.99f, 2362f));

		accounts.add(new Account("Banana Republic", 14.99f, 4691f));

		accounts.add(new Account("Bank Of America", 14.99f, 4691f));

		accounts.add(new Account("Bank Of America", 14.99f, 4691f));
		
		return accounts;
		
	}
	
	
	public static void main(String[] args)
	{
		DebtCalculator db = new DebtCalculator();
		
		Profile p = new Profile("Edwin");
		
		p.setAccounts(db.addAccounts(p));
		
		
	}

}
