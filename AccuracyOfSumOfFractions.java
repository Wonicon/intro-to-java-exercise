public class AccuracyOfSumOfFractions {
  private static double sumFromLeft(int n) {
    double sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
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

  public static void main(String[] args) {
    int n = 50000;
    System.out.println("The result of computing from left to right with n = " + n + " is " + sumFromLeft(n) + ",");
    System.out.println("The result of computing from right to left with n = " + n + " is " + sumFromRight(n) + ".");
  }
}
