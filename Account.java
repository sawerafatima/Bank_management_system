import java.util.*;
public abstract class Account {
	protected int accNo;
	protected double bal=0;
	protected Date createDate;
	
	public double checkBalance()
	{
		return bal;
	}
	public abstract boolean makeWithdrawal(double amount);
	public void makeDeposit(double amount)
	{
		bal+=amount;
		
		System.out.println("\n\t\t------------------------------");
		System.out.print("\t\tAmount Deposited Successfully\n");
		System.out.println("\t\t------------------------------\n");
	}
	public abstract void showAcc();
	public void setAcc(int acc)
	{
		accNo=acc;
	}
	public void setDate()
	{
		createDate=new Date();
	}
	public double getAcc()
	{
		return accNo;
	}
}
