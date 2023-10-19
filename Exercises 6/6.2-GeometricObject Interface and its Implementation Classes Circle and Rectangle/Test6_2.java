interface GeoetricObject{
  public double getArea();
  public double getPerimeter();
}

class Circle implements GeoetricObject{
  private double radius;

  public Circle(double radius){
    if(radius < 0.0) throw new IllegalArgumentException("Invalid radius: " + radius);
    this.radius = radius;
  }

  public String toString(){
    return getClass().getName() + "[radius=" + radius + "]";
  }

  public double getArea(){
    return radius * radius * Math.PI;
  }

  public double getPerimeter(){
    return 2 * radius * Math.PI;
  }
}

class Rectangle implements GeoetricObject{
  private double width;
  private double length;

  public Rectangle(double width, double length){
    if(width < 0.0) throw new IllegalArgumentException("Invalid width: " + width);
    if(length < 0.0) throw new IllegalArgumentException("Invalid length: " + length);
    
    this.width = width;
    this.length = length;
  }

  public String toString(){
    return getClass().getName() + "[width=" + width + ",length=" + length + "]";
  }

  public double getArea(){
    return width * length;
  }

  public double getPerimeter(){
    return 2 * (length + width);
  }
}

public class Test6_2{
  public static void main(String[] args){
    Circle circle = new Circle(3);
    System.out.println(circle);
    System.out.println(circle.getArea());
    System.out.println(circle.getPerimeter());

    Rectangle rectangle = new Rectangle(3, 4);
    System.out.println(rectangle);
    System.out.println(rectangle.getArea());
    System.out.println(rectangle.getPerimeter());
  }
}
