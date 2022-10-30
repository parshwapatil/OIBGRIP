import java.util.Scanner;
class Account
{
	double bal=5000;
	int acc,prevT;
	String cName,pwd;
	int flag=0;
	Scanner sc = new Scanner(System.in);
	Account()
	{
		
	}
	Account(String a,String b)
	{	
		cName=a;
		pwd=b;
	}	
	void login()
	{
		System.out.println("Welcome "+cName+"!");
		System.out.print("Please enter your password: ");
		String p = sc.nextLine();
		if(p.equals(pwd))
		{
			System.out.println("Login Successful!");
			menu();
		}
		else
		{
			System.out.println("Login Failed!\nTry again\n");
			if(flag<3)
			{
				flag++;
				login();
			}
		}
	}
	void deposit(int amount)
	{
		if(amount!=0)
		{
			bal = bal+amount;
			prevT=amount;
		}
	}
	void withdraw(int amt)
	{
		if(this.bal>amt)
		{
			bal =bal-amt;
			prevT=-amt;	
		}
		else
			System.out.println("Insufficient balance!");
	}
	void prevTransaction()
	{
		if(prevT>0)
			System.out.println("You deposited Rs."+prevT);
		else if(prevT<0)
			System.out.println("You withdrawn Rs."+(-1*prevT));
		else
			System.out.println("No transaction performed yet");
	}
	public void transfer(double amt,Account a)
	{
		if(this.bal<amt)
			System.out.println("Insuffficient balance!");
		else
		{
			this.bal-=amt;
			a.bal+=amt;
			System.out.println("Account of "+ this.cName +" has balanace Rs."+ this.bal);
			System.out.println("Account of "+ a.cName +" has balanace Rs."+ a.bal);
		}
	}
	public void menu()
	{
		int ch;
		do
		{
			System.out.println("Enter your choice");
			System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Previous Transaction\n5. Transfer\n6. Exit");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Current balance is Rs."+bal);
					break;
				case 2:
					System.out.print("Enter amount you want to deposit: Rs.");
					int amt = sc.nextInt();
					deposit(amt);
					break;
				case 3:
					System.out.print("Enter amount you want to withdraw: Rs.");
					int amt1 = sc.nextInt();
					withdraw(amt1);
					break;
				case 4:
					prevTransaction();
					break;
				case 5:
					Account b = new Account("John","2424");
					System.out.println("Transfering money to "+b.cName);
					System.out.println("Enter the amount you want to transfer:");
					double t = sc.nextDouble();
					transfer(t,b);
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid choice!");
					break;	
			}
		}while(ch!=6);
	} 
}
class ATM
{
	public static void main(String args[])
	{
		Account obj = new Account("Parshwa","1570");
		obj.login();
	}
}