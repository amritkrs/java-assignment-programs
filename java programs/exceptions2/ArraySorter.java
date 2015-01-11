import java.util.Arrays;
import java.util.Random;
import java.lang.Throwable;
public class ArraySorter 
{
	public static final int ARRAYSIZE = 20;
	public static final int DEFAULTRANGE = 200;
	int collect[] = new int[ARRAYSIZE];

	public ArraySorter()
	{
		this( DEFAULTRANGE );
	}
	
	public ArraySorter( int range )
	{
		try
		{
			Random rnd = new Random();
			for( int i = 0; i < ARRAYSIZE ; i++ )
			{
				collect[i] = rnd.nextInt( range + 1);
			}
		}
		catch( IllegalArgumentException e )
		{
			System.out.println("Range should be a non negative number");
// 			this.ArraySorter( DEFAULTRANGE );
		}
	}
	
	public void getSorted() throws ArrayIndexOutOfBoundsException,MyOwnException
	{
		try
		{
			Arrays.sort(collect , 15, 10 );		//arguments given to raise both exception.
		}
		catch( ArrayIndexOutOfBoundsException e)
		{
			throw new ArrayIndexOutOfBoundsException(" Index is out of bounds for the given array ");
		}
		catch( IllegalArgumentException e )
		{
			//Throwable cause;
			throw new MyOwnException(" Argument is illegal, using default argument ");
		}
		catch( NullPointerException e)
		{
			System.out.println(" Null pointer encountered ");
		}
	}
	
	public void print()
	{
		for( int i = 0; i < 10 ; i++ )
		{
			System.out.print(collect[i] );
			System.out.print(" ");
		}
		System.out.println();
		for( int i = 10; i < ARRAYSIZE ; i++ )
		{
			System.out.print(collect[i] );
			System.out.print(" ");
		}
	
	}
	
	public void search(int j)
	{
		int i;
		for( i = 0; i < ARRAYSIZE ; i++ )
		{
			if(collect[i] == j)
			{
				System.out.println("The number " + j + "was found in the array at " + (i+1) + "th position");
				break;
			}
		}
		if( i >= ARRAYSIZE )
		{
			System.out.println("NUmber not found");
		}
	}
}
