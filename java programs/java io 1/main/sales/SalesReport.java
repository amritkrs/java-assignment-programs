package main.sales;
import main.invoice.*;
import java.util.*;
import main.utility.*;
import main.products.*;
import main.products.db.*;

public class SalesReport
{
	Map<String , ProductOrder> m = new HashMap< String,ProductOrder>();
	ArrayList<Invoice> in = null;
	double grandTotal = 0;
	
	public SalesReport(ArrayList<Invoice> in)
	{
		this.in = in;
	}
	
	public void update()
	{
		Invoice bill;
		Iterator<ProductOrder> it;
		String code;
		ProductOrder p,q;
		int quantity;
		
		while(!in.isEmpty())
		{
			bill = in.remove(0);
			it = bill.v.iterator();
			while(it.hasNext())
			{
				p = it.next();
				grandTotal += p.getTotal();
				code = p.getProduct().getCode();
				if (m.containsKey(code))
				{
					q = m.get(code);
					q.addQuantity(p.getQuantity());
					q.addTotal(p.getTotal());
					m.put(code,q);
				}
				else
				{
					m.put(code,p);
				}
			}
		}
	}
	
	public void printBill()
	{	
		Iterator itk = m.keySet().iterator();
		Iterator itv = m.values().iterator();
		System.out.println("\n\n\nProduct Code\t\tPrice\t\tQnty Sold\t\tTotal");
		while(itv.hasNext())
		{
			System.out.println(itv.next());
		}
		System.out.println("--------------------------------------------------\nGRAND TOTAL \t\t\t\t\t\t\t"+grandTotal);
	}
}
			
	
	