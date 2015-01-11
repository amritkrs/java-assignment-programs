public class CheckValidator {
	public static void main( String args[] ) {
		System.out.println("Lets see the validator in action ");
		String name ;
		Double weight,height,BMI=0.0;
		int val;
		val = Validator.getInt( " Enter 1 or 2 : ");
		switch (val)
		{
			case 1:
				weight = Validator.getDouble( "Enter Your weight in pounds : ");
				height = Validator.getDouble( "Enter Your height in feet : ");
				BMI = (weight * 4.88 )/(height * height);
				break;
			case 2:
			
		
				weight = Validator.getDouble( "Enter Your Weight in Kgs: " );
				height = Validator.getDouble( "Enter Your height in metres : ");
				BMI = (weight ) / (height * height );
				break;
		}
		if ( BMI < 18.5 )
		{
			System.out.println( " \nYou are Underweight ");
		}
		else if( BMI >= 18.5 && BMI < 25.0)
		{
			System.out.println( "\nYou have normal weight ");
		}
		else if( BMI >= 25 && BMI < 30.0 )
		{
			System.out.println("\n You are overweight ");
		}
		else
		{
			 System.out.println("\nYou are Athletic or obese ");
		}
		
		//System.out.format("Your weight is : %f" , weight);
		
	}
}
