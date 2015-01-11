package main.utility;
import java.util.Scanner;

/**
 * Validator class to help in I/O 
 */
public class Validator
{
	/**
	 * return a line from input
	 */
	public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();  // read user entry
        return s;
    }
    /**
     * return a line from input
     */
	public static String getString( String prompt)
    {
		Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String s = sc.nextLine();  // read user entry
        return s;
    }

    
}
