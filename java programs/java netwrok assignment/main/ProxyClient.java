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
	Handles all the client services needed for appropriate handling of server services.
*/
public class ProxyClient
{
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	private String tictactoeServerAddress;
	
	
	public ProxyClient(Socket socket, String serverAddress)
	{
		try
		{
			this.socket = socket;
			this.tictactoeServerAddress = serverAddress;
			input = new BufferedReader( new InputStreamReader( socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(),true);
		}
		catch(IOException e)
		{
			print("Unable to create stream to send data to server" + e);
		}
	}
	
	public void printMenu()
	{
		String s;
		while(true)
		{
			try
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
			catch(IOException e)
			{
				;
			}
		}
	}
	
	/**
		this handles the client requests.
	*/
	public void handle()
	{
		String s;
		while(true)
		{
			try
			{
				s = input.readLine();
				//print(s);
				if(s.startsWith("Welcome"))
				{
					print("\n" + s);
					printMenu();
					output.println(Integer.toString(Validator.getInt("\nEnter Your Choice : ")));
				}
				else if(s.startsWith("START_TICTACTOE_CLIENT"))
				{
					TicTacToeClient.play(tictactoeServerAddress);
				}
				else if(s.startsWith("GLASS"))
				{
					GlassClient.play(input,output);
				}
				else if(s.startsWith("7UP"))
				{
					SevenUpClient.play(input,output);
				}
				else if(s.startsWith("ZODIAC"))
				{
					ZodiacClient.reader(input,output);
				}
				else if(s.startsWith("BYE"))
				{
					end();
					return;
				}
				else if(s.startsWith("UNKNOWN"))
				{
					print("Invalid Choice Entered");
				}
				
			}
			catch(IOException e)
			{
				System.out.println("Unable to send data");
			}
			catch(Exception e)
			{
				;//Do Nothing
			}
		}
	}
			
	public void end()
	{
		try
		{
			socket.close();
		}
		catch(IOException e)
		{
			;
		}
	}
	
	public void print(String s)
	{
		System.out.println(s);
	}
	
}
	
	