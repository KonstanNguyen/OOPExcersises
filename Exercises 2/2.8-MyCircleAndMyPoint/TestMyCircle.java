class MyPoint{
  private int x; 
  private int y;

  public MyPoint(){
    x = 0;
    y = 0;
  }

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

class MyCircle{
  private MyPoint center;
  private int radius;

  public MyCircle(){
    center = new MyPoint();
    this.radius = 1;
  }
  public MyCircle(int x, int y, int radius){
    center = new Point(x, y);
    this.radius = radius;
  }

  public MyCircle(MyPoint center, int radius){
    this.center = center;
    this.radius = radius;
  }

  public int getRadius(){
    return radius;
  }

  public void setRadius(int radius){
    this.radius = radius;
  }

  public MyPoint getCenter(){
    return center;
  }

  public void setCenter(MyPoint center){
    this.center = center;
  }

  public int getCenterX(){
    return center.getX();
  }

  public void setCenterX(int x){
    center.setX(x);
  }

  public int getCenterY(){
    return center.getY();
  }
  public void setCenterY(int y){
    center.setY(y);
  }

  public int[] getCenterXY(){
    return center.getXY();
  }

  public void setCenterXY(int x, int y){
    center.setXY(x, y);
  }

  public String toString(){
    return getClass().getName() + "[radius=" + radius + ",center=" + center.toString() + "]";
  }

  public double getArea(){
    return Math.PI * radius * radius;
  }

  public double getCircumference(){
    return Math.PI * 2 * radius;
  }

  public double distance(MyCircle another){
    return center.distance(another.center);
  }
}

public class TestMyCircle{
  public static void main(String[] args){

  }
}
