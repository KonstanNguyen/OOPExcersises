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

class MovableCircle implements Movable {
  private MovablePoint center;
  private int radius;

  // Constructor
  public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
    center = new MovablePoint(x, y, xSpeed, ySpeed);
    this.radius = radius;
  }

  public String toString() {
    return getClass().getName() + "[center=" + center + ",radius=" + radius + "]";
  }

  @Override
  public void moveUp() {
    center.moveUp();
  }

  public void moveDown() {
    center.moveDown();
  }

  public void moveLeft() {
    center.moveLeft();
  }

  public void moveRight() {
    center.moveRight();
  }
}

public class Test6_4 {
  public static void main(String[] args) {
    MovablePoint point = new MovablePoint(3, 5, 2, 3);
    MovableCircle circle = new MovableCircle(1, 2, 4, 5, 6);

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
