package main.invoice;
import main.products.*;
import main.products.db.*;
import java.lang.Throwable;

public class ProductOrder implements Comparable<ProductOrder>
{
	private Product p;
	private int quantity;
	private double total;
	public static int orderObjectCount = 0;
	
	public ProductOrder(String productCode, int quantity )
	{
		try
		{
			this.p = ProductDB.getProduct(productCode);
			this.quantity = quantity;
			this.total = 0;
			double price;
			price = this.p.getPrice();
			this.total = price*quantity;
			orderObjectCount++;
		}
		catch(NullPointerException e)
		{
			System.out.println("The product code is not valid.");
			throw new NullPointerException("");
		}
	}
	
	public int compareTo( ProductOrder p )
	{
		ProductOrder p1 = (ProductOrder)p;
		if(this.total > p1.getTotal())
		{
			return 1;
		}
		else if(this.total < p1.getTotal())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public double getTotal()
	{
		return this.total;
	}
	
	public String toString()
    {
        return  p.getCode() + "\t" +
                p.getDescription() + "\t" +
				p.getFormattedPrice() + "\t" +
//                "Tag:        " + tag + "\n";
			    quantity + "\t" +
			    total + "\n";
    }
    
}