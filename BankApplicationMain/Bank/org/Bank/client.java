package org.Bank;

public class client {

	public static void main(String[] args) {
	SBI bank=new SBI();
	System.out.println(bank.createAccount(101,5000));
	System.out.println(bank.createAccount(102,10000));
	System.out.println(bank.createAccount(103,10000));
	try
	{
		System.out.println("Total balance="+bank.depositAmount(101,20000));
		System.out.println("Deposit amount="+bank.withdrawAmount(101,1000));
		System.out.println(bank.fundTransfer(101,102,100));
		System.out.println("Account check="+bank.depositAmount(104,400));
		System.out.println("FundTransfer="+bank.fundTransfer(101,102,7000));
	}
	catch(InvalidAccountNumberException e)
	{
		System.out.println("Invalid Account Number");
	}
	catch(InsuffcientBalanceException e)
	{
		System.out.println("InSuffcient Balance ");
	}
}

}
