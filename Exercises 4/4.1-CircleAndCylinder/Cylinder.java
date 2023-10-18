class Circle implements Comparable<Circle> {
  private double radius;
  private String color;

  public Circle() {
    radius = 1.0;
    color = "red";
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public Circle(double radius, String color) {
    this.radius = radius;
    this.color = color;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    if(radius < 0){
      throw new IllegalArgumentException("Invalid radius!");
    }

    this.radius = radius;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return getClass().getName() + "[radius=" + radius + ",color=" + color + "]";
  }
  public int compareTo(Circle other){
    return Double.compare(this.radius, other.radius);
  }
}

class Cylinder extends Circle {
  private double height;

  public Cylinder() {
    super();
    height = 1.0;
  }

  public Cylinder(double radius) {
    super(radius);
    height = 1.0;
  }

  public Cylinder(double radius, double height) {
    super(radius);
    this.height = height;
  }

  public Cylinder(double radius, double height, String color) {
    super(radius, color);
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    try {
      this.height = height;
    } catch (Exception e) {
      System.out.println("Invalid height!");
    }
  }

  public double getVolume() {
    return super.getArea() * height;
  }

  @Override
  public String toString() {
    return super.toString() + "[height=" + height + "]";
  }
}

// class StudentID {
//   private ArrayList<Circle> list_shapes = new ArrayList<>();

//   public StudentID(StudentID obj) {
//     ArrayList<Circle> list_shapes = new ArrayList<>();
//     for (Circle x : obj.list_shapes) {
//       list_shapes.add(x);
//     }
//   }

//   public void show() {
//     for (Circle x : list_shapes) {
//       System.out.println(x.toString());
//       System.out.println(x.getArea());
//       if (x instanceof Cylinder) {
//         System.out.println(((Cylinder) x).getVolume());
//       }
//     }
//   }

//   public void sort() {
//     Collections.sort(list_shapes, (shape1, shape2) -> {
//       return shape1.getColor().compareTo(shape2.getColor());
//     });
//   }

//   public void saveToFile() {
//     File myFile = new File("StudentID.dat");
//     try (FileWriter myWriter = new FileWriter(myFile)) {
//       myWriter.write(toString());
//     } catch (IOException e) {
//       System.out.println("An error occurred.");
//     }
//   }

//   // public void readFromFile(){
//   // try {
//   // File myObj = new File("filename.txt");
//   // Scanner myReader = new Scanner(myObj);
//   // while (myReader.hasNextLine()) {
//   // String data = myReader.nextLine();
//   // System.out.println(data);
//   // }
//   // myReader.close();
//   // } catch (FileNotFoundException e) {
//   // System.out.println("An error occurred.");
//   // e.printStackTrace();
//   // }
//   // }
// }