//number guessing game

import java.util.*;
public class GuessNum
{
	public static void main(String args[])
	{
		int ans,guess,i=0;
		final int MAX = 100;
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		boolean value = false;
		ans = rd.nextInt(MAX);
		while(!value && i<10)
		{
			i++;
			System.out.println("\nGuess the number(range = 1-100)");
			guess = sc.nextInt();
			if(guess<ans)
				System.out.println("Entered number is smaller than actual number\nCount = "+i);
			else if(guess>ans)
				System.out.println("Entered number is larger than actual number\nCount = "+i);
			else
			{
				System.out.println("Your guess was correct!");
				value = true;
			}
		}
		if(i==10)
			System.out.println("\nYou have exceeded number of tries");
	}
}