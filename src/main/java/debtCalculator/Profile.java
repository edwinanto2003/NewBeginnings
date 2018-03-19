package debtCalculator;

import java.util.ArrayList;
import java.util.List;

public class Profile
{
	String name;
	
	List<Account> accounts;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Account> getAccounts()
	{
		return accounts;
	}

	public void setAccounts(List<Account> accounts)
	{
		this.accounts = accounts;
	}
	
	public void addAccount(Account account)
	{
		this.accounts.add(account);
	}

	public Profile(String name)
	{
		super();
		this.name = name;
	}
	
	public Profile(String name, List<Account> accounts)
	{
		super();
		this.name = name;
		this.accounts = new ArrayList<>(accounts);
	}

}
