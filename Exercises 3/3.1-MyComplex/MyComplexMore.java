class MyComplexMore{
  private double real;
  private double imag;

  public MyComplexMore(){
    real = 0.0;
    imag = 0.0;
  }

  public MyComplexMore(double real, double imag){
    setReal(real);
    setImag(imag);
  }

  public double getReal(){
    return real;
  }
  
  public void setReal(double real){
    this.real = real;
  }

  public double getImag(){
    return imag;
  }

  public void setImag(double imag){
    this.imag = imag;
  }

  public void setValue(double real, double imag){
    setReal(real);
    setImag(imag);
  }

  public String toString(){
    return "(" + real + "+" + imag + "i)";
  }

  public boolean isReal(){
    return imag == 0;
  }

  public boolean isImaginary(){
    return real == 0;
  }

  public boolean equals(double real, double imag){
    return (this.real == real && this.imag == imag);
  }

  public boolean equals(MyComplexMore other){
    return (this.real == other.real && this.imag == other.imag);
  }

  public double magnitude(){
    return Math.sqrt(real*real + imag*imag);
  }

  public double argument(){
    return Math.atan2(imag, real);
  }

  public MyComplexMore add(MyComplexMore right){
    this.real += right.real;
    this.imag += right.imag;
    return this;
  }

  public MyComplexMore addNew(MyComplexMore right){
    return new MyComplexMore(this.real + right.real, this.imag + right.imag);
  }
  
  public MyComplexMore subtract(MyComplexMore right){
    this.real -= right.real;
    this.imag -= right.imag;
    return this;
  }

  public MyComplexMore subtractNew(MyComplexMore right){
    return new MyComplexMore(this.real - right.real, this.imag - right.imag);
  }

  public MyComplexMore multiply(MyComplexMore right){
    this.real = this.real * right.real - this.imag * right.imag;
    this.imag = this.real * right.real + this.imag * right.imag;
    return this;
  }

  public MyComplexMore divide(MyComplexMore right){
    MyComplexMore temp = this.multiply(right.conjugate());
    double divisor = right.real * right.real + right.imag * right.imag;

    this.real = temp.real / divisor;
    this.imag = temp.imag / divisor;
    return this;
  }

  public MyComplexMore conjugate(){
    this.real = -this.real;
    return this;
  }

  public static void main(String[] args) {
    MyComplexMore complex1 = new MyComplexMore(2.0, 3.0);
    MyComplexMore complex2 = new MyComplexMore(1.0, 4.0);

    System.out.println("Complex Number 1: " + complex1);
    System.out.println("Complex Number 2: " + complex2);

    System.out.println("Argument of Complex Number 1 (in radians): " + complex1.argument());

    complex1.add(complex2);
    System.out.println("After adding Complex Number 2 into Complex Number 1: " + complex1);

    complex1.subtract(complex2);
    System.out.println("After subtracting Complex Number 2 from Complex Number 1: " + complex1);

    complex1.multiply(complex2);
    System.out.println("After multiplying Complex Number 2 with Complex Number 1: " + complex1);

    complex1.divide(complex2);
    System.out.println("After dividing Complex Number 1 by Complex Number 2: " + complex1);

    complex1.conjugate();
    System.out.println("Conjugate of Complex Number 1: " + complex1);
}
}