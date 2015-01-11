public class CheckCircle {
	public static void main( String args[] ) {
		double rad;
		String ans="y" ;
		while( ans.equals("y")) {
			rad = Validator.getDouble("\nEnter radius : ");
			Circle cir = new Circle(rad);
			System.out.println("Circumference : " + cir.getFormattedCircumference() );
			System.out.println("Area : " + cir.getFormattedArea() + "\n");
			ans = Validator.getString("continue? (y/n) : ");
		}
		System.out.println("The number of object created : " + Integer.toString(Circle.getObjectCount()));
	}
}
			
