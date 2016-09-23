// assignment 1 2.25
// based on listing 2.19
import java.util.Scanner;

public class ShowCurrentTime {
  public static void main(String[] args) {
    // Obtain the total milliseconds since midnight, Jan 1, 1970
    long totalMilliseconds = System.currentTimeMillis();

    // Obtain the total seconds since midnight, Jan 1, 1970
    long totalSeconds = totalMilliseconds / 1000;

    // Compute the current second in the minute in the hour
    long currentSecond = totalSeconds % 60;

    // Obtain the total minutes
    long totalMinutes = totalSeconds / 60;

    // Compute the current minute in the hour
    long currentMinute = totalMinutes % 60;

    // Obtain the total hours
    long totalHours = totalMinutes / 60;

    // Compute the current hour
    long currentHour = totalHours % 24;

    // Get the timezoneOffset
    System.out.print("Enter the time zone offset to GMT: ");
    Scanner scanner = new Scanner(System.in);
    long timezoneOffset = scanner.nextLong();
    long localHour = currentHour + timezoneOffset;
    if (localHour < 0) {
      localHour += 24;
    }

    // Display results
    System.out.println("The current time is " + localHour + ":"
            + currentMinute + ":" + currentSecond);
  }
}