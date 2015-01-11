package main;
import main.invoice.*;
import java.util.*;
import main.utility.*;

public class InvoiceApp
{
	public static void main( String args[] )
	{
		String temp = "y";
		String code;
		int quantity;
		ArrayList<ProductOrder> v = new ArrayList<ProductOrder>() ;
		ProductOrder p;
		Invoice i;
		while( temp.equals("y") )
		{ 
			try
			{
// 				System.out.println(" Enter the product code : ");
				code = Validator.getString("Enter the Product Code : ");
				quantity = Validator.getInt("Enter the quantity : ");
				p = new ProductOrder(code, quantity);
// 				System.out.print(p);
				v.add(p);
				temp = Validator.getString("Continue : <y/n> ? : ");
			}
			catch(NullPointerException e)
			{
				System.out.println("Invalid order try again");
			}
			
		}
		
		i = new Invoice(23,v);
		try
		{
			System.out.println(i.toString());
		}
		catch(NullPointerException e)
		{
			System.out.println("No product bought\n");
			
		}
	}
}
			
		