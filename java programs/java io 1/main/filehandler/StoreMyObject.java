package main.filehandler;
import java.io.*;
import java.util.*;
import java.util.Random;
import main.products.*;
import main.products.db.*;
import java.lang.Throwable;
import main.invoice.*;


public class StoreMyObject implements Serializable
{
	public static void writeToFile(Invoice i, String filename)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
// 			Iterator<ProductOrder> i = a.iterator();
			
		
// 			while(i.hasNext())
// 			{
// 				System.out.println(i.next());
				
				oos.writeObject(i);
// 			}
		
			oos.close();
		}
		catch(IOException e)
		{
			System.out.println("IO error 1");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("File Not Found");
		}
		
	}
	
	public static Invoice readFromFile(String filename)
	{
		try
		{
			FileInputStream fos = new FileInputStream(filename);
			ObjectInputStream oos = new ObjectInputStream(fos);
			Invoice i = (Invoice)oos.readObject();
			oos.close();
			return i;
		}
		catch(IOException e)
		{
			System.out.println("IO error");
			return null;
		}
		catch(Exception e)
		{
			System.out.println("File Not Found");
			return null;
		}
	}
			
}
