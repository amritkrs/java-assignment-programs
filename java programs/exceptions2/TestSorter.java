public class TestSorter
{
	public static void main( String args[] ) 
	{
		int j,ans;
		ArraySorter myarray = null;
		int temp = 1;
		try
		{
				myarray = new ArraySorter(Integer.parseInt(args[0]));
		}
		catch(NumberFormatException e)
		{
			System.out.println("The argument should be an integer");
			myarray = new ArraySorter();
		}
		catch( IllegalArgumentException e )
		{
// 			System.out.println(e);
// 			System.out.println(e.getCause());
// 			e.printStackTrace();
			System.out.println("Illegal Argument");
		}
		catch( ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array Index out of bound, default argument accepted");
			myarray = new ArraySorter();
		}
		catch( NullPointerException e)
		{
			System.out.println("Null pointer exception");
		}
		while( temp == 1 )
		{
		try
		{
			myarray.getSorted();
			myarray.print();
			j = Validator.getInt("\nEnter the number to search in array ");
			myarray.search(j);
			temp = 0;
// 			for(int i = 0; i < myarray.length ; i++)
// 			{
// 				if(myarray[i] == j)
// 				{
// 					System.out.println("The number " + j + "was found in the array at " + (i+1) + "th position");
// 					break;
// 				}
// 			}
// 			if( i >= myarray.len )
// 			{
// 				System.out.println("number not found");
// 			}
			
				
		}
		catch( MyOwnException e)
		{
			System.out.println(e.getMessage());
			temp = 1;
			myarray = new ArraySorter();
// 			System.out.println(e.getCause());
// 			e.printStackTrace();
		}
		catch( ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
			temp = 1;
			e.printStackTrace();
		}
		finally
		{
			myarray = null;
		}
		}
		
		
		
		
	}
}
