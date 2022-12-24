/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE SOURCES. David Chen
*/

// This class represents a rectangle shape
public class Rectangle {

		private double L; // the length of the rectangle
		private double H; // the height of the rectangle
		private double x; // the x coordinate of the  bottom left corner of the rectangle
		private double y; // the y coordinate of the bottom left corner of the rectangle

		// The default constructor setting the instance variable to default values
		public Rectangle() {
			L = 1.0;
			H = 1.0;
			x = 0.0;
			y = 0.0;
		}

		// Second constructor setting the instance variables to the values
		// given by the user
		public Rectangle(double Ell, double Eich, double Ex, double Why) {
			L = Ell;
			H = Eich;
			x = Ex;
			y = Why;
		}

		// A public getter method that returns the length of the rectangle
		public double getLength() {
			return L;
		}

		// A public getter method that returns the height of the rectangle
		public double getHeight() {
			return H;
		}

		// A public setter method setting the length of the rectangle to 
		// the given value
		public void setLength(double Ell) {
			L = Ell;
		}

		// A public setter method setting the height of the rectangle to
		// the given value
		public void setHeight(double Eich) {
			H = Eich;
		}

		// A public getter method that returns the parameter of the rectangle
		public double perimeter() {
			return 2 * L + 2 * H;
		} 

		// A public getter method that returns the area of the rectangle
		public double area() {
			return L * H;
		}

		// Overriding the equals method from the Object class with one
		// that compares the area of two rectangles
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Rectangle)) {			
				return false;
			}

			Rectangle rec2 = (Rectangle) obj;

			return this.area() == rec2.area();
		}

		// Test the class Rectangle
		public static void main(String[] args) {
    		Rectangle r1 = new Rectangle();
    		Rectangle r2 = new Rectangle(10, 5, 0, 10);
    		r1.setLength(10);
    		r1.setHeight(5);

    		System.out.println("r1 has height " + r1.getHeight() + " and perimeter " + r1.perimeter());
    		System.out.println("r2 has length " + r2.getLength() + " and area " + r2.area());
    		System.out.println(r1.equals(r2));
		}
}
