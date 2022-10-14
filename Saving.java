
public class Saving extends Account {
	
	public boolean makeWithdrawal(double amount) 
	{
		// TODO Auto-generated method stub
		if(bal-amount<0)
		{
			return false;
		}
		
		else
		{
			bal-=amount;
			return true;
		}
			
	}
	public void calculateZakat()
	{
		double zak;
		if(bal>=20000)
		{
			zak=bal*2.5;
			zak=zak/100;
			bal-=zak;
		}
		
		return;
	}
	public void showAcc() {
		System.out.println("\n\t\t-------------------------------");
		System.out.print("\t\tS A V I N G S   A C C O U N T\n");
		System.out.println("\t\t-------------------------------\n");
		System.out.println("\t\tAcc No: "+accNo+"\n\t\tBalance: "+bal+"\n\t\tDate Created: "+createDate);
	}
}
