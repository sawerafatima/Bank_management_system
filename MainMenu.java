import java.util.*;
public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t\t-----------------------");
		System.out.print("\t\t Welcome to SF BANKING\n");
		System.out.println("\t\t-----------------------\n");		
		String name,Phone,Address;
		int logInd=0;
		
		int ind=0,ch=0,ch2=0;
		Customer[] AllCustomers=new Customer[100];

		System.out.println("\t\tHow Can We Help You?\n");
		
		System.out.print("\t\t1. Make An Account\n\t\t2. Delete Account\n\t\t3. Login your Account\n\t\t4. Show All Accounts\n\t\t5. Exit\n\n\t\tEnter Option: ");
		Scanner sc=new Scanner(System.in);
		ch=sc.nextInt();
		
		while(ch!=5) 
		{
			if(ch==1)
			{
				System.out.println("\n\t\t--------Make Account--------\n");
				Scanner sc2=new Scanner(System.in);	
				System.out.print("\n\t\tEnter Your Name: ");
				name=sc2.nextLine();			
				
				System.out.print("\n\t\tEnter Phone Num: ");
				Phone=sc2.nextLine();
				
				System.out.print("\n\t\tEnter Address: ");
				Address=sc2.nextLine();
				
				Customer cust1=new Customer();
				cust1.MakeAcc(name,Phone,Address);
				cust1.printDetails();
				
				AllCustomers[ind++]=cust1;
			}
			
			else if(ch==2)
			{
				System.out.println("\n\t\t--------Delete Account--------");
				
				Scanner sc3=new Scanner(System.in);
				
				double acc;
				
				System.out.print("\n\t\tEnter Account Number to be Deleted: ");
				acc=sc3.nextDouble();
				
				for(int i=0;i<ind;i++)
				{
					if(AllCustomers[i].acc.accNo==acc)
					{
						for(int j=i;j<ind-1;j++)
						{
							AllCustomers[j]=AllCustomers[j+1];
						}
						ind--;
						System.out.println("\n\t\t----------------------------");
						System.out.print("\t\tAccount Deleted Successfully\n");
						System.out.println("\t\t----------------------------\n");
						
						break;
					}
				}
			}
			
			else if(ch==3)
			{
				System.out.println("\n\t\t--------LOGIN Account--------\n");
				
				Scanner sc4=new Scanner(System.in);
				boolean log=false;
				double acc2;
				System.out.print("\t\tEnter Account Number to Login: ");
				acc2=sc4.nextDouble();

				for(int i=0;i<ind;i++)
				{
					if(AllCustomers[i].acc.accNo==acc2)
					{
						log=true;
						logInd=i;

						System.out.println("\n\t\t----------------");
						System.out.print("\t\tLogin Successful\n");
						System.out.println("\t\t----------------\n");						System.out.println("\t\tWelcome " + AllCustomers[logInd].getName()+"\n");
						
						break;
					}
				}
				
				if(log==false)
				{
					System.out.println("\n\t\t----------------------------------");
					System.out.print("\t\tSorry, This Account does not Exist\n");
					System.out.println("\t\t----------------------------------\n");				}
				
				else
				{
					
					System.out.print("\t\t1. Deposit Amount\n\t\t2. Make a Withdrawal\n\t\t3. Transfer Amount\n\t\t4. Show Account Details\n\t\t5. Exit\n\n\t\tEnter Option: ");
					Scanner sc5=new Scanner(System.in);
					ch2=sc5.nextInt();
					
					
					while(ch2!=5)
					{
						if(ch2==1)
						{
							System.out.println("\n\t\t--------Deposit Amount--------\n");
							double am;
							
							Scanner sc6=new Scanner(System.in);
							
							System.out.print("\t\tEnter Amount to be deposited: ");
							am=sc6.nextDouble();
							
							AllCustomers[logInd].acc.makeDeposit(am);
						}
						
						else if(ch2==2)
						{
							System.out.println("\n\t\t--------Withdrawal Amount--------\n");
							double am;
							
							Scanner sc6=new Scanner(System.in);
							
							System.out.print("\t\tEnter Amount to be Withdrawn: ");
							am=sc6.nextDouble();
							
							if(AllCustomers[logInd].acc.makeWithdrawal(am))
							{
								System.out.println("\n\t\t-----------------------------");
								System.out.print("\t\tAmount Withdrawn Successfully\n");
								System.out.println("\t\t-----------------------------\n");							}
							
							else
							{
								System.out.println("\n\t\t----------------------------------------------");
								System.out.print("\t\tTransaction Failed due to Insufficient Balance\n");
								System.out.println("\t\t----------------------------------------------\n");	
							}
						}
						else if(ch2==3)
						{
							System.out.println("\n\t\t--------Transfer Amount--------\n");
							double am;
							int recInd=0;
							boolean findAcc=false;
							double acc3=0;
							Scanner sc6=new Scanner(System.in);
							
							System.out.print("\t\tEnter Recipient Account Number: ");
							acc3=sc6.nextDouble();
							
							for(int i=0;i<ind;i++)
							{
								if(AllCustomers[i].acc.accNo==acc3)
								{
									findAcc=true;
									recInd=i;				
									break;
								}
							}
							
							if(findAcc==false)
							{
								System.out.println("\n\t\tEntered Account Number does not Exist");
							}
							
							else
							{
								System.out.print("\t\tEnter Amount To Transfer: ");
								am=sc6.nextDouble();
								
								AllCustomers[logInd].transferAmount(am, AllCustomers[recInd]);
							}
						}
						
						else if(ch2==4)
						{
							AllCustomers[logInd].printDetails();
						}
						System.out.print("\t\t1. Deposit Amount\n\t\t2. Make a Withdrawal\n\t\t3. Transfer Amount\n\t\t4. Show Account Details\n\t\t5. Log Out\n\n\t\tEnter Option: ");
						ch2=sc5.nextInt();
					}
					log=false;
				}
			}
			
			else if(ch==4)
			{
				System.out.println("\t\tAll Existing Accounts:\n");
				for(int i=0;i<ind;i++)
				{
					AllCustomers[i].printDetails();
				}
			}
			System.out.print("\t\t1. Make An Account\n\t\t2. Delete Account\n\t\t3. Login your Account\n\t\t4. Show Account Details\n\t\t5. Exit\n\n\t\tEnter Option: ");			
			ch=sc.nextInt();
		}
	}

}
