package main.glass;

import java.io.*;
import java.net.*;
import java.util.Random;
import main.utility.*;

public class Glass
{
	static Random num = new Random();	
	public static void playGame(BufferedReader in, PrintWriter out)
	{
		int ans = num.nextInt(36) + 1;
		int numGlass = 2;
		int i=6;
		int response;
		
	  try
	  {
		
		out.println(printRule());
		while(i >= 1)
		{
			out.println("\n\nYou have " + Integer.toString(numGlass) + " glass left and " + Integer.toString(i) + " guess left ");
			out.println("ENTER EOF");
			response = Integer.parseInt(in.readLine());
			if(response > ans)
			{
				numGlass = numGlass - 1;
				out.println("Sorry ,you broke the glass ");
				if(numGlass == 0)
				{
					
					break;
				}
			}
			else if(response < ans)
			{
				out.println("You guessed below the threshold");
			}
			else if(response == ans)
			{
				out.println("YOU WIN ");
				
				out.println("QUIT");
				return;
			}
			else
			{
				out.println("INVALID REPLY ");
			}
			i = i-1;
		}
			
		if(numGlass == 0)
		{
			out.println("Sorry , You lost the game, you have no glass left");
			out.println("The correct step was " + Integer.toString(ans) );
		}
		else
		{
			out.println("Sorry , You lost the game, you have no glass left");
			out.println("The correct step was " + Integer.toString(ans) );
		}
		
		out.println("QUIT");
		return;
			
	   }	
	   catch(IOException e)
	   {
	   		System.out.println("Unable to send data " + e);
	   }
	}
	
	public static String printRule()
	{
		String s;
		s = "\n\n\nWelcome Dear User : \nWe Present to you the rules of this wonderful game :\nA glass manufacturing company wants to find the height at which the glass they manufacture will break.\nHe has a ladder with 36 steps, and he give you 2 glass and 6 chance to find the currect step.\nYou just have to respond as what step you want to throw the glass from.\nThe game will end if you get the right step or if you break both the glass or your number of chances to perform the experiment goes to 0.  EOF";
		return s;
	}
}
			
				
				
				
			
		
