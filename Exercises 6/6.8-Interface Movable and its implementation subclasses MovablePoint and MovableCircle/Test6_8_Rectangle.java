interface Movable {
  void moveUp();

  void moveDown();

  void moveLeft();

  void moveRight();
}

class MovablePoint implements Movable {
  int x;
  int y;
  int xSpeed;
  int ySpeed;

  public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
    this.x = x;
    this.y = y;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  @Override
  public void moveUp() {
    y += ySpeed;
  }

  @Override
  public void moveDown() {
    y -= ySpeed;
  }

  @Override
  public void moveLeft() {
    x -= xSpeed;
  }

  @Override
  public void moveRight() {
    x += xSpeed;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

class MovableRectangle implements Movable{
  private MovablePoint topLeft;
  private MovablePoint bottomRight;

  public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed){
    topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
    bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
  }

  public String toString(){
    return getClass().getName() + "[topLeft=(" + topLeft.x + topLeft.y + "),bottomRight=(" + bottomRight.x + "," + bottomRight.y + "),speed=(" + topLeft.xSpeed + "," + topLeft.ySpeed + "]";
  }
  
  public void moveUp(){
    topLeft.moveUp();
    bottomRight.moveUp();
  }

  public void moveDown(){
    topLeft.moveDown();
    bottomRight.moveDown();
  }

  public void moveLeft(){
    topLeft.moveLeft();
    bottomRight.moveLeft();
  }

  public void moveRight(){
    topLeft.moveRight();
    bottomRight.moveRight();
  }
}

public class Test6_8_Rectangle {
  public static void main(String[] args) {
    MovablePoint point = new MovablePoint(3, 5, 2, 3);
    MovableRectangle circle = new MovableRectangle(1, 2, 4, 5, 6, 2);

    System.out.println("Original Point: " + point.toString());
    System.out.println("Original Circle: " + circle.toString());

    point.moveUp();
    circle.moveDown();
    point.moveLeft();
    circle.moveRight();

    System.out.println("After moving Point: " + point.toString());
    System.out.println("After moving Circle: " + circle.toString());
  }
}
