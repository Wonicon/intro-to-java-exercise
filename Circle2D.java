// assignment 2 10.11

import java.util.Map;

public class Circle2D {
  /**
   * The horizontal position
   */
  private double x;

  /**
   * Get the x value.
   * @return The x value.
   */
  public double getX() { return x; }

  /**
   * The vertical position
   */
  private double y;

  /**
   * Get the y value.
   * @return The y value.
   */
  public double getY() { return y; }

  /**
   * The radius of the circle.
   */
  private double radius;

  /**
   * Get the radius value.
   * @return The radius value.
   */
  public double getRadius() { return radius; }

  public Circle2D() {
    this(0, 0, 1);
  }

  public Circle2D(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  /**
   * Get the area of this circle.
   * @return The area value.
   */
  public double getArea() {
    return Math.PI * radius * radius;
  }

  /**
   * Get the perimeter of this circle.
   * @return The perimeter value.
   */
  public double getPerimeter() {
    return Math.PI * radius * 2;
  }

  /**
   * Check whether point (x, y) is inside the circle.
   * @param x The x value of the given point.
   * @param y The y value of the given point.
   * @return True if inside, false otherwise.
   */
  public boolean contains(double x, double y) {
    return Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) < Math.pow(radius, 2);
  }

  /**
   * Calculate the distance of the two circles' center point.
   * @param circle The other circle.
   * @return The distance.
   */
  private double distance(Circle2D circle) {
    return Math.sqrt(Math.pow(this.x - circle.x, 2) + Math.pow(this.y - circle.y, 2));
  }

  /**
   * Check whether a circle is inside this one.
   * @param circle The given circle.
   * @return True if inside, false otherwise.
   */
  public boolean contains(Circle2D circle) {
    return distance(circle) < this.radius - circle.radius;
  }

  /**
   * Check whether a circle is overlapped with this one.
   * @param circle The other circle.
   * @return True if overlapped, false otherwise.
   */
  public boolean overlaps(Circle2D circle) {
    return distance(circle) < this.radius + circle.radius;
  }

  public static void main(String[] args) {
    Circle2D c1 = new Circle2D(2, 2, 5.5);
    System.out.println("c1.contains(3, 3) is " + c1.contains(3, 3));
    System.out.println("c1.contains(new Circle2D(4, 5, 10.5)) is " + c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println("c1.overlaps(new Circle2D(3, 5, 2.3)) is " + c1.overlaps(new Circle2D(3, 5, 2.3)));
  }
}
