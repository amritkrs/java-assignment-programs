package main;

import java.io.*;
import java.net.*;
import java.lang.Thread;
import main.tictactoe.*;
import main.*;
import main.glass.*;
import main.utility.*;
import main.sevenup.*;
import main.zodiac.*;

/** 
	Manages each client that connect with server.
*/
public class ProxyServer extends Thread
{
	private static boolean ticFlag = false;
	private static TicTacToeServer ts;
	public static void handle(Socket s)
	{
		if(!ticFlag)
		{
			ticFlag = true;
			startTicTacToeServer();
			
		}
		ClientHandler ch = new ClientHandler(s);
		ch.start();
	}
	
	public static void startTicTacToeServer()
	{
		ts = new TicTacToeServer();
		ts.start();
	}
		
	
	
}

/** 
	called by proxyserver to handle each client, extends thread so that multiple clients can be supported.
*/

class ClientHandler extends Thread
{
	Socket s;
	BufferedReader input;
	PrintWriter output;
	
	public ClientHandler(Socket s)
	{
		try
		{
			this.s = s;
			input = new BufferedReader( new InputStreamReader( s.getInputStream()));
			output = new PrintWriter(s.getOutputStream(),true);
		}
		catch(IOException e)
		{
			print("client lost" + e.toString());
		}
	}
	
	public void print(String s)
	{
		System.out.println(s);
	}
	
	public void run()
	{
		String str;
		while(true)
		{
			try
			{
				output.println(printMenu());
				str = input.readLine();
				switch(str)
				{
					case "1" :  output.println("GLASS");
								Glass.playGame(input,output);
								break;
					case "2" : 	output.println("START_TICTACTOE_CLIENT");
								break;
					case "3" :	output.println("7UP");
								SevenUpServer.play(input,output);
								break;
					case "4" :	output.println("ZODIAC");
								ZodiacServer.reader(input,output);
								break;
					case "5" :	output.println("BYE");
								break;
					default:
								output.println("UNKNOWN");
								break;
				}
			}
			catch(IOException e)
			{
				try
				{
					print(s.toString() + "closed");
					s.close();
					return;
				}
				catch(IOException f)
				{
					;
				}
			}
			
			catch(Exception e)
			{
				try
				{
					print(s.toString() + "closed");
					s.close();
					return;
				}
				catch(IOException f)
				{
					;
				}
			}
		}
	}
								
	
	public String printMenu()
	{
		String s;
		s = "Welcome Dear Client.\n";
		s = s + "\n\tMENU \n\t\t1: Glass Challenge \n\t\t2: TicTacToe \n\t\t3: 7UP \n\t\t4: ZODIAC \n\t\t5: QUIT";
		s = s + "\n\n\tbye EOF";
		return s;
	}
}
	
	
	