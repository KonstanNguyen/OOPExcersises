class TriangleEdgesException extends Exception{
  public TriangleEdgesException(String message){
    super(message);
  }
}

class MyPoint {
  private int x;
  private int y;

  public MyPoint() {
  }

  public MyPoint(int x, int y) {
    setXY(x, y);
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int[] getXY() {
    return new int[] { x, y };
  }

  public void setXY(int x, int y) {
    setX(x);
    setY(y);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public double distance(int x, int y) {
    int xDiff = this.x - x;
    int yDiff = this.y - y;

    return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
  }

  public double distance(MyPoint anotherPoint) {
    int xDiff = this.x - anotherPoint.x;
    int yDiff = this.y - anotherPoint.y;

    return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
  }

  public double distance() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }
}

class MyTriangle {
  private MyPoint v1;
  private MyPoint v2;
  private MyPoint v3;

  public static boolean isNotTriangle(double a, double b, double c){
    return (a >= (b + c) || c >= (b + a) || b >= (a + c));
  }

  public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    v1 = new MyPoint(x1, y1);
    v2 = new MyPoint(x2, y2);
    v3 = new MyPoint(x3, y3);
  }

  public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
    this.v1 = v1;
    this.v2 = v2;
    this.v3 = v3;
  }

  public String toString() {
    return getClass().getName() + "[v1=" + v1.toString() + ",v2=" + v2.toString() + ",v3=" + v3.toString() + "]";
  }

  public MyPoint getV1(){
    return v1;
  }

  public MyPoint getV2(){
    return v2;
  }
  
  public MyPoint getV3(){
    return v3;
  }

  public double getPerimeter(){
    
    double a = v1.distance(v2);
    double b = v2.distance(v3);
    double c = v3.distance(v1);

    return a + b + c;
  }

  public String getType(){
    double a = v1.distance(v2);
    double b = v2.distance(v3);
    double c = v3.distance(v1);

    if (a == b && b == c)
      return "Equilateral Triangle";

    if (a == b || c == a || c == b)
      return "Isosceles Triangle";

    return "Scalene Triangle";
  }
}

public class TestMyTriangle {
  public static void main(String[] args) {
    try{
      MyTriangle triangle1 = new MyTriangle(2, 4, 2, 2, 3, 6);
      if(isNotTriangle(
        triangle1.getV1().distance(triangle1.getV2()),
        triangle1.getV2().distance(triangle1.getV3()),
        triangle1.getV3().distance(triangle1.getV1())
      )){
        throw new TriangleEdgesException("Triangle 1 is not triangle!");
      }
      System.out.println(triangle1.toString());
      System.out.println("Perimeter: " + triangle1.getPerimeter());
      System.out.println("Type: " + triangle1.getType());
  
      MyPoint[] points = {
          new MyPoint(1, 2),
          new MyPoint(3, 4),
          new MyPoint(2, 4)
      };
      MyTriangle triangle2 = new MyTriangle(points[0], points[1], points[2]);
      
      if(isNotTriangle(
        triangle1.getV1().distance(triangle1.getV2()),
        triangle1.getV2().distance(triangle1.getV3()),
        triangle1.getV3().distance(triangle1.getV1())
      )){
        throw new TriangleEdgesException("Triangle 1 is not triangle!");
      }

      System.out.println(triangle2.toString());
      System.out.println("Perimeter: " + triangle2.getPerimeter());
      System.out.println("Type: " + triangle2.getType());
    }
    catch(TriangleEdgesException e){
      System.out.println(e.getMessage());
    }

  }

  private static boolean isNotTriangle(double distance, double distance2, double distance3) {
    return false;
  }
}