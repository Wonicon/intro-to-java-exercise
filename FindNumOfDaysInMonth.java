// assignment 1 3.11
import java.time.YearMonth;
import java.util.Scanner;

public class FindNumOfDaysInMonth {
  // see listing 3.8
  private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the month: ");
    int month = input.nextInt();

    System.out.print("Enter the year: ");
    int year = input.nextInt();

    final int febShort = 28, febLong = 29;
    final int commShort = 30, commLong = 31;

    int days;
    String monthLiteral;

    switch (month) {
      case 1:  monthLiteral = "January";   days = commShort; break;
      case 2:  monthLiteral = "February";  days = isLeapYear(year) ? febLong : febShort; break;
      case 3:  monthLiteral = "March";     days = commShort; break;
      case 4:  monthLiteral = "April";     days = commShort; break;
      case 5:  monthLiteral = "May";       days = commShort; break;
      case 6:  monthLiteral = "June";      days = commShort; break;
      case 7:  monthLiteral = "July";      days = commShort; break;
      case 8:  monthLiteral = "August";    days = commShort; break;
      case 9:  monthLiteral = "September"; days = commShort; break;
      case 10: monthLiteral = "October";   days = commShort; break;
      case 11: monthLiteral = "November";  days = commShort; break;
      case 12: monthLiteral = "December";  days = commShort; break;
      default: System.out.println("Invalid month number " + month); return;
    }

    System.out.println(monthLiteral + " " + year + " has " + days + " days.");
  }

  // http://stackoverflow.com/a/39458049/5164297
  // http://stackoverflow.com/a/7395759/5164297
  // http://stackoverflow.com/a/8940484/5164297 Best Practice
  public static void cleverSolution() {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the month: ");
    int month = input.nextInt();

    System.out.print("Enter the year: ");
    int year = input.nextInt();

    YearMonth yearMonth = YearMonth.of(year, month);
    System.out.println(yearMonth.getMonth() + " " + year + " has " + yearMonth.lengthOfMonth() + " days.");
  }
}
