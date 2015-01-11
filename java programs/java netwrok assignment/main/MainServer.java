package main;

import java.io.*;
import java.net.*;
import java.lang.Thread;
import main.*;

/**
	Wait for client, and then calls proxyserver handler to handle the client, and then continue waiting for more client.
*/
public class MainServer
{
	public static void main(String args[])throws Exception
	{
		ServerSocket server = new ServerSocket(2000);
		System.out.println("Main Server started successfully ");
		try
		{
			while(true)
			{
				Socket s = server.accept();
				ProxyServer.handle(s);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				server.close();
			}
			catch(IOException e)
			{
				;//Do Nothing
			}
		}
	}
	
}
			
			
			