public class Rational
{
	public static void main( String args[] )
	{
		int num;
		int den;
		
		RationalNumber temp = new RationalNumber( 6 , 7);
		
		num = Validator.getInt( " Please Enter the numerator for the rational number : " );
		den = Validator.getInt( " Please Enter the denomiator for the rational number : " );
		
		RationalNumber number = new RationalNumber( num, den );
		System.out.println(" the number is " + number.toString() );
		System.out.println(" the gcd is " + number.getGcd() );
		System.out.println(" the double value is " + number.getDoubleValue() );
		System.out.println(" dividing it by 6/7 gives " + (number.divide(temp)).toString() );
		System.out.println(" adding it by 6/7 gives " + (number.add(temp)).toString() );
		System.out.println(" subtracting it by 6/7 gives " + (number.subtract(temp)).toString() );
		System.out.println(" multiplying it by 6/7 gives " + (number.multiply(temp)).toString() );
		
	}
}
		
