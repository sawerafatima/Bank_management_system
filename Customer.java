import java.util.*;

public class Customer {
	private String Name;
	private String Address;
	private String PhoneNum;
	public Account acc;
	
	public void MakeAcc(String n,String ph,String addr) {
		//
		Name=n;
		Address=addr;
		PhoneNum=ph;
		int ch = 0;
		System.out.println("\n\t\tWhich Account do you want to create?\n");
		System.out.println("\t\tPress 1 for Savings Account \n\t\tPress 2 for Checking Account");
		
		Scanner sc=new Scanner(System.in);
		System.out.print("\n\t\tEnter Choice: ");
		
		ch=sc.nextInt();
		int num=0;
		System.out.println(ch);
		
		if(ch==1)
		{
			acc=new Saving();
		}
		
		else
		{
			acc=new Checking();
		}
		
		Random rand=new Random();
		
		//This is for Random number generation
		acc.setAcc(10000+rand.nextInt(10000));
		acc.setDate();
		System.out.println("\t\tAccount Made Successfully");
	}
	public void printDetails() {
		System.out.println("\t\t------------------------------------------");
		System.out.println("\t\tName: "+Name+"\n\t\tPhone Num: "+PhoneNum+"\n\t\tAddress: "+Address);
		acc.showAcc();
		System.out.println("\t\t------------------------------------------\n");
	}
	public void transferAmount(double amount,Customer c)
	{
		if(acc.makeWithdrawal(amount)==true)
		{
			c.acc.makeDeposit(amount);
		}
		
		else
		{
			System.out.println("\t\tInsufficient Balance! Cannot Process Your Transaction");
		}
	}
	public String getName()
	{
		return Name;
	}
	public String getPhone()
	{
		return PhoneNum;
	}
	public String getAddress()
	{
		return Address;
	}

}
