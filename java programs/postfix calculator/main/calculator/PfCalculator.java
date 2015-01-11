package main.calculator;
import main.myexception.*;
import java.util.*;
import java.lang.Math;
import java.lang.Throwable;
import java.math.BigDecimal;

/**
 * Pfalculator class provides all the methods for successful and robust implementation of postfix calculator
 */
public class PfCalculator
{
	private Queue<String> tokens;								//contains tokens of numbers and operators
	private Stack<Double> lifo;									//contains numbers in double format
	
	/**
	 * Constructor function for PfCalculator class
	 * @param Queue<String> token : Contains the tokens from the postfix expression
	 */
	public PfCalculator(Queue<String> token)
	{
		this.tokens = token;
		this.lifo = new Stack<Double>();
	}
	
	/**
	 * Evaluates the postfix expression
	 * @exception TryAgainException : Used to wrap any unknown exception or known exceptions
	 * @exception NumberFormatException : Thrown if parseDouble method fails
	 * @exception EmptyStackException : Thrown if Stack is accessed if its empty
	 */
	public double evaluate() throws TryAgainException
	{
		String token;
		double temp;
		double ans;
		try
		{
			while(tokens.peek() != null)
			{
				token = tokens.poll();
				if( isOperator(token) == true)
				{
					updateStack(token);
				}
				else
				{
					temp = Double.parseDouble(token);
					lifo.push(temp);
				}
			}
			
			ans =  lifo.pop();
			if(!lifo.empty())
			{
				throw new TryAgainException("\n\tError Hint: The expression has an imbalance of operators");
			}
			return ans;
		}
		catch(NumberFormatException e)
		{
			throw new TryAgainException("\n\tError Hint: The number given is not in a valid format or an invalid operator is used");
		}
		catch(EmptyStackException e)
		{
			throw new TryAgainException("\n\tError Hint: The expression given has an imbalance of operators and number or an empty string");
		}
		catch(TryAgainException e)
		{	
			throw new TryAgainException(e.getMessage());
		}
		

	}
	
	/**
	 * updateStack method takes an operator and applies it to the top two numbers in stack
	 * @exception can throw EmptyStackException if the stack doesn't have sufficient number of double
	 * @exception can throw ArithmeticException if we try to find remainder for division with zero
	 * @exception TryAgainException : This gets thrown as a wrapper for EmptyStackException or for ArithmeticException
	 */
	private void updateStack(String token)
	{
		double a,b;
		BigDecimal mod;
		try
		{
			b = lifo.pop();
			a = lifo.pop();
			
			switch(token)
			{
				case "+":
					lifo.push(a+b);
					break;
				case "-":
					lifo.push(a-b);
					break;
				case "*":
					lifo.push(a*b);
					break;
				case "/":
					lifo.push(a/b);
					break;
				case "^":
					lifo.push(Math.pow(a,b));
					break;
				case "%":
					mod = BigDecimal.valueOf(a).remainder(BigDecimal.valueOf(b));
					lifo.push(mod.doubleValue());
					break;
			}
		}
		catch(EmptyStackException e)
		{
			throw new TryAgainException("\n\tError Hint: The expression given has an imbalance of operators and number or an empty string");
		}
		catch(ArithmeticException e)
		{
			throw new TryAgainException("\n\tremainder for division with zero is not a well defined operation");
		}
	}
	
	/**
	 * isOperator method just checks whether the token passed is an valid operator or not
	 */
	private boolean isOperator(String token)
	{ 
		int i;
		String operators = " + - * % ^ / ";
		i = operators.indexOf(token);
		if( i >= 0 )
			return true;
		else
			return false;
	}
	
}