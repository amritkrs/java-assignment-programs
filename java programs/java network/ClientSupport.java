import java.io.*;
import java.net.*;

public class ClientSupport
{
	private Socket client = null;
// 	public static void main(String args[])
// 	{
// 		Socket clientSocket = getSocket(getIp(),getPort());
// 		BufferedReader br = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
// 		PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
// 		String data;
// 		try
// 		{
// 			data = read();
// 			while(true)
// 			{
// 				data = br.readLine();
// 				if(data.endswith("-EOF-"))
// 					break;
// 			}
// 			
// 	}
	
	public ClientSupport(String host,int port)
	{
		try
		{
			this.client = new Socket(host,port);
		}
		catch(UnknownHostException e)
		{
			System.out.println("unknown host");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SecurityException e)
		{
			System.out.println("permission denied");
		}
	}
	
	
	public String read()
	{
		try
		{
			String data = "";
			BufferedReader br = new BufferedReader( new InputStreamReader(client.getInputStream()));
			
			while(true)
				{
					data = data + br.readLine() ;
					if(data.endsWith("-EOF-"))
					{
						data = data.substring(0,data.indexOf("-EOF-"));
						break;
					}
					data = data + "\n";
				}
			return data;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void write(String data)
	{
		try
		{
			PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			out.println(data);
			out.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeConnection()
	{
		client.close();
	}
	
}
		
	
// 	public String getIp()
// 	{
// 		return ;
// 	}
// 	
// 	public int getPort()
// 	{
// 		return 0;
// 	}
	
// 	public Socket getSocket(String host, int port)
// 	{
// 		try
// 		{
// 			Socket client = new Socket(host,port);
// 			return client;
// 		}
// 		catch(UnknownHostException e)
// 		{
// 			System.out.println("unknown host");
// 			return null;
// 		}
// 		catch(IOException e)
// 		{
// 			e.printStackTrace();
// 			return null;
// 		}
// 		catch(SecurityException e)
// 		{
// 			System.out.println("permission denied");
// 			return null;
// 		}
// 	}
// 	