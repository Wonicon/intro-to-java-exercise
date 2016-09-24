// assignment 1 5.16
public class NumberOfDaysInYear {
  private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }

  private static int[] monthDays = {
      31, 28, 31, 30, 31, 30,
      31, 31, 30, 31, 30, 31
  };

  public static int numberOfDaysInAYear(int year) {
    int sum = 0;
    for (int days : monthDays) {
      sum += days;
    }
    return isLeapYear(year) ? sum + 1 : sum;
  }

  public static void main(String[] args) {
    for (int year = 2000; year <= 2010; year++) {
      System.out.println("The number of days in " + year + " is " + numberOfDaysInAYear(year));
    }
  }
}
