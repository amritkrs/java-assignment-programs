package inner.product;
import inner.productdb.*;
import java.text.NumberFormat;
import java.util.*;

public class Product
{
    private String code;
    private String description;
    private double price;
    public static int count = 0;

    public class MyComparator implements Comparator<Product>
    {
			public int compare(Product a, Product b)
			{
				String i = a.getCode(); 
				String j = b.getCode();
				
				return i.compareTo(j);
			}
	}
    
    public Product()
    {
        code = "";
        description = "";
        price = 0;
        count++;
    }
    
    public Product(String code, String description, double price)
    {
    	this.code = code;
    	this.description = description;
    	this.price = price;
    	count++;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getFormattedPrice()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

    public String toString()
    {
        return "Code:        " + code + "\n" +
               "Description: " + description + "\n" +
               "Price:       " + this.getFormattedPrice() + "\n";
    }

    public static int getCount()
    {
        return count;
    }
    
    public Comparator<Product> getPriceComparator()
    {
		return new Comparator<Product>() {
// 			private String type="priceComparator";
			public int compare(Product a, Product b)
			{
				double i = a.getPrice(); 
				double j = b.getPrice();
// 				System.out.println( i+ " " + j );
				
				return i > j ? 1 : i == j ? 0 : -1;    // there is a simple way to do : return i-j; but just for using conditional type
			}
		};
	}
	
	
	public Comparator<Product> getCodeComparator()
	{
		return new MyComparator();
	}
	
	public Comparator<Product> getPriceComparatorDescending()
	{
		class LocalComparator implements Comparator<Product>
		{
			public int compare(Product a, Product b)
			{
				double i = a.getPrice(); 
				double j = b.getPrice();
// 				System.out.println( i+ " " + j );
			
				
				return i < j ? 1 : i == j ? 0 : -1;
			}
				
		}
		
		return new LocalComparator();
	}
}


