package main.zodiac;

import java.io.*;
import java.net.*;

/** 
	zodiac server class - sends the zodiac symbol given appropriate date.
*/
public class ZodiacServer
{
	public static void reader(BufferedReader input, PrintWriter output)
	{
		String zodiac = "unknown" ;
		int month = 0;
		int day = 0;
		try
		{
			output.println("DATE");
			month = Integer.parseInt(input.readLine());
			day = Integer.parseInt(input.readLine());
		
		
			switch(month)
			{
				case 3:
					if(day >= 20)
						zodiac = "Aries";
					else if(day <= 19)
						zodiac = "Pisces";
					
					break;
				case 4:
					if(day >= 20)
						zodiac = "Taurus";
					else if(day <= 19)
						zodiac = "Aries";
				
					break;
				
				case 5:
					if(day >= 21)
						zodiac = "Gemini";
					else if(day <= 20)
						zodiac = "Taurus";
					
					break;
					
				case 6:
					if(day >= 21)
						zodiac = "Cancer";
					else if(day <= 20)
						zodiac = "Gemini";
					
					break;
					
				case 7:
					if(day >= 22)
						zodiac = "Leo";
					else if(day <= 21)
						zodiac = "Cancer";
					
					break;
					
				case 8:
					if(day >= 23)
						zodiac = "Virgo";
					else if(day <= 22)
						zodiac = "Leo";
						
					break;
					
				case 9:
					if(day >= 23)
						zodiac = "Libra";
					else if(day <= 22)
						zodiac = "Virgo";
					
					break;
					
				case 10:
					if(day >= 23)
						zodiac = "Scorpio";
					else if(day <= 22)
						zodiac = "Libra";
					
					break;
				
				case 11:
					if(day >= 22)
						zodiac = "Sagittarius";
					else if(day <= 21)
						zodiac = "Scorpio";
					
					break;
				case 12:
					if(day >= 21)
						zodiac = "Capricorn";
					else if(day <= 20)
						zodiac = "Sagittarius";
					
					break;
				case 1:
					if(day >= 20)
						zodiac = "Aquarius";
					else if(day <= 19)
						zodiac = "Capricorn";
					
					break;
				case 2:
					if(day >= 18)
						zodiac = "Pisces";
					else if(day <= 17)
						zodiac = "Aquarius";
					
					break;
				default:
					zodiac = "Unknown";
					break;
			}	
			
			output.println(zodiac);
		}
		catch(IOException e)
		{
			System.out.println("I/O Error occurred" + e);
		}
	}
}
	