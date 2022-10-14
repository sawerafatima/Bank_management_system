
public class Checking extends Account {
	

	public boolean makeWithdrawal(double amount) {
		// TODO Auto-generated method stub
		if(amount-bal>5000)
		{
			return false;
		}
		
		else
		{
			bal-=amount;
			return true;
		}
	}
	public void calculateTax() 
	{
		double tax;
		
		if(bal>=20000)
		{
			tax=2.5*bal;
			tax=tax/100;
			bal-=tax;
		}
	}
	public void showAcc() {
		System.out.println("\n\t\t----------------------------------");
		System.out.print("\t\tC H E C K I N G S   A C C O U N T\n");
		System.out.println("\t\t----------------------------------\n");
		System.out.println("\t\tAcc No: "+accNo+"\n\t\tBalance: "+bal+"\n\t\tDate Created: "+createDate);
	}
}
