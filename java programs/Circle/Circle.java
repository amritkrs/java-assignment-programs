import java.text.*;
import java.lang.*;
import java.util.*;
public class Circle {
	private double radius;
	 NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
	 private static int objCount = 0;
	
	public Circle( double rad ) {
		this.radius = rad;
		objCount++;
	}
	
	public double getCircumference( ) {
		return 2 * (radius) * Math.PI;
	}
	
	public String getFormattedCircumference( ) {
		 nf.setMaximumFractionDigits(3);
		double circum = this.getCircumference();
		return nf.format(circum);
	}
	
	public double getArea() {
		return Math.pow(radius,2.0) * Math.PI;
	}
	
	public String getFormattedArea() { 
		 nf.setMaximumFractionDigits(5);
		double area = this.getArea();
		return nf.format(area);
	}
	
	public static int getObjectCount() {
		return objCount;
	}
}
		
		
