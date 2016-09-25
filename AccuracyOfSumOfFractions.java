// assignment 1 4.23
public class AccuracyOfSumOfFractions {
  private static double sumFromLeft(int n) {
    double sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    return sum;
  }

  private static double kahanSumFromLeft(int n) {
    double sum = 0;
    double c = 0.0;
    for (int i = 1; i <= n; i++) {
      double y = 1.0 / i - c;
      double t = sum + y;
      c = (t - sum) - y;
      sum = t;
    }
    return sum;
  }

  private static double sumFromRight(int n) {
    double sum = 0;
    for (int i = n; i >= 1; i--) {
      sum += 1.0 / i;
    }
    return sum;
  }

  private static double kahanSumFromRight(int n) {
    double sum = 0;
    double c = 0.0;
    for (int i = n; i >= 1; i--) {
      double y = 1.0 / i - c;
      double t = sum + y;
      c = (t - sum) - y;
      sum = t;
    }
    return sum;
  }

  public static void main(String[] args) {
    int n = 50000;
    System.out.println("The result of computing from left to right with n = " + n
        + " is " + sumFromLeft(n) + ",");
    System.out.println("The result of computing from right to left with n = " + n
        + " is " + sumFromRight(n) + ".");
    System.out.println("The result of computing from left to right with n = " + n
        + " and Kahan algo is " + kahanSumFromLeft(n) + ",");
    System.out.println("The result of computing from left to right with n = " + n
        + " and Kahan algo is " + kahanSumFromRight(n) + ",");
  }
}
