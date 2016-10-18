// assignment 4 14.20

public class Rational extends Number implements Comparable {
  // Date fields for numerator and denominator
  private long numerator = 0;
  private long denominator = 1;

  /** Construct a rational with default properties */
  public Rational() {
    this(0, 1);
  }

  /** Construct a rational with specified numerator and denominator */
  public Rational(long numerator, long denominator) {
    set(numerator, denominator);
  }

  /** Set the rational with specified numerator and denominator */
  private void set(long numerator, long denominator) {
    long gcd = gcd(numerator, denominator);
    this.numerator = numerator / gcd;
    this.denominator = denominator / gcd;
  }

  /** Construct a rational from a string in the form n/d */
  public Rational(String s) {
    String[] nd = s.split("/");
    this.set(Long.parseLong(nd[0]), Long.parseLong(nd[1]));
  }

  /** Find GCD of two numbers */
  private static long gcd(long n, long d) {
    long n1 = Math.abs(n);
    long n2 = Math.abs(d);
    int gcd = 1;
    for (int k = 1; k <= n1 && k <= n2; k++) {
      if (n1 % k == 0 && n2 % k == 0)
        gcd = k;
    }

    return gcd;
  }

  /** Return numerator */
  public long getNumerator() {
    return numerator;
  }

  /** Return denominator */
  public long getDenominator() {
    return denominator;
  }

  /** Add a rational number to this rational */
  public Rational add(Rational secondRational) {
    long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
    long d = denominator * secondRational.getDenominator();
    return new Rational(n, d);
  }

  /** Subtract a rational number from this rational */
  public Rational subtract(Rational secondRational) {
    long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator();
    long d = denominator * secondRational.getDenominator();
    return  new Rational(n, d);
  }

  /** Multiply a rational number to this rational */
  public Rational multiply(Rational secondRational) {
    long n = numerator * secondRational.getNumerator();
    long d = denominator * secondRational.getDenominator();
    return new Rational(n, d);
  }

  /** Divide a rational number from this rational */
  public Rational divide(Rational secondRational) {
    long n = numerator * secondRational.getDenominator();
    long d = denominator * secondRational.getNumerator();
    return new Rational(n, d);
  }

  /** Override the toString() method */
  @Override
  public String toString() {
    if (denominator == 1 || numerator == 0)
      return Long.toString(numerator);
    else
      return numerator + "/" + denominator;
  }

  /** Override the equals method in the Object class */
  @Override
  public boolean equals(Object parm1) {
    assert(this.getClass() == parm1.getClass());
    return this.subtract((Rational)parm1).getNumerator() == 0;
  }

  /** Implement the abstract intValue method in java.lang.Number */
  @Override
  public int intValue() {
    return (int)doubleValue();
  }

  /** Implement the abstract longValue method in java.lang.Number */
  @Override
  public long longValue() {
    return (long)doubleValue();
  }

  /** Implement the abstract floatValue method in java.lang.Number */
  @Override
  public float floatValue() {
    return (float)doubleValue();
  }

  /** Implement the abstract floatValue method in java.lang.Number */
  @Override
  public double doubleValue() {
    return numerator * 1.0 / denominator;
  }

  /** Implement the compareTo method in java.lang.Comparable */
  @Override
  public int compareTo(Object o) {
    long n = this.subtract((Rational)o).getNumerator();
    if (n > 0) return 1;
    else if (n < 0) return -1;
    else return 0;
  }

  public static void main(String[] args) {
    String op = args[1];
    Rational opeLeft = new Rational(args[0]);
    Rational opeRight = new Rational(args[2]);
    Rational result = null;
    switch (op.charAt(0)) {
      case '+': result = opeLeft.add(opeRight); break;
      case '-': result = opeLeft.subtract(opeRight); break;
      case '*': result = opeLeft.multiply(opeRight); break;
      case '/': result = opeLeft.divide(opeRight); break;
    }
    System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
  }
}
