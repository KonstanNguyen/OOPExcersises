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
}

class MyLine{
  private Point begin;
  private Point end;

  public MyLine(int x1, int y1, int x2, int y2){
    begin.setXY(x1, y1);
    end.setXY(x2, y2);
  }

  public MyLine(Point begin, Point end){
    this.begin = begin;
    this.end = end;
  }

  public MyPoint getBegin(){
    return begin;
  }

  public void setBegin(Point begin){
    this.begin = begin;
  }

  public MyPoint getEnd(){
    return end;
  }

  public void setEnd(Point end){
    this.end = end;
  }

  public int getBeginX(){
    return begin.getX();
  }

  public void setBeginX(int x){
    begin.setX(x);
  }

  public int getBeginY(){
    return begin.getY();
  }

  public void setBeginY(int y){
    begin.setY(y);
  }

  public int getEndX(){
    return end.getX();
  }

  public void setEndX(int x){
    end.setX(x);
  }

  public int getEndY(){
    return end.getY();
  }

  public void setEndY(int y){
    end.setY(y);
  }

  public int[] getBeginXY(){
    begin.getXY();
  }

  public void setBeginXY(int x, int y){
    begin.setXY(x, y);
  }

  public int[] getEndXY(){
    return end.getXY();
  }

  public void setEndXY(int x, int y){
    end.setXY(x, y);
  }

  public double geLength(){
    return begin.distanceTo();
  }

  public double getGradient(){
    int xDiff = begin.x - end.x;
    int yDiff = begin.y - end.y;
    return Math.atan2(yDiff, xDiff);
  }

  public String toString(){
    return getClass().getName() + "[begin=" + begin.toString() + ", end=" + end.toString() + "]";
  }
}