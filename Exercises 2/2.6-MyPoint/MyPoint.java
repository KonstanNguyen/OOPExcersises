import java.util.ArrayList;

class MyPoint{
  private int x; 
  private int y;

  public MyPoint(){}

  public MyPoint(int x, int y){
    setXY(x, y);
  }

  public int getX(){
    return x;
  }

  public void setX(int x){
    this.x = x;
  }

  public int getY(){
    return y;
  }

  public void setY(int y){
    this.y = y;
  }

  public int[] getXY(){
    return new int[]{x,y};
  }

  public void setXY(int x, int y){
    setX(x);
    setY(y);
  }

  public String toString(){
    return "(" + x + ", " + y + ")";
  }

  public double distance(int x, int y){
    int xDiff = this.x - x;
    int yDiff = this.y - y;

    return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
  }

  public double distance(MyPoint anotherPoint){
    int xDiff = this.x - anotherPoint.x;
    int yDiff = this.y - anotherPoint.y;

    return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
  }

  public double distance(){
    return Math.sqrt(this.x*this.x + this.y*this.y);
  }

  public static void main(String[] args){
    ArrayList<MyPoint> points = new ArrayList<>();  // Declare and allocate an array of MyPoint
    for (int i = 0; i < 10; i++) {
      points.add(new MyPoint(i, i));    // Allocate each of MyPoint instances
    }

    MyPoint p2 = new MyPoint(1, 4);
    System.out.println(p2.toString());
    p2.setXY(1, 2);
    System.out.println("Test setXY(1,2): " + p2.toString());
    p2.setX(2);
    System.out.println("Test setX(2): " + p2.toString());
    p2.setY(4);
    System.out.println("Test setY(4): " + p2.toString());

    for(MyPoint point : points){
      System.out.println("x is: " + point.getX());  // Test getters
      System.out.println("y is: " + point.getY());
      System.out.println(point.toString());

      System.out.println("Distance " + point.toString() + " to " + p2.toString() + ": " + point.distance(p2));    // which version?
      System.out.println("Distance " + p2.toString() + " to " + point.toString() + ": " + p2.distance(point));    // which version?
      System.out.println("Distance " + p2.toString() + " to (5, 6): " + point.distance(5, 6));  // which version?
      System.out.println("Distance " + p2.toString() + " to (0, 0): " + point.distance());      // which version?
    }
  }
}