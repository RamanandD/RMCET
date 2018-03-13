package org.Bank;
import java.util.LinkedList;
public class SBI {
	LinkedList<Account> accounts=new LinkedList<>();
	public String createAccount(int accountNumber,int amount)
	{
		Account account=new Account(accountNumber,amount);
		accounts.add(account);
		return "Account created Successfully";
	}
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException
	{
		Account account=searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		for(Account account:accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public int withdrawAmount(int accountNumber,int amount)throws InvalidAccountNumberException, InsuffcientBalanceException
	{
		Account account=searchAccount(accountNumber);
		if(account.getAmount()<amount)
		{
			
				throw new InsuffcientBalanceException();
			
		
		}
		else
		{
			account.setAmount(account.getAmount()-amount);
		}
		return account.getAmount();		
	}
	public String fundTransfer(int accountNumber1,int accountNumber2,int amount) throws InvalidAccountNumberException, InsuffcientBalanceException
	{
		Account account1=searchAccount(accountNumber1);
		Account account2=searchAccount(accountNumber2);
		if(account1.getAmount()<amount)
		{
			
				throw new InsuffcientBalanceException();
			
		}
		else
		{
			System.out.println("Before Transfer balance:");
			System.out.println("Account 1 balance="+account1.getAmount());
			System.out.println("Account 2 balance="+account2.getAmount());
			account2.setAmount(account2.getAmount()+amount);
			account1.setAmount(account1.getAmount()-amount);
			System.out.println("After Transfer balance:");
			System.out.println("Account 1 balance="+account1.getAmount());
			System.out.println("Account 2 balance="+account2.getAmount());
		}
		return "FundTransfer successfull";		
	}
}
