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

/**
 * +--------------------------------+
 * | MyRectangle                    |
 * +--------------------------------+
 * | - topLeft: MyPoint             |
 * | - bottomRight: MyPoint         |
 * +--------------------------------+
 * | + isNotRectangle(double a,     |
 * |                       double b)|
 * | + MyRectangle(p1: MyPoint,     |
 * |                    p2: MyPoint)|
 * | + getTopLeft(): MyPoint        |
 * | + setTopLeft(p: MyPoint): void |
 * | + getBottomRight(): MyPoint    |
 * | + setBottomRight(p: MyPoint):  |
 * | + getWidth(): double           |
 * | + getHeight(): double          |
 * | + getArea(): double            |
 * | + getPerimeter(): double       |
 * | + isSquare(): boolean          |
 * | + toString(): String           |
 * +--------------------------------+
 */

class MyRectangle {
  private MyPoint topLeft;
  private MyPoint bottomRight;

  public static boolean isNotRectangle(double a, double b) {
    return (a == 0) || (b == 0);
  }

  public MyRectangle(int x1, int y1, int x2, int y2) {
    topLeft = new MyPoint(x1, y1);
    bottomRight = new MyPoint(x2, y2);
  }

  public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
    this.topLeft = topLeft;
    this.bottomRight = bottomRight;
  }

  public String toString() {
    return getClass().getName() + "[top-left=" + topLeft.toString() + ",bottom-right=" + bottomRight.toString() + "]";
  }

  public MyPoint getTopLeft() {
    return topLeft;
  }

  public void setTopLeft(MyPoint topLeft) {
    this.topLeft = topLeft;
  }

  public MyPoint getBottomRight() {
    return bottomRight;
  }

  public void setBottomRight(MyPoint bottomRight) {
    this.bottomRight = bottomRight;
  }

  public double getWidth() {
    return Math.abs(topLeft.getX() - bottomRight.getX());
  }

  public double getHeight() {
    return Math.abs(topLeft.getY() - bottomRight.getY());
  }

  public double getArea() {
    return getWidth() * getHeight();
  }

  public double getPerimeter() {
    return 2 * (getWidth() + getHeight());
  }

  public boolean isSquare() {
    return getWidth() == getHeight();
  }
}

public class MyRectangleTest {
  public static void main(String[] args) {
    MyPoint topLeft = new MyPoint(2, 4);
    MyPoint bottomRight = new MyPoint(7, 1);

    MyRectangle rectangle = new MyRectangle(topLeft, bottomRight);

    System.out.println("Rectangle Info:" + rectangle.toString());
    System.out.println("Top-Left: " + rectangle.getTopLeft().toString());
    System.out.println("Bottom-Right: " + rectangle.getBottomRight().toString());
    System.out.println("Width: " + rectangle.getWidth());
    System.out.println("Height: " + rectangle.getHeight());
    System.out.println("Area: " + rectangle.getArea());
    System.out.println("Perimeter: " + rectangle.getPerimeter());
    System.out.println("Is a square? " + rectangle.isSquare());
  }
}