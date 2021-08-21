/* Object-oriented program that utilises constructors and static vs. not static variables/methods. */

class BankAccount
{
	public static double interestRate = 0.00;
	public final int accountNumber;
	public String accountName;
	public double balance;

	public static void main (String[] args) 
	{
		setInterestRate(5.00);
        System.out.println("The interest rate is " + getInterestRate() + "."); 

		BankAccount acc1 = new BankAccount(452,"Natalie");
     	System.out.println(acc1.accountName + "'s account number is " + acc1.accountNumber + " and has a balance of $" + acc1.balance);
		System.out.println(acc1.toString());
		System.out.println();
    
		BankAccount acc2 = new BankAccount(453,"Sarah",100.01);
		System.out.println(acc2.accountName + "'s account number is " + acc2.accountNumber + " and has a balance of $" + acc2.balance);
		System.out.println(acc2.toString());
		System.out.println();     

		double acc1Result = acc1.withdraw(100.00);
		System.out.println(acc1Result);
		double acc2Result = acc2.withdraw(100.00);
		System.out.format("%.2f", acc2Result);
	}  
          
	public BankAccount(int num, String name) {
		accountNumber = num; 
		accountName = name; 
		balance = 0.00; 
	} 

	public BankAccount(int num, String name, double bal)
	{
		accountNumber = num;
		accountName = name;
		balance = bal; 
	} 

	public double withdraw(double amount)
	{  
		if ( balance >= amount )
		{
			balance = balance - amount;
			return balance;
		}
		else
   			return -1.0;
	}

	public static void setInterestRate(double newRate)
	{
		interestRate = newRate;
	}

	public static double getInterestRate()
	{
		return interestRate;
	}

	public String toString()
	{
		return  accountName  + "'s account number is "  + accountNumber + " and has a balance of $" + balance;
	}
}
