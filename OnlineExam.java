import java.util.HashMap;
import java.util.Scanner;

class OnlineExam
{
	Scanner sc=new Scanner(System.in);
	HashMap<String,Integer> data=new HashMap<String,Integer>();
	public void login()
	{
		//user_name and password
		data.put("u1",123);
		data.put("u2",234);
		data.put("u3",345);
		String id;
		int pwd;
		System.out.println("Enter your user id: ");
		id = sc.next();
		System.out.println("Enter your password: ");
		pwd=sc.nextInt();
		if(data.containsKey(id) && data.get(id)==pwd)
		{
			System.out.println("Login Sucessful!");
			menu();
		}
		else
		{
			System.out.println("Login failed\nTry again\n");
			login();
		}
	}
	
	public void menu()
	{
		int ch;
		System.out.println("Enter your choice: ");
		System.out.println("1.Update password\n2.Start Exam\n3.Logout");
		ch = sc.nextInt();
		switch(ch)
		{
			case 1:
				data = update();
				menu();
				break;
			case 2:
				startExam();
				menu();
				break;
			case 3:
				System.exit(0);
				break;
			default :
				System.out.println("Enter a valid choice!");
		}
	}
	
	public HashMap<String,Integer> update()
	{
		String upUser;
		int upPwd;
		System.out.println("Enter your username: ");
		upUser = sc.next();
		System.out.println("Enter current password: ");
		upPwd = sc.nextInt();
		if(data.containsKey(upUser))
		{
			System.out.print("Enter new username:");
			upUser = sc.next();
			System.out.println();
			System.out.print("Enter new password: ");
			upPwd = sc.nextInt();
			System.out.println();
			data.replace(upUser,upPwd);
		}
		else
			System.out.println("User doesn't exist!");
		return data;
	}
	
	public void startExam()
	{
		long start = System.currentTimeMillis();
		long end = start+30;
		int score=0;
		int ans;
		System.out.println("Exam started!");
		while(System.currentTimeMillis()<end)
		{
			System.out.println("You have to attempt 5 quetions within 5 minutes");
			System.out.println("Each question carries 5 marks and -1 for each wrong answer");
			System.out.println();
			System.out.println("Q1.Who created the first DBMS");
			System.out.println("1)Edgar Frank Codd\n2)Charles Bachman\n3)Charles Babbage\n4)Sharon B. Codd");
			System.out.print("Enter your answer: ");
			ans = sc.nextInt();
			if(ans==2)
				score=score+5;
			else
				score--;
	
			System.out.println();
			
			System.out.println("Q2.In which of the following formats data is stored in the DBMS?");
			System.out.println("1)Image\n2)Text\n3)Table\n4)Graph");
			System.out.print("Enter your answer: ");
			ans = sc.nextInt();
			if(ans==3)
				score=score+5;
			else
				score--;
			
			System.out.println();
			
			System.out.println("Q3.Which of the following is not a type of database?");
			System.out.println("1)Hierarchical\n2)Network\n3)Distributed\n4)Decentralized");
			System.out.print("Enter your answer: ");
			ans = sc.nextInt();
			if(ans==4)
				score=score+5;
			else
				score--;
			
			System.out.println("");
			
			System.out.println("Q4.Which of the following is not an example of DBMS?");
			System.out.println("1)MySQL\n2)Microsoft Access\n3)IBM DB2\n4)Google");
			System.out.print("Enter your answer: ");
			ans=sc.nextInt();
			if(ans==4)
				score=score+5;
			else
				score--;
			
			System.out.println();
			
			System.out.println("Q5.What is information about data called?");
			System.out.println("1)Hyper data\n2)Tera data\n3)Meta data\n4)Relations");
			System.out.print("Enter your answer: ");
			ans=sc.nextInt();
			if(ans==3)
				score=score+5;
			else
				score--;
			break;
		}
		
		System.out.println();
		
		System.out.println("Exam ended");
		System.out.println("Your score is "+score+"/50");
	}
	
	public static void main(String args[])
	{
		OnlineExam e1 = new OnlineExam();
		e1.login();
	}
}