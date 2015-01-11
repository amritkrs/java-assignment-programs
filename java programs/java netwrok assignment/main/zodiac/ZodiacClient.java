package main.zodiac;
import java.io.*;
import java.net.*;
import main.utility.*;

/**
	zodiac client handler
*/
public class ZodiacClient
{
	public static void reader(BufferedReader input, PrintWriter output)
	{
		int day = 0;
		int month = 0;
		try
		{
			String s;
			s = input.readLine();
		
			if(s.startsWith("DATE"))
			{
				day = getday();
				month = getmonth();
				output.println(Integer.toString(month));
				output.println(Integer.toString(day));
				print("\n\nYour Zodiac Sign is : " + input.readLine() + "\n");
			}
		}
		catch(IOException e)
		{
			print("Not able to send data, closing the app");
		}
	}
	
	public static void print(String s)
	{
		System.out.println(s);
	}
	
	public static int getday()
	{
		int day;
		while(true)
		{
			day = Validator.getInt("\n Enter the day(1-31) when you were born : ");
			if(day < 1 || day > 31)
				print("You Entered an Invalid day");
			else
				break;
		}
		return day;
	}
	
	public static int getmonth()
	{
		int month;
		while(true)
		{
			month = Validator.getInt("\n Enter the month(1-12) when you were born : ");
			if(month < 1 || month > 12)
				print("You Entered an Invalid day");
			else
				break;
		}
		return month;
	}
}		
				