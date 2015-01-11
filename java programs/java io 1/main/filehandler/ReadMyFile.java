package main.filehandler;
import java.io.*;
import java.util.Random;
import main.products.*;
import main.products.db.*;
import java.lang.Throwable;
import main.invoice.*;

public class ReadMyFile 
{
	
	private BufferedReader br = null;
	public ReadMyFile(String filename)
	{
// 		this.filename = filename;
		try
		{
			br = new BufferedReader(new FileReader(filename));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not available");
		}
	}
	
	public String readLine() 
	{
		String line;
		if( br == null)
			return null;
		try
		{
			line = br.readLine();
		}
		catch( IOException e)
		{
			line = null;
		}
		if(line == null)
			closeReader();
		return line;
	}
	
	private void closeReader()
	{
		try
		{
			br.close();
		}
		catch(IOException e)
		{
			;
		}
	}
	
	public String readCode()
	{
		String line;
		line = readLine();
		if(line == null)
			return null;
		return line.split("\\s+")[0];
	}
	
	
	public String readCodeAndRandomQuantity(int n)
	{
		String line;
		line = readCode();
		if(line == null)
			return null;
		line = line + randomQuantity(n);
		return line;
	}
	
	private int randomQuantity(int n)
	{
			Random r = new Random();
			return r.nextInt(n);
	}
	
// 	public ProductOrder getProductOrder()
// 	{
// 		String line;
// 		String code;
// 		int quantity;
// 		
// 		line = readLine();
// 		if(line == null)
// 			return null;
// 		if(line.split("\\s+").length > 1)
// 		{
// 			code = line.split("\\s+")[0];
// 			quantity = Integer.parseInt(line.split("\\s+")[1]);
// 		}
// 		else
// 		{
// 			code = line.split("\\s+")[0];
// 			quantity = randomQuantity(100);
// 		}
// 		
// 		try
// 		{
// 			System.out.println(code + " " + quantity);
// 			return new ProductOrder(code,quantity);
// 		}
// 		catch( NullPointerException e)
// 		{
// // 			System.out.println("Invalid Product Code");
// 			return null;
// 		}
// 	}
}
		
		
		
		
	
// 	public static String readline(String filename)
// 	{
// 		try
// 		{
// 			BufferedReader br = new BufferedReader(new FileReader(filename));
// 			try
// 			{
// 				String line;
// 				line = br.readLine();
// 				
// 			
// 		}
// 		catch (FileNotFoundException e)
// 		{
// 			System.out.println("File not available");
// 			return null;
// 		}
// 	}

// 	public String readline()
	
	
	