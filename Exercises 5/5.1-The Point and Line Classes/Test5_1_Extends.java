class Point{
  private double x;
  private double y;

  public Point(double x, double y){
    setXY(x, y);
  }

  public double getX(){
    return x;
  }
  
  public double getY(){
    return y;
  }

  public void setX(double x){
    this.x = x;
  }

  public void setY(double y){
    this.y = y;
  }

  public void setXY(double x, double y){
    setX(x);
    setY(y);
  }

  public String toString(){
    return "(" + x + ";" + y + ")";
  }
}

class LineSub extends Point{
  private Point end;

  public LineSub(double beginX, double beginY, double endX, double endY){
    super(beginX, beginY);
    this.end = new Point(endX, endY);
  }
  
  public LineSub(Point begin, Point end){
    super(begin.getX(), begin.getY());
    this.end = end;
  }

  public Point getEnd(){
    return end;
  }

  public void setEnd(Point end){
    this.end = end;
  }

  public double getLength(){
    return Math.sqrt(
      (end.getX() - super.getX()) *
      (end.getX() - super.getX()) +
      (end.getY() - super.getY()) *
      (end.getY() - super.getY())
    );
  }

  public String toString(){
    return super.toString() + end.toString();
  }
}

public class Test5_1_Extends{
  public static void main(String[] args){
    Point p1 = new Point(1.2, 3.4);
    Point p2 = new Point(1, 3);
    System.out.println("P1: " + p1.toString());
    System.out.println("P2: " + p2.toString());

    LineSub line = new LineSub(3, 4, 2, 1);
    System.out.println("Line: " + line.toString());
    System.out.println("Length of line: " + line.getLength());
  }
}

