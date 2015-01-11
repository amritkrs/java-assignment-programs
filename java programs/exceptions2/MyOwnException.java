class MyOwnException extends IllegalArgumentException
{
	public MyOwnException()
	{
		this("MyOwnException occurred");
	}
	
	public MyOwnException( String message )
	{
		super( message);
	}
}