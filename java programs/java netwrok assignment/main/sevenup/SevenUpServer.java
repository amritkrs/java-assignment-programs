package main.sevenup;

import java.io.*;
import java.net.*;
import main.utility.*;
import java.util.Random;

/**
	7up server class
	Read the rules function to know working of this game.
	I solved the exercise problem of Algorithm Design (Book by Jon Kleinberg and Éva Tardos) and used the same to make a game out of it.
*/
public class SevenUpServer
{

	private static int minBet = 10;
	public static void play(BufferedReader input, PrintWriter output)
	{
		int money = 50;
		Random dice1 = new Random() ;
		Random dice2 = new Random() ;
		
	
		int bet=0;
		int choice = 0;
		int outcome = 0;
		output.println(rules());
		
		try
		{
			while(true)
			{
				if(!checkMoneyLeft(output,money))
					break;
				output.println(printChoice());
				output.println("You have " + Integer.toString(money) + " left");
				
				if((choice = getChoice(input,output)) == 4)
					break;
				bet = getAmount(input,output,money);
				outcome = dice1.nextInt(6) + dice2.nextInt(6) + 2;
				output.println("\n The outcome is : " + Integer.toString(outcome));
				if(choice == 1)
				{
					if(outcome > 6)
					{
						money = money - bet;
						output.println("You lost");
					}
					else
					{
						money = money + bet;
						output.println("You Won");
					}
				}
				else if(choice == 2)
				{
					if(outcome < 8)
					{
						money = money - bet;
						output.println("You lost");
					}
					else
					{
						money = money + bet;
						output.println("You Won");
					}
				}
				else if(choice == 3)
				{
					if(outcome == 7)
					{
						money = money + bet + bet;
						output.println("You Won");
					}
					else
					{
						money = money - bet;
						output.println("You lost");
					}
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(" Unable to send data " + e);
		}
		catch(Exception e)
		{
			;//Do Nothing
		}
	}
	
	private static int getAmount(BufferedReader input, PrintWriter output, int money)throws Exception
	{
		int bet;
		output.println("AMOUNT");
			while(true)
			{
				bet = Integer.parseInt(input.readLine());
				if(bet < minBet)
				{
					output.println("BETLOW");
				}
				else if(bet > money)
				{
					output.println("INSUFFICIENT");
				}
				else
					break;
			}
		return bet;
	}
	
	private static int getChoice(BufferedReader input, PrintWriter output)throws Exception
	{
		int choice = 0;
		output.println("CHOICE");
		while(true)
		{
			choice = Integer.parseInt(input.readLine());
			if(choice < 1 || choice > 4)
				output.println("INVALID_CHOICE");
			else if(choice == 4)
			{
				output.println("ThankYou User for Playing.Gambling is Not a Good Habit, and so we dont give any money.\n");
				output.println("QUIT");
				break;
			}
			else
				break;
		}
		return choice;
	}
	
	private static String rules()
	{
		String s = "\n\nWelcome Dear User in this adventurous game 7UP.\nYou start with Rs 50 and you have to guess whether sum of outcome of 2 dice will be \n\t\t1> less than 7\n\t\t2> greater than 7\n\t\t3> exact 7.\nThe minimum amount you can bet is Rs 10,and if you bet right for 7UP or 7DOWN, you get double tha amount you invested, and for exact 7, you get triple.\nWithout further delay lets start :\n EOF";
		return s;
	}
	
	private static String printChoice()
	{
		String s = "\n\n\t\t1> 7DOWN \n\t\t2> 7UP \n\t\t3> 7\n\t\t4> Withdraw Money.\n";
		return s;
	}

	private static boolean checkMoneyLeft(PrintWriter output, int money)throws Exception
	{
		if(money < 10)
		{
			output.println("BANKRUPT");
			return false;
		}
		else
			return true;
	}
}
	