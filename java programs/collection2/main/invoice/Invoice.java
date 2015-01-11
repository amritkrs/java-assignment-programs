package main.invoice;
import main.products.*;
import main.products.db.*;
import java.util.*;
import java.lang.Throwable;
public class Invoice
{
	private int invoiceNumber;
	private double total;
	public ArrayList<ProductOrder> v;
	public Date d = new Date();
	String s = "";
	
	public Invoice(int invoiceNumber, ArrayList<ProductOrder> p)
	{
		this.v = p;
		this.invoiceNumber = invoiceNumber;
		this.total = 0;
		Iterator<ProductOrder> i = this.v.iterator();
		while(i.hasNext())
		{
			this.total += i.next().getTotal();
		}
		
	}
	
	
	public String toString()
    {
		s = s + "\nHere is the bill:\n";
		s = s + "InvoiceNumber = " + this.invoiceNumber;
		s = s +"\n" + d + "\n";
        s = s + "Code " + "\t" + "Description " + "\t\t\t\t" + "Price " + "   " + "Quantity " + "   " + "Total " + "\n";
        Iterator<ProductOrder> i = this.v.iterator();
        while(i.hasNext())
        {
			s = s + i.next().toString();
		}
		return s + "----------------------------------------------\n"+"TOTAL \t\t\t\t\t\t\t\t\t" + this.total;
    }
    
}
	
	