import java.util.*;
public class CheckSystemProperties {
	public static void main( String args[] ) {
		Properties p1 = System.getProperties();
		p1.list(System.out);
	}
}
