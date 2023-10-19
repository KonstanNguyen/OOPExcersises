import java.util.List;
import java.util.ArrayList;

class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int[] getXY() {
    int[] res = { x, y };
    return res;
  }

  public void setXY(int x, int y) {
    setX(x);
    setY(y);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public double distance(Point another) {
    double xDiff = this.x - another.x;
    double yDiff = this.y - another.y;
    return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
  }
}

public class PolyLine {
  private List<Point> points; // List of Point instances

  // Constructors
  public PolyLine() { // default constructor
    points = new ArrayList<Point>(); // implement with ArrayList
  }

  public PolyLine(List<Point> points) {
    this.points = points;
  }

  // Append a point (x, y) to the end of this polyline
  public void appendPoint(int x, int y) {
    Point newPoint = new Point(x, y);
    points.add(newPoint);
  }

  // Append a point instance to the end of this polyline
  public void appendPoint(Point point) {
    points.add(point);
  }

  // Return {(x1,y1)(x2,y2)(x3,y3)....}
  public String toString() {
    // Use a StringBuilder to efficiently build the return String
    StringBuilder sb = new StringBuilder("{");
    for (Point aPoint : points) {
      sb.append(aPoint.toString());
    }
    sb.append("}");
    return sb.toString();
  }

  // Return the total length of this polyline
  public double getLength() {
    double res = 0.0;
    Point aPoint = points.get(0);
    for (int i = 1; i < points.size(); i++) {
      res += aPoint.distance(points.get(i));
    }
    return res;
  }

  public static void main(String[] args) {
    // Test default constructor and toString()
    PolyLine l1 = new PolyLine();
    System.out.println(l1); // {}

    // Test appendPoint()
    l1.appendPoint(new Point(1, 2));
    l1.appendPoint(3, 4);
    l1.appendPoint(5, 6);
    System.out.println(l1); // {(1,2)(3,4)(5,6)}

    // Test constructor 2
    List<Point> points = new ArrayList<Point>();
    points.add(new Point(11, 12));
    points.add(new Point(13, 14));
    PolyLine l2 = new PolyLine(points);
    System.out.println(l2); // {(11,12)(13,14)}
  }
}
