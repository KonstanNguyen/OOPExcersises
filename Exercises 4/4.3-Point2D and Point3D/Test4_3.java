class Point2D{
  private float x;
  private float y;

  public Point2D(float x, float y) {
    setXY(x, y);
  }

  public Point2D(){
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

  public String toString(){
    return "(" + x + "," + y + ")";
  }
}

class Point3D extends Point2D{
  private float z;
  
  public Point3D(float x, float y, float z){
    super(x, y);
    setZ(z);
  }

  public Point3D(){
    super();
    z = 0.0f;
  }

  public float getZ(){
    return z;
  }

  public void setZ(float z){
    this.z = z;
  }

  public void setXYZ(float x, float y, float z){
    super.setXY(x, y);
    setZ(z);
  }

  public float[] getXYZ(){
    float[] res = {getX(), getY(), z};
    return res;
  }

  public String toString(){
    return "(" + super.getX() + "," + super.getY() + "," + z + ")";
  }
}

public class Test4_3{
  public static void main(String[] args){
    Point2D p2 = new Point2D();
    System.out.println(p2);

    Point3D p3 = new Point3D(1, 3, 4);
    System.out.println(p3);
  }
}
