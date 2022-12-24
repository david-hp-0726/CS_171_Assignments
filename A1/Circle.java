/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE SOURCES. David Chen
*/

// This class represents a circle shape
public class Circle {

    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center

    // The default constructor with no argument
    public Circle(){
      // Initializing the values of the instance variables
      radius = 1.0;
      x = 0.0;
      y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double r) {
      radius = r;
      x = 0.0;
      y = 0.0;
    }

    // Third constructor with given radius, x and y coordinates of the center
    public Circle(double r, double ex, double why) {
        radius = r;
        x = ex;
        y = why;
    }

    // A public getter method for retrieving the radius
    public double getRadius() {
        return radius;
    }

    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
        double[] c = {this.x, this.y};
        return c;
    }

    // A public getter method for computing and returning
    // the area of the circle
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // A public getter method for computing and returning 
    // the area of the circle
    public double getCircumference() {
        return radius * 2 * Math.PI;
    }

    // A public method comparing if the area of the circle   
    // greater than that of another circle
    public boolean isBiggerThan(Circle circleB) {
        return this.getCircumference() >= circleB.getCircumference();
    }

    // A public method computing if a given point falls within
    // the area covered by the circle
    public boolean containsPoint(double x_cord, double y_cord) {
        double x_distance = x_cord - x;
        double y_distance = y_cord - y;
        double distance = Math.sqrt(Math.pow(x_distance, 2) + Math.pow(y_distance, 2));
        return distance <= radius;
    }

    // A public setter method that sets the radius to the new given value
    public void setRadius(double r) {
        radius = r;
    }

    // A public setter method that sets the coordinates of the center
    // the be the new given x and y
    public void setCenter(double x_cord, double y_cord) {
        x = x_cord;
        y = y_cord;
    }

    // Overriding the toString method from the Object class with one 
    // that returns the string representation of this Circle object
    @Override
    public String toString() {
        return "This circle is centered at point (" + x + ", " + y + 
            ") with radius " + radius;
    }

    // Overriding the equals method from the Cbject class with one
    // that compares the area of two circle objects
    @Override 
    public boolean equals(Object obj) { // can receive parameters of other types as well
        if (!(obj instanceof Circle)) {
            return false;
        }
        Circle circleB = (Circle) obj; 
        // for object, downcast is allowed, meaning a parent object can be casted into a child object

        return this.getArea() == circleB.getArea();
        // "this.getArea() == circleB.radius * circleB.radius * Math.PI" also works
        // but note direct access to private instance variables should be avoided
    }

    // Test the class Circle
    public static void main(String[] args) {
        Circle c1 = new Circle(1);
        Circle c2 = new Circle(5, 5, 5);
        c1.setRadius(5);
        c1.setCenter(3, 3);

        System.out.println("c1 circle has a radius of " + c1.getRadius() + ", area of " +
            c1.getArea() + ", center at" + c1.getCenter()[1] + ", circumference of" +
            c1.getCircumference());
        System.out.println(c1.isBiggerThan(c2));
        System.out.println(c1.containsPoint(c2.getCenter()[0], c2.getCenter()[1]));
        System.out.println(c1.equals(c2));
        System.out.println(c1);
    } 
}