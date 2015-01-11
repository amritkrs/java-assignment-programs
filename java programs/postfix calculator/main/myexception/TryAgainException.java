package main.myexception;

/**
 * TryAgainException class is used to act as a wrapper for any known exception or unknown exception raised by the program during execution
 */
public class TryAgainException extends RuntimeException
{
	/**
	 * contains the message passed to TryAgainException object
	 */
	private String message;
	
	/**
	 * chained Constructor
	 */
	public TryAgainException(String message)
	{
		this.message =  message;
	}
	
	/**
	 * default constructor
	 */
	public TryAgainException()
	{
		this("unknown exception occurred.");
	}
	
	/**
	 * returns the exception message
	 */
	public String getMessage()
	{
		return this.message;
	}
}