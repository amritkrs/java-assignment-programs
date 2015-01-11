package main;
import main.invoice.*;
import java.util.*;
import main.utility.*;
import main.products.*;
import main.products.db.*;
import main.sales.*;


public class SalesApp
{
	public static void main(String args[])
	{
		String temp = "y";
		String code;
		int quantity;
		ProductOrder p;
		Invoice i;
		ArrayList<Invoice> in = new ArrayList<Invoice>();
		String tempFinal = "y";
		SalesReport s = null;
		while(tempFinal.equals("y"))
		{
			temp = "y";
			ArrayList<ProductOrder> v = new ArrayList<ProductOrder>() ;
			while( temp.equals("y") )
			{ 
				try
				{
					code = Validator.getString("Enter the Product Code : ");
					quantity = Validator.getInt("Enter the quantity : ");
					p = new ProductOrder(code, quantity);
					v.add(p);
					temp = Validator.getString("Continue : <y/n> ? : ");
				}
				catch(NullPointerException e)
				{
					System.out.println("Invalid order try again");
				}
				
			}
			
			tempFinal = Validator.getString("Continue another invoice : <y/n> ? : ");
			i = new Invoice(23,v);
			in.add(i);
		}
		
		s = new SalesReport(in);
		s.update();
		s.printBill();
		
	}
	
}
		
		