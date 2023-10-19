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

class Line{
  private Point begin;
  private Point end;

  public Line(double beginX, double beginY, double endX, double endY){
    this.begin = new Point(beginX, beginY);
    this.end = new Point(endX, endY);
  }
  
  public Line(Point begin, Point end){
    setBegin(begin);
    setEnd(end);
  }

  public Point getBegin(){
    return begin;
  }

  public void setBegin(Point begin){
    this.begin = begin;
  }

  public Point getEnd(){
    return end;
  }

  public void setEnd(Point end){
    this.end = end;
  }

  public double getLength(){
    return Math.sqrt(
      (end.getX() - begin.getX()) *
      (end.getX() - begin.getX()) +
      (end.getY() - begin.getY()) *
      (end.getY() - begin.getY())
    );
  }

  public String toString(){
    return begin.toString() + end.toString();
  }
}

public class Test5_1{
  public static void main(String[] args){
    Point p1 = new Point(1.2, 3.4);
    Point p2 = new Point(1, 3);
    System.out.println("P1: " + p1.toString());
    System.out.println("P2: " + p2.toString());

    Line line = new Line(3, 4, 2, 1);
    System.out.println("Line: " + line.toString());
    System.out.println("Length of line: " + line.getLength());
  }
}

