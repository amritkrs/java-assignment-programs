import java.util.Arrays;
public class ProductApp
{
	public static void main( String args[] ) throws Exception
	{
		Product p;
		String pCode;
		Product collect[] ;
		collect = new Product[10] ;
		String ans="y" ;
		int i = 0;
		while( ans.equals("y")) 
		{
			pCode = Validator.getString("Enter Product code : ");
			p = ProductDB.getProduct( pCode );
			if( p == null )
				System.out.println("No product matches this product code");
			else
			{
				//System.out.println(p.toString());
				collect[i] = p;
				i++;
			}
			ans = Validator.getString("continue? (y/n) : ");
		}
		Arrays.sort(collect,0,Product.getCount());
		for( int j = 0; j < i; j++ )
		{
			System.out.println(collect[j]);
			
		}
		
		System.out.println("The number of object created : " + Product.getCount());
	}
}
