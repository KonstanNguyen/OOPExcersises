abstract class Shape {
  protected String color;
  protected boolean filled;

  public Shape() {
    this.color = "red";
    this.filled = true;
  }

  public Shape(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public abstract double getArea();

  public abstract double getPerimeter();

  @Override
  public String toString() {
    return getClass().getName() + "[color=" + color + ",filled=" + filled + "]";
  }
}

class Circle extends Shape {
  protected double radius;

  public Circle() {
    super();
    this.radius = 1.0;
  }

  public Circle(double radius) {
    super();
    this.radius = radius;
  }

  public Circle(double radius, String color, boolean filled) {
    super(color, filled);
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public String toString() {
    return super.toString() + "[radius=" + radius + "]";
  }
}

class Rectangle extends Shape {
  protected double width;
  protected double length;

  public Rectangle() {
    super();
    this.width = 1.0;
    this.length = 1.0;
  }

  public Rectangle(double width, double length) {
    super();
    this.width = width;
    this.length = length;
  }

  public Rectangle(double width, double length, String color, boolean filled) {
    super(color, filled);
    this.width = width;
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  @Override
  public double getArea() {
    return width * length;
  }

  @Override
  public double getPerimeter() {
    return 2 * (width + length);
  }

  @Override
  public String toString() {
    return super.toString() + "[width=" + width + ", length=" + length + "]";
  }
}

class Square extends Rectangle{
  public Square(){
    super();
  }

  public Square(double side){
    super(side, side);
  }

  public Square(double side, String name, boolean filled){
    super(side, side, name, filled);
  }

  public double getSide(){
    return super.getLength();
  }

  public void setSide(double side){
    setLength(side);
    setWidth(side);
  }

  public void setWidth(double side){
    super.setWidth(side);
  }

  public void setLength(double side){
    super.setLength(side);
  }

  public String toString(){
    return super.toString();
  }
}

public class Test6_1 {
  public static void main(String[] args) {
    Shape s1 = new Circle(5.5, "red", false); // Upcast Circle to Shape
    System.out.println(s1); // which version?
    System.out.println(s1.getArea()); // which version?
    System.out.println(s1.getPerimeter()); // which version?
    System.out.println(s1.getColor());
    System.out.println(s1.isFilled());
    // System.out.println(s1.getRadius());

    Circle c1 = (Circle) s1; // Downcast back to Circle
    System.out.println(c1);
    System.out.println(c1.getArea());
    System.out.println(c1.getPerimeter());
    System.out.println(c1.getColor());
    System.out.println(c1.isFilled());
    System.out.println(c1.getRadius());

    // Shape s2 = new Shape(); //Error

    Shape s3 = new Rectangle(1.0, 2.0, "red", false); // Upcast
    System.out.println(s3);
    System.out.println(s3.getArea());
    System.out.println(s3.getPerimeter());
    System.out.println(((Rectangle)s3).getColor());
    // System.out.println(s3.getLength());

    Rectangle r1 = (Rectangle) s3; // downcast
    System.out.println(r1);
    System.out.println(r1.getArea());
    System.out.println(r1.getColor());
    System.out.println(r1.getLength());

    Shape s4 = new Square(6.6); // Upcast
    System.out.println(s4);
    System.out.println(s4.getArea());
    System.out.println(((Square)s4).getColor());
    // System.out.println(s4.getSide());

    // Take note that we downcast Shape s4 to Rectangle,
    // which is a superclass of Square, instead of Square
    Rectangle r2 = (Rectangle) s4;
    System.out.println(r2);
    System.out.println(r2.getArea());
    System.out.println(r2.getColor());
    // System.out.println(r2.getSide());
    System.out.println(r2.getLength());

    // Downcast Rectangle r2 to Square
    Square sq1 = (Square) r2;
    System.out.println(sq1);
    System.out.println(sq1.getArea());
    System.out.println(sq1.getColor());
    System.out.println(sq1.getSide());
    System.out.println(sq1.getLength());
  }
}
