class Point{
  private float x;
  private float y;

  public Point(float x, float y){
    setX(x);
    setY(y);
  }

  public Point(){
    x = 0.0f;
    y = 0.0f;
  }

  public float getX(){
    return x;
  }

  public void setX(float x){
    this.x = x;
  }

  public float getY(){
    return y;
  }

  public void setY(float y){
    this.y = y;
  }

  public void setXY(float x, float y){
    setX(x);
    setY(y);
  }

  public float[] getXY(){
    float[] res = {x, y};
    return res;
  }

  @Override
  public String toString(){
    return "(" + x + "," + y + ")";
  }
}

class MovablePoint extends Point{
  private float xSpeed;
  private float ySpeed;

  public MovablePoint(float x, float y, float xSpeed, float ySpeed){
    super(x, y);
    setXSpeed(xSpeed);
    setYSpeed(ySpeed);
  }

  public MovablePoint(float xSpeed, float ySpeed){
    super();
    setXSpeed(xSpeed);
    setYSpeed(ySpeed);
  }

  public MovablePoint(){
    super();
    xSpeed = 0.0f;
    ySpeed = 0.0f;
  }

  public float getXSpeed(){
    return xSpeed;
  }

  public void setXSpeed(float xSpeed){
    this.xSpeed = xSpeed;
  }

  public float getYSpeed(){
    return ySpeed;
  }

  public void setYSpeed(float ySpeed) {
    this.ySpeed = ySpeed;
  }

  public void setSpeed(float xSpeed, float ySpeed){
    setXSpeed(xSpeed);
    setYSpeed(ySpeed);
  }

  public float[] getSpeed(){
    float[] res = {xSpeed, ySpeed};
    return res;
  }

  public String toString(){
    return super.toString() + ",speed=(" + xSpeed + "," + ySpeed +")";
  }

  public MovablePoint move(){
    float newX = super.getX() + xSpeed;
    float newY = super.getY() + ySpeed;

    super.setX(newX);
    super.setY(newY);

    return this;
  }
}

public class Test4_4 {
  public static void main(String[] args){
    MovablePoint mvPoint = new MovablePoint(2.0f, 3f, 4f, 9f);
    System.out.println(mvPoint.toString());
    System.out.println(mvPoint.move());
  }
}
