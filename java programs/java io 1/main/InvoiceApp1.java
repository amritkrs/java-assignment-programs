package main;
import main.invoice.*;
import java.util.*;
import main.utility.*;
import main.filehandler.*;
import java.util.Random;


public class InvoiceApp1
{
	public static void main( String args[] )
	{
		String outputFileName = "/home/amrit/java programs/java io 1/MyProductOrders";
		String code;
		int quantity;
		ArrayList<ProductOrder> v = new ArrayList<ProductOrder>() ;
		ProductOrder p;
		Invoice i;
		ReadMyFile rmf = new ReadMyFile("/home/amrit/java programs/java io 1/codefile.txt");
		while(true)
		{
			p = getProductOrder(rmf);
			if( p == null )
				break;
			v.add(p);
		}
		
		i = new Invoice(getRandomNumber(10000),v);
// 		try
// 		{
// 			System.out.println(i.toString());
// 		}
// 		catch(NullPointerException e)
// 		{
// 			System.out.println("No product bought\n");
// 			
// 		}
		
		StoreMyObject.writeToFile(i,outputFileName);
		System.out.println(StoreMyObject.readFromFile(outputFileName));
	}
	
	public static ProductOrder getProductOrder(ReadMyFile rmf)
	{
		
		String line;
		String code;
		int quantity;
		
		line = rmf.readLine();
		if(line == null)
			return null;
		if(line.split("\\s+").length > 1)
		{
			code = line.split("\\s+")[0];
			quantity = Integer.parseInt(line.split("\\s+")[1]);
		}
		else
		{
			code = line.split("\\s+")[0];
			quantity = getRandomNumber(100);
		}
		
		try
		{
			System.out.println(code + " " + quantity);
			return new ProductOrder(code,quantity);
		}
		catch( NullPointerException e)
		{
// 			System.out.println("Invalid Product Code");
			return null;
		}
	}
	
	public static int getRandomNumber(int n)
	{
		Random r = new Random();
		return r.nextInt(n);
	}
}
			
		