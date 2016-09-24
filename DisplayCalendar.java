// assignment 1 4.29
import java.util.Scanner;

public class DisplayCalendar {
  private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }

  private static String[] monthName = {
      "January", "February", "March", "April", "May", "June",
      "July",  "August", "September", "October", "November", "December"
  };

  private static int[] monthDays = {
    31, 28, 31, 30, 31, 30,
    31, 31, 30, 31, 30, 31
  };

  private static String[] weekDays = {
    "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
  };

  private static int weekDayPad = 2;

  private static int dayPad = 3;

  private static int dayWidth = 2;

  private static int leftPad = 1;

  private static int rightPad = 1;

  private static class MonthCalendar {
    private int year;

    private int days;

    private String name;

    MonthCalendar(int year, int month) {
      this.year = year;
      this.days = (month == 2 && isLeapYear(year)) ? 29 : monthDays[month - 1];
      this.name = monthName[month - 1];
    }

    public int getDays() { return days; }

    private void printPad(int pad) {
      while (pad > 0) {
        System.out.print(" ");
        pad--;
      }
    }

    private void printMonthHeading() {
      int barLength = leftPad + rightPad + weekDays[0].length() * weekDays.length + weekDayPad * (weekDays.length - 1);
      String heading = name + " " + year;

      printPad((barLength - heading.length()) / 2);  // Make the heading in the center.
      System.out.println(heading);
      for (int i = 0; i < barLength; i++) { System.out.print("\u2500"); }  // Space-less unicode horizontal line
      System.out.println();
    }

    private void printWeekDayHeading() {
      printPad(leftPad);
      for (String weekDay: weekDays) {
        System.out.print(weekDay);
        printPad(weekDayPad);
      }
      System.out.println();
    }

    private void printDays(int firstWeekDay) {
      if (firstWeekDay == weekDays.length) {
        // Sun is the first one!
        firstWeekDay = 0;
      }

      int weekDay = 0;
      int day = 1;

      printPad(leftPad);
      // Print the first line
      for (; weekDay < firstWeekDay; weekDay++) {
        printPad(dayWidth + dayPad);
      }

      while (day <= days) {
        if (weekDay >= weekDays.length) {
          weekDay = 0;
          System.out.println();
          printPad(leftPad);
        }

        System.out.printf("%" + dayWidth + "d", day);
        printPad(dayPad);

        day++;
        weekDay++;
      }

      System.out.println();
    }

    /**
     * Display the calendar for this month
     * @param firstWeekDay The beginning week day number for this month, starting from 1.
     */
    private void display(int firstWeekDay) {
      printMonthHeading();
      printWeekDayHeading();
      printDays(firstWeekDay);
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input the year: ");
    int year = scanner.nextInt();

    System.out.print("Intput the first week day number: ");
    int firstWeekDay = scanner.nextInt();

    for (int i = 0; i < monthName.length; i++) {
      MonthCalendar monthCalendar = new MonthCalendar(year, i + 1);
      monthCalendar.display(firstWeekDay);
      // make firstWeekDay round from 1 to 7.
      firstWeekDay = ((firstWeekDay - 1) + monthCalendar.getDays()) % 7 + 1;
    }
  }
}
