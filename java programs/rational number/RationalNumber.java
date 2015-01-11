

/**
 * A rational number given by a numerator and denominator.
 *
 * @author Srivarun and Amritkrs
 */
public class RationalNumber {

	/**
	 * The numerator is given as an integer number.
	 * It is always 0 if this RationalNumber is 0.
	 */
	private int numerator;

	/**
	 * The denominator is given as an integer number greater than zero.
	 * It is always 1 if this RationalNumber is 0.
	 */
	private int denominator;

	private int gcd;
	
	public RationalNumber() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public RationalNumber( int num ) {
		this.numerator = num;
		this.denominator = 1;
	}

	/**
	 * Creates a new RationalNumber with given numerator and denominator.
	 * @param numerator an arbitry integer number
	 * @param denominator an integer not equal to zero
	 */
	public RationalNumber(int num, int den) {
		this.numerator = num;
		if (num == 0) {
			denominator = 1;
		}
		if (den == 0) {
			throw new RuntimeException("Denominator is Zero");
		}else{
			this.denominator = den;
		}
		reduceFraction();
	}

	/**
	 * Returns the greates common divisor of two positive integer numbers.
	 */

	private int getGcd(int p, int q) {
			p = Math.abs(p);
			q = Math.abs(q);
			int r = p%q;
			while (r > 0) {
				p = q;
				q = r;
				r = p%q;
			}
			//System.out.println("GCD::"+q);
			return q;
	}

	/**
	 * Reduces the fraction of numerator and denominator by their
	 * greatest common divisor.
	 */
	private void reduceFraction() {
		this.gcd = getGcd(Math.abs(numerator), denominator);
		//int num, den;

		if (gcd > 0) {
			numerator = numerator / gcd;
			denominator = denominator / gcd;

		}

	}

	public int getGcd(){
		return this.gcd;
	}


	/**
	 * Returns the denominator of this RationalNumber.
	 * It is zero, if this RationalNumber is zero.
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * Returns the numerator of this RationalNumber.
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Returns the value of this RationalNumber as a double value.
	 */
	public double getDoubleValue() {
		return (double) numerator / (double) denominator;
	}
	
	/** 
	*   inverts the rational number 
	*/
	public RationalNumber reciprocal( ) {
		RationalNumber temp = new RationalNumber();
		temp.numerator = this.denominator;
		temp.denominator = this.numerator;
		return temp;
	}
	
	public RationalNumber multiply( RationalNumber num ) {
		int ans_num;
		int ans_den;
		
		ans_num = this.numerator * num.getNumerator();
		ans_den = this.denominator * num.getDenominator();
		
		RationalNumber temp = new RationalNumber(ans_num , ans_den);
		return temp;
	}
		
	
	public RationalNumber divide( RationalNumber num ) {
		RationalNumber temp = new RationalNumber(1);
		temp = num.reciprocal();
		temp = temp.multiply(this);
		return temp;
	}
	
	public String toString() {
		String s = Integer.toString(numerator) + "/" + Integer.toString(denominator) ;
		return s;
	}
	
	public int getLcm(RationalNumber t) {
		int gcd;
		int p,q;
		int Lcm;
		gcd = t.getGcd();
		p = t.getNumerator();
		q = t.getDenominator();
		Lcm = (p * q ) / gcd;
		return Lcm;
	}
		
	public RationalNumber add( RationalNumber num ) {
		int numProduct;
		int denProduct;
		int a,b,c,d;
		
		a = this.getNumerator();
		b = this.getDenominator();
		c = num.getNumerator();
		d = num.getDenominator();
		
		denProduct = b*d;
		numProduct = a*d + b*c;
		
		RationalNumber ans = new RationalNumber( numProduct, denProduct );
		return ans;
	}
		
		
	public RationalNumber subtract( RationalNumber num ) {
		int numProduct;
		int denProduct;
		int a,b,c,d;
		
		a = numerator;
		b = denominator;
		c = num.getNumerator();
		d = num.getDenominator();
		
		denProduct = b*d;
		numProduct = a*d - b*c;
		
		RationalNumber ans = new RationalNumber( numProduct, denProduct );
		return ans;
	}
}
