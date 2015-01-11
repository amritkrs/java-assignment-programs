package main;
import main.calculator.*;
import main.myexception.*;
import main.utility.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;

/**
 *  Driver Class that uses postfix-calculator to provide user access to calculator functions.
 */
public class TestCalc
{
	/**
	 * Main method for the driver class
	 */
	public static void main(String args[])
	{
		String temp = "y";
		printWelcome();
		while(temp.equals("y") | temp.equals("Y"))
		{
			try
			{
				LinkedList<String> token = TestCalc.getQueue();
				PfCalculator calc = new PfCalculator(token);
				System.out.println(calc.evaluate());
				temp = Validator.getString("\nContinue ? <y/n> : ");
			
			}
			catch(TryAgainException e)
			{
				System.out.println("Invalid Postfix Expression : Please try Again " + e.getMessage());
			}
		}
		
	}
	
	/**
	 * Returns the Queue containing tokens from the parsed expression
	 * @exception PatternSyntaxException This class belong to java.util.regex library.
	 * This is thrown by String.split() method if the regex passed to it is Invalid
	 */
	public static LinkedList<String> getQueue()
	{
		String expression;										// String to store the expression entered
		LinkedList<String> token = null;						// Linked List to contain token
		try
		{
			
			expression = Validator.getString("\nEnter The Postfix Expression : ");
			String[] tokenArray = expression.split(" ");
			List<String> list = Arrays.asList(tokenArray);		//create a list object from the tokenarray 
			token = new LinkedList<String>(list);				//make token a Linked List object
		}
		catch(PatternSyntaxException e)
		{
			System.out.println(e.getMessage());
		}
		return token;
	}
	
	/**
	 * Prints the starting Welcome Message
	 */
	public static void printWelcome()
	{
		System.out.println("\n\n\n\n\n\n\n\n\t\tWELCOME TO POSTFIX CALCULATOR\n\n\n\n\n");
		System.out.println("\t\tTHE SUPPORTED OPERATIONS ARE : ");
		System.out.println("\t\t\t1> +  -> Add\n\t\t\t2> -  -> Subtract\n\t\t\t3> *  -> Multiply\n\t\t\t4> /  -> Divide");
		System.out.println("\t\t\t5> ^  -> Exponent\n\t\t\t6> %  -> Modulus\n");
	}
	
}


 