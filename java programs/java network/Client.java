public class Client
{
	public static void main(String args[])
	{
		ClientSupport client = new ClientSupport("192.168.20.22",9999);
		System.out.println(client.read());
		String response;
		while(true)
		{
			response = Validator.getString("Enter response : ");
			client.write(response);
			System.out.println(client.read());
			if(response.equals("bye"))
				break;
		}
		client.closeConnection();
	}
}