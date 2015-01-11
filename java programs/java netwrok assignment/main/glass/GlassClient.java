package main.glass;

import java.io.*;
import java.net.*;
import main.utility.*;

/**
	Client for Glass challenge
*/
public class GlassClient
{
	public static void play(BufferedReader in, PrintWriter out)
	{
		printMenu(in);
		handleGame(in,out);
		
	}
	public static void printMenu(BufferedReader in)
	{
		String s ;
		while(true)
			{
				try
				{
					s = in.readLine();
			
			
					if(s.endsWith("EOF"))
					{
						s = s.substring(0,s.indexOf("EOF"));
						print(s);
						break;
					}
					print(s);
					
				}
				catch(IOException e)
				{
					;
				}
			}
	}
		
	public static void handleGame(BufferedReader in, PrintWriter out)
	{
		String s ;
			while(true)
			{
				try
				{
					s = in.readLine();
			
			
					if(s.endsWith("EOF"))
					{
						s = s.substring(0,s.indexOf("EOF"));
					}
					else if(s.startsWith("QUIT"))
						return;
					else if(s.startsWith("REPLAY"))
					{
						play(in,out);
						return;
					}
					if(s.startsWith("ENTER"))
					{
// 						print(s);
						out.println(Integer.toString(Validator.getInt("ENTER THE STEP : ")));
					}
					else
						print(s);
					
				}
				catch(IOException e)
				{
					print("Unable to send data" + e);
				}
			}

	}
	
	public static void print(String s)
	{
		System.out.println(s);
	}
}
