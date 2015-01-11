public class Client2
{
	public static void main(String args[])
	{
		Client2Support.sendDatagram(Client2Support.createPacket("192.168.20.22",9999));
// 		System.out.println(Client2Support.readDatagram());
	}
}