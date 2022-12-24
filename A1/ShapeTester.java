/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE SOURCES. David Chen
*/

public class ShapeTester {

  // A public method which takes as input a circle and then
  // a rectangle and returns true if the area of the circle
  // is bigger than or equal to the area of the rectangle
  // and false otherwise
  public static boolean isLarger(Circle c, Rectangle r) {
    return c.getArea() >= r.area();
  }

  // A public method which takes as input a circle and then
  // a rectangle and returns true if the circumference of
  // the circle is greater than the perimeter of the 
  // rectangle and false otherwise
  public static double longerPerim(Circle c, Rectangle r) {
    if (c.getCircumference() > r.perimeter()) {
      return c.getCircumference();
    }
    return r.perimeter();
  }

  // A public method which takes as input a rectangle and then
  // a circle and returns true if the perimeter of the 
  // rectangle is greater than the circumference of the circle
  // and false otherwise
  public static double longerPerim(Rectangle r, Circle c) {
    if (r.perimeter() > c.getCircumference()) {
      return r.perimeter();
    }
    return c.getCircumference();
  }

  // A public method which takes as input a circle followed by
  // a rectangle and returns the area of the larger of the two objects
  public static double largerArea(Circle c, Rectangle r) {
    if (c.getArea() > r.area()) {
      return c.getArea();
    }
    return r.area();
  }

  // Overloading the method above with a functionally equivalent one
  // that takes as input a rectangle followed by a circle
  public static double largerArea(Rectangle r, Circle c) {
    if (r.area() > c.getArea()) {
      return r.area();
    }
    return c.getArea();
  }

  // A public method which returns true if the first circle contains 
  // the center of the second circle and false otherwise
  public static boolean containsCenter(Circle c1, Circle c2) {
    double[] center = c2.getCenter();
    return c1.containsPoint(center[0], center[1]);
  }

  public static void main(String[] args) {
    // Test the class ShapeTester
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

    // Test the class Rectangle
    Rectangle r1 = new Rectangle();
    Rectangle r2 = new Rectangle(10.0, 5.0, 0.0, 10.0);
    r1.setLength(10.0);
    r1.setHeight(5.0);

    System.out.println("r1 has height " + r1.getHeight() + " and perimeter " + r1.perimeter());
    System.out.println("r2 has length " + r2.getLength() + " and area " + r2.area());
    System.out.println(r1.equals(r2));

    // Test the class Cylinder
    Cylinder cyl1 = new Cylinder();
    Cylinder cyl2 = new Cylinder(0.0, 0.0, 5.0, 10.0);

    cyl2.setHeight(10);
    cyl2.setHeight(10.0);
    cyl2.setRadius(5.0);
    cyl2.setRadius(5); // method inherited from class Circle;

    System.out.println(cyl1.getHeight());
    System.out.println(cyl1.getArea());
    System.out.println(cyl2.getVolume());
    System.out.println(cyl2); // toString method inherited from class Cylinder

    // Test the class ShapeTester
    System.out.println(isLarger(c1, r1));
    System.out.println(longerPerim(c2, r2));
    System.out.println(longerPerim(r2, c2));
    System.out.println(largerArea(c2, r2));
    System.out.println(largerArea(r2, c2));
    System.out.println(containsCenter(c1, c2));
  }
}
