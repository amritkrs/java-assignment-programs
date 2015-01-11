import java.net.*;
import java.io.*;
import java.lang.*;

public class Client2Support
{
// 	DatagramSocket ds = null;
// 	FileInputStream fis = null;
// 	int count;
// 	
// 	public ClientSupport()
// 	{
// 		this.ds = new DatagramSocket();
// 		this.fis = new FileInputStream("MyProductOrders");
// 		count = 0;
// 	}
	
	public static DatagramPacket createPacket(String host , int port)
	{
		try
		{
			
			FileInputStream fis = new FileInputStream("MyProductOrders");
			byte[] b = new byte[2048];
			fis.read(b);
			byte[] a = "amrit".getBytes();
			byte[] c = new byte[a.length + b.length];
			System.arraycopy(a, 0, c, 0, a.length);
			System.arraycopy(b, 0, c, a.length, b.length );
			System.out.println(new String(c));
			return new  DatagramPacket(c,c.length,InetAddress.getByName(host),port);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static void sendDatagram(DatagramPacket p)
	{
		try
		{
			DatagramSocket ds = new DatagramSocket();
			ds.send(p);
			byte[] b = new byte[50];
			DatagramPacket dp = new DatagramPacket(b,50);
			ds.receive(dp);
			byte[] c = dp.getData();
			System.out.println(new String(c));
			ds.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
		}
	}
	
// 	public void closeConnection()
// 	{
// 		client.close();
// 	}
	
	public static String readDatagram()
	{
		try
		{
			byte[] b = new byte[50];
			DatagramPacket dp = new DatagramPacket(b,50);
			DatagramSocket ds = new DatagramSocket();
			ds.receive(dp);
			byte[] c = dp.getData();
			return new String(c);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return "bye";
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
			return "byebye";
		}
		
		
		
	}
		
		

}