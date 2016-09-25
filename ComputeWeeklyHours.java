// assignment 1 7.4
import java.util.Scanner;

public class ComputeWeeklyHours {
  public static class EmployeeHours {
    private int hours;  // The total work hours in a week.

    private int id;     // The identification, a.k.a 0, 1, 2, ...

    EmployeeHours(int id, int hours) {
      this.id = id;
      this.hours = hours;
    }

    public int getId() { return id; }

    public int getHours() { return hours; }
  }

  public static EmployeeHours[] computeWeeklyHours(int[][] weeklyHours) {
    EmployeeHours[] employeeHours = new EmployeeHours[weeklyHours.length];

    int i = 0;
    for (int[] employeeWeeklyHours : weeklyHours) {
      int hours = 0;
      for (int hour : employeeWeeklyHours) {
        hours += hour;
      }
      employeeHours[i] = new EmployeeHours(i, hours);
      i++;
    }

    return employeeHours;
  }

  public static void bubbleSort(EmployeeHours[] array) {
    for (int i = array.length; i > 1; i--) {
      for (int j = 1; j < i; j++) {
        if (array[j - 1].getHours() < array[j].getHours()) {
          // swap
          EmployeeHours temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of employees: ");
    int n = scanner.nextInt();

    // Print headings
    String s = Integer.toString(n - 1);
    int width = s.length();
    int pad = "EmployeeHours ".length() + width + 1;
    System.out.printf("%" + pad + "s", "");
    System.out.println("Su M T W H F Sa");

    int[][] hoursTable = new int[n][7];

    for (int i = 0; i < n; i++) {
      System.out.print("Employee " + i + "  ");  // 2 space to align
      for (int j = 0; j < 7; j++) {
        hoursTable[i][j] = scanner.nextInt();
      }
    }

    EmployeeHours[] totalHours = computeWeeklyHours(hoursTable);
    bubbleSort(totalHours);
    for (EmployeeHours employeeHours : totalHours) {
      System.out.println("Employee " + employeeHours.getId() + ": " + employeeHours.getHours());
    }
  }
}
