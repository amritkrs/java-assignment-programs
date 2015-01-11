package main;

import java.io.*;
import java.net.*;

/**
	Request connection from server and call proxyclient to handle client services.
*/
public class MainClient
{
	
	private static int PORT = 2000;
	public void print(String s)
	{
		System.out.println(s);
	}
	
	public static void main(String[] args)
	{
		String serverAddress = (args.length == 0) ? "localhost" : args[0];
		ProxyClient client;
		Socket socket;
		try
		{
				socket = new Socket(serverAddress,PORT);
				client = new ProxyClient(socket, serverAddress);

				client.handle();
			
		}
		catch(Exception e)
		{
			System.out.println("\nServer address should be given as commandline argument ,unless server is a localhost\nserver might not be running, or wrong server address");
		}
	}
}