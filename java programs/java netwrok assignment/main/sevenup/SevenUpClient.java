package main.sevenup;

import java.io.*;
import java.net.*;
import main.utility.*;

/**
	Seven Up Client class
*/
public class SevenUpClient
{
	public static void play(BufferedReader input, PrintWriter output)
	{
		String s;
		try
		{
			printRule(input);
			while(true)
			{
				s = input.readLine();
				if(s.startsWith("AMOUNT"))
				{
					output.println(Integer.toString(Validator.getInt("\nPlease give the betting amount : ")));
				}
				else if(s.startsWith("BETLOW"))
				{
					print("You bet less than the minimum amount.");
					output.println(Integer.toString(Validator.getInt("\nPlease give the betting amount : ")));
				}
				else if(s.startsWith("INSUFFICIENT"))
				{
					print("Your betting amount exceeded your balance");
					output.println(Integer.toString(Validator.getInt("\nPlease give the betting amount : ")));
				}
				else if(s.startsWith("CHOICE"))
				{
					output.println(Integer.toString(Validator.getInt("\nPlease Enter Your Choice : ")));
				}
				else if(s.startsWith("INVALID_CHOICE"))
				{
					print("You Entered an Invalid Choice");
					output.println(Integer.toString(Validator.getInt("\nPlease Enter Your Choice : ")));
				}
				else if(s.startsWith("BANKRUPT"))
				{
					print("Dear User, You dont have enough money to continue playing\n BYE");
					break;
				}
				else if(s.startsWith("QUIT"))
				{
					break;
				}
				else
				{
					print(s);
				}
			}
		}
		catch(IOException e)
		{
			print("Unable to send data" + e);
		}
		catch(Exception e)
		{
			;
		}
	}
	
	public static void print(String s)
	{
		System.out.println(s);
	}
	
	public static void printRule(BufferedReader input) throws Exception
	{
		String s;
		while(true)
		{
			s = input.readLine();
			if(s.endsWith("EOF"))
			{
				s = s.substring(0,s.indexOf("EOF"));
				print(s);
				break;
			}
			print(s);
		}
	}
}