class Circle{
  private double radius;
  private String color;

  public Circle() {
    radius = 1.0;
    color = "red";
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public Circle(double radius, String color) {
    this.radius = radius;
    this.color = color;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    if(radius < 0){class Circle{
  private double radius;
  private String color;

  public Circle() {
    radius = 1.0;
    color = "red";
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public Circle(double radius, String color) {
    this.radius = radius;
    this.color = color;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    if(radius < 0){
      throw new IllegalArgumentException("Invalid radius!");
    }

    this.radius = radius;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return getClass().getName() + "[radius=" + radius + ",color=" + color + "]";
  }
}

class Cylinder{
  private Circle base;
  private double height;

  public Cylinder() {
    base = new Circle();
    height = 1.0;
  }

  public Cylinder(double radius) {
    base = new Circle(radius);
    height = 1.0;
  }

  public Cylinder(double radius, double height) {
    base = new Circle(radius);
    this.height = height;
  }

  public Cylinder(double radius, double height, String color) {
    base = new Circle(radius, color);
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    try {
      this.height = height;
    } catch (Exception e) {
      System.out.println("Invalid height!");
    }
  }

  public double getVolume() {
    return base.getArea() * height;
  }

  @Override
  public String toString() {
    return getClass().getName() + "[" + base.toString() + "]" + "[height=" + height + "]";
  }
}

public class Test5_2{
  public static void main(String[] args){
    Cylinder cylinder = new Cylinder();

    System.out.println(cylinder.toString());
  }
}
      throw new IllegalArgumentException("Invalid radius!");
    }

    this.radius = radius;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return getClass().getName() + "[radius=" + radius + ",color=" + color + "]";
  }
  public int compareTo(Circle other){
    return Double.compare(this.radius, other.radius);
  }
}

class Cylinder{
  private double height;

  public Cylinder() {
    super();
    height = 1.0;
  }

  public Cylinder(double radius) {
    super(radius);
    height = 1.0;
  }

  public Cylinder(double radius, double height) {
    super(radius);
    this.height = height;
  }

  public Cylinder(double radius, double height, String color) {
    super(radius, color);
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    try {
      this.height = height;
    } catch (Exception e) {
      System.out.println("Invalid height!");
    }
  }

  public double getVolume() {
    return super.getArea() * height;
  }

  @Override
  public String toString() {
    return super.toString() + "[height=" + height + "]";
  }
}  
