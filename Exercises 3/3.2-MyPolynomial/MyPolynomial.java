public class MyPolynomial {
  private double[] coeffs;

  public MyPolynomial(double... coefficients) {
    coeffs = new double[coefficients.length];
    for (int i = 0; i < coefficients.length; i++) {
      coeffs[i] = coefficients[i];
    }
  }

  public int getDegree() {
    return coeffs.length - 1;
  }

  @Override
  public String toString() {
    StringBuilder polynomialString = new StringBuilder();
    int degree = getDegree();

    for (int i = 0; i <= degree; i++) {
      double coefficient = coeffs[i];

      if (coefficient != 0.0) {
        if (i < degree) {
          polynomialString.append(coefficient).append("x^").append(degree - i).append(" + ");
        } else {
          polynomialString.append(coefficient);
        }
      }
    }

    return polynomialString.toString();
  }

  public double evaluate(double x) {
    double result = 0.0;
    int degree = getDegree();

    for (int i = degree; i >= 0; i--) {
      result += coeffs[i] * Math.pow(x, degree - i);
    }

    return result;
  }

  public MyPolynomial add(MyPolynomial another) {
    int thisDegree = getDegree();
    int anotherDegree = another.getDegree();
    int maxDegree = Math.max(thisDegree, anotherDegree);

    double[] resultCoeffs = new double[maxDegree + 1];

    for (int i = 0; i <= maxDegree; i++) {
      double thisCoefficient = (i <= thisDegree) ? coeffs[i] : 0.0;
      double anotherCoefficient = (i <= anotherDegree) ? another.coeffs[i] : 0.0;

      resultCoeffs[i] = thisCoefficient + anotherCoefficient;
    }

    return new MyPolynomial(resultCoeffs);
  }

  public MyPolynomial multiply(MyPolynomial another) {
    int thisDegree = getDegree();
    int anotherDegree = another.getDegree();
    int resultDegree = thisDegree + anotherDegree;

    double[] resultCoeffs = new double[resultDegree + 1];

    for (int i = 0; i <= thisDegree; i++) {
      for (int j = 0; j <= anotherDegree; j++) {
        resultCoeffs[i + j] += coeffs[i] * another.coeffs[j];
      }
    }

    return new MyPolynomial(resultCoeffs);
  }

  public static void main(String[] args) {
    MyPolynomial poly1 = new MyPolynomial(1.0, -2.0, 3.0); // Represents 1.0 - 2.0x + 3.0x^2
    MyPolynomial poly2 = new MyPolynomial(0.0, 4.0, 0.0, -1.0); // Represents 4.0x - x^3

    System.out.println("Polynomial 1: " + poly1);
    System.out.println("Polynomial 2: " + poly2);

    MyPolynomial sum = poly1.add(poly2);
    System.out.println("Sum of Polynomial 1 and Polynomial 2: " + sum);

    MyPolynomial product = poly1.multiply(poly2);
    System.out.println("Product of Polynomial 1 and Polynomial 2: " + product);

    double x = 2.0;
    System.out.println("Polynomial 1 evaluated at x = " + x + ": " + poly1.evaluate(x));
    System.out.println("Polynomial 2 evaluated at x = " + x + ": " + poly2.evaluate(x));
  }
}
