class Ball {
  private float x;
  private float y;
  private float z;

  public Ball(float x, float y, float z) {
    setXYZ(x, y, z);
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public float getZ() {
    return z;
  }

  public void setXYZ(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public String toString() {
    return "(" + x + "," + y + "," + z + ")";
  }

  public static void main(String[] args) {
    Ball ball = new Ball(2, 3, 4);
    System.out.println(ball.toString());

    ball.setXYZ(1, 2, 5);
    System.out.println(ball.toString());

    System.out.println("x: " + ball.getX());
    System.out.println("y: " + ball.getY());
    System.out.println("z: " + ball.getZ());
  }
}

class Player {
  private int number;
  private float x;
  private float y;
  private float z;

  public Player(int number, float x, float y) {
    this.number = number;
    this.x = x;
    this.y = y;
    this.z = 0.0f;
  }

  public void move(float xDisp, float yDisp) {
    x += xDisp;
    y += yDisp;
  }

  public void jump(float zDisp) {
    z += zDisp;
  }

  public boolean near(Ball ball) {
    float distance = (float) Math.sqrt(Math.pow(x - ball.getX(), 2) + Math.pow(y - ball.getY(), 2));
    return distance < 8.0f;
  }

  public void kick(Ball ball) {
    ball.setXYZ(ball.getX() + 2.0f, ball.getY() + 2.0f, ball.getZ() + 1.0f);
  }

  public static void main(String[] args) {
    Player player1 = new Player(1, 10.0f, 10.0f);
    Player player2 = new Player(2, 20.0f, 20.0f);
    Ball ball = new Ball(15.0f, 15.0f, 0.0f);

    System.out.println("Initial Player 1: " + player1);
    System.out.println("Initial Player 2: " + player2);
    System.out.println("Initial Ball: " + ball);

    player1.move(5.0f, 5.0f);
    player2.jump(2.0f);

    System.out.println("After Player 1 moves and Player 2 jumps:");
    System.out.println(player1);
    System.out.println(player2);

    if (player1.near(ball)) {
      player1.kick(ball);
      System.out.println("Player 1 kicks the ball: " + ball);
    }
  }
}