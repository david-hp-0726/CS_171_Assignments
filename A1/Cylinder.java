/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE SOURCES. David Chen
*/

// This class represents a cylinder shape
public class Cylinder extends Circle {

	private double z; // the z coordinate of the cylinder's center
	private double height; // the height of the cylinder

	// The default constructor with no argument
	// setting the height and radius of the cylinder to be 1 
	public Cylinder() {
		super(1.0, 0.0, 0.0);
		height = 1.0;
		z = 0.0;
	}

	// Second constructor setting the instance variables to the
	// values given by the user
	public Cylinder(double ex, double why, double r, double heighte) {
		super(r, ex, why);
		height = heighte;
	}

	// A public getter method that returns the height of the cylinder
	public double getHeight() {
		return height;
	}

	// A public setter method setting the height of the cylinder to
	// the given value
	public void setHeight(double newHeight) {
		height = newHeight;
	}

	// Overriding the getArea method from the class Circle with one
	// that returns the total surface area of the cylinder
	@Override
	public double getArea() {
		return 2 * Math.PI * radius * height + 2 * super.getArea();
	}

	// A public getter method that returns the volume of the cylinder
	public double getVolume() {
		return height * super.getArea();
	}

	// Test the class Cylinder
	public static void main(String[] args) {
		Cylinder cyl1 = new Cylinder();
	    Cylinder cyl2 = new Cylinder(0.0, 0.0, 5.0, 10.0);

	    cyl2.setHeight(10.0);
	    cyl2.setRadius(5.0); // method inherited from class Circle;

	    System.out.println(cyl1.getHeight());
	    System.out.println(cyl1.getArea());
	    System.out.println(cyl2.getVolume());
	    System.out.println(cyl2); // toString method inherited from class Cylinder
	}
}