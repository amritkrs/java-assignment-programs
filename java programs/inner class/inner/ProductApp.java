package inner;
import inner.product.*;
import inner.productdb.*;
import inner.utility.*;
import java.util.*;
public class ProductApp
{
	public static void main( String args[] )
	{
		Product p = null;
		String pCode;
// 		Product collect[] ;
// 		collect = new Product[10] ;
		ArrayList<Product> collect = new ArrayList<Product>();
		String ans="y" ;
// 		int i = 0;
		while( ans.equals("y")) 
		{
			pCode = Validator.getString("Enter Product code : ");
			p = ProductDB.getProduct( pCode );
			if( p == null )
				System.out.println("No product matches this product code");
			else
			{
				//System.out.println(p.toString());
				collect.add(p);
// 				i++;
			}
			ans = Validator.getString("continue? (y/n) : ");
		}
// 		for( int j = 0; j < i; j++ )
// 		{
// 			System.out.println(collect[j]);
// 		}
		Collections.sort(collect,p.getPriceComparatorDescending());
		System.out.println("\n\nDescending Order by price: ");
		Iterator<Product> it = collect.iterator();
		while(it.hasNext())
		{
				System.out.println(it.next());
		}
		
		Collections.sort(collect,p.getPriceComparator());
		System.out.println("\n\nAscending order by price ");
		it = collect.iterator();
		while(it.hasNext())
		{
				System.out.println(it.next());
		}	
		System.out.println("\n\nAscending order by code lexicographically: ");
		Collections.sort(collect,p.getCodeComparator());
		while(!collect.isEmpty())
		{
				System.out.println(collect.remove(0));
		}	
		System.out.println("The number of object created : " + Product.getCount());
	}
	
}
