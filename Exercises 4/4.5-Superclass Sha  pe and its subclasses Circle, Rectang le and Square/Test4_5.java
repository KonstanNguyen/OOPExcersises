import java.util.ArrayList;

class Shape {
  private String color = "red";
  private boolean filled = true;

  public Shape() {

  }

  public Shape(String color, boolean filled) {
    setColor(color);
    setFilled(filled);
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

  @Override
  public String toString() {
    return getClass().getName() +
        "[color=" + color +
        "][filled=" + filled + "]";
  }
}

class Circle extends Shape {
  private double radius = 1.0;

  public Circle() {
    super();
  }

  public Circle(double radius) {
    super();
    setRadius(radius);
  }

  public Circle(double radius, String color, boolean filled) {
    super(color, filled);
    setRadius(radius);
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    if (radius < 0) {
      throw new IllegalArgumentException("Invalid radius!");
    }
    this.radius = radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public double getPerimeter() {
    return Math.PI * 2 * radius;
  }

  @Override
  public String toString() {
    return super.toString() +
        "[radius=" + radius + "]";

  }
}

class Rectangle extends Shape {
  private double width = 1.0;
  private double length = 1.0;

  public Rectangle() {
    super();
  }

  public Rectangle(double width, double length) {
    super();
    this.width = width;
    this.length = length;
  }

  public Rectangle(double width, double length, String color, boolean filled) {

  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    if (width < 0) {
      throw new IllegalArgumentException("Invalid width!");
    }

    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    if (length < 0) {
      throw new IllegalArgumentException("Invalid length!");
    }

    this.length = length;
  }

  public double getArea() {
    return width * length;
  }

  public double getPerimeter() {
    return 2 * (width + length);
  }

  public String toString() {
    return super.toString() +
        "[length=" + length +
        "][width=" + width + "]";
  }
}

class Square extends Rectangle {
  public Square() {
    super();
  }

  public Square(double side) {
    super(side, side);
  }

  public Square(double side, String color, boolean filled) {
    super(side, side, color, filled);
  }

  public double getSide() {
    return super.getLength();
  }

  public void setSide(double side) {
    setLength(side);
    setWidth(side);
  }

  public void setWidth(double side) {
    super.setWidth(side);
  }

  public void setLength(double side) {
    super.setLength(side);
  }

  public String toString() {
    return super.toString();
  }
}

public class Test4_5 {

  public static void main(String[] args) {
    ArrayList<Shape> shapes = new ArrayList<>();

    shapes.add(new Shape());
    shapes.add(new Shape("Blue", true));
    shapes.add(new Circle());
    shapes.add(new Circle(1.5));
    shapes.add(new Circle(1.5, "Green", true));
    shapes.add(new Rectangle());
    shapes.add(new Rectangle(1, 2));
    shapes.add(new Rectangle(3, 4, "Violet", true));
    shapes.add(new Square());
    shapes.add(new Square(3));
    shapes.add(new Square(3, "Yellow", true));

    for (Shape x : shapes) {
      System.out.println(x.toString());
      if (x instanceof Circle) {
        System.out.println("Area: " + ((Circle) x).getArea());
        System.out.println("Perimeter: " + ((Circle) x).getPerimeter());
      } else if (x instanceof Square) {
        System.out.println("Area: " + ((Square) x).getArea());
        System.out.println("Perimeter: " + ((Square) x).getPerimeter());
      } else if (x instanceof Rectangle) {
        System.out.println("Area: " + ((Rectangle) x).getArea());
        System.out.println("Perimeter: " + ((Rectangle) x).getPerimeter());
      }
      System.out.println();
    }
  }

}
