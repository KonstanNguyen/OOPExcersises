interface GeometricObject {
  public double getPerimeter();

  public double getArea();
}

class Circle implements GeometricObject {
  protected double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getPerimeter() {
    return Math.PI * 2 * radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }
}

interface Resizable {
  public void resize(int percent);
}

class ResizableCircle extends Circle implements Resizable {
  public ResizableCircle(double radius) {
    super(radius);
  }

  public String toString() {
    return getClass().getName() + "[radius=" + radius + "]";
  }

  public void resize(int percent) {
    this.radius = this.radius * percent / 100.0;
  }
}

public class Test6_5 {
  public static void main(String[] args) {
    ResizableCircle circle = new ResizableCircle(5.0);
    System.out.println("Original Circle: " + circle);

    circle.resize(50); // Resize the circle by 50%
    System.out.println("Resized Circle: " + circle);

    double area = circle.getArea();
    double perimeter = circle.getPerimeter();

    System.out.println("Area: " + area);
    System.out.println("Perimeter: " + perimeter);
  }
}
