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

public class N21DCCN156 {
  public static void main(String[] args) {
    MovablePoint point = new MovablePoint(3, 5, 2, 3);

    System.out.println("Original Point: " + point.toString());

    point.moveUp();
    point.moveLeft();

    System.out.println("After moving Point: " + point.toString());
  }
}
