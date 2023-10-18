class MyComplex {
  private double real;
  private double imag;

  public MyComplex(){
    real = 0.0;
    imag = 0.0;
  }

  public MyComplex(double real, double imag){
    setReal(real);
    setImag(imag);
  }

  public double getReal() {
    return real;
  }

  public void setReal(double real) {
    this.real = real;
  }

  public double getImag() {
    return imag;
  }

  public void setImag(double imag) {
    this.imag = imag;
  }

  public void setValue(double real, double imag) {
    setReal(real);
    setImag(imag);
  }

  public String toString() {
    return real + "+" + imag + "i";
  }

  public boolean isReal() {
    return imag == 0;
  }

  public boolean isImaginary() {
    return real == 0;
  }

  public boolean equals(double real, double imag) {
    return (this.real == real && this.imag == imag);
  }

  public boolean equals(MyComplex other) {
    return (this.real == other.real && this.imag == other.imag);
  }

  public double magnitude() {
    return Math.sqrt(real * real + imag * imag);
  }

  public MyComplex addInto(MyComplex right) {
    this.real += right.real;
    this.imag += right.imag;
    return this;
  }

  public MyComplex addNew(MyComplex right){
    return new MyComplex(this.real + right.real, this.imag + right.imag);
  }

  public static void main(String[] args) {
    MyComplex complex1 = new MyComplex(2.0, 3.0);
    MyComplex complex2 = new MyComplex(1.0, 4.0);

    System.out.println("Complex Number 1: " + complex1);
    System.out.println("Complex Number 2: " + complex2);

    // Test isReal() and isImaginary()
    System.out.println("Complex Number 1 is real: " + complex1.isReal());
    System.out.println("Complex Number 2 is imaginary: " + complex2.isImaginary());

    // Test equals(double real, double imag)
    System.out.println("Complex Number 1 is equal to (2.0, 3.0): " + complex1.equals(2.0, 3.0));

    // Test equals(MyComplex another)
    System.out.println("Complex Number 1 is equal to Complex Number 2: " + complex1.equals(complex2));

    // Test magnitude()
    System.out.println("Magnitude of Complex Number 1: " + complex1.magnitude());
    System.out.println("Magnitude of Complex Number 2: " + complex2.magnitude());

    // Test addInto() and addNew()
    complex1.addInto(complex2);
    System.out.println("After adding Complex Number 2 into Complex Number 1: " + complex1);

    MyComplex newComplex = complex1.addNew(complex2);
    System.out
        .println("Adding Complex Number 2 into Complex Number 1 (resulting in a new complex number): " + newComplex);
  }
}