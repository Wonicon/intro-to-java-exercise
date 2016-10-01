// assignment 2 8.13

import java.security.KeyStore;
import java.util.Scanner;

public class Location {
  public final int row;

  public final int column;

  public final double maxValue;

  public Location(int row, int column, double maxValue) {
    this.row = row;
    this.column = column;
    this.maxValue = maxValue;
  }

  public static Location locateLargest(double[][] a) {
    int row = 0;
    int column = 0;
    double maxValue = a[row][column];

    for (int i = a.length - 1; i >= 0; i--) {
      for (int j = a[i].length - 1; j >= 0; j--) {
        if (maxValue < a[i][j]) {
          row = i;
          column = j;
          maxValue = a[i][j];
        }
      }
    }

    return new Location(row, column, maxValue);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of rows and columns of the array: ");
    int rowNum = scanner.nextInt();
    int colNum = scanner.nextInt();
    System.out.println("Enter the array:");
    double[][] a = new double[rowNum][colNum];
    for (int i = 0; i < rowNum; i++) {
      for (int j = 0; j < colNum; j++) {
        a[i][j] = scanner.nextDouble();
      }
    }
    Location loc = Location.locateLargest(a);
    System.out.println("The location of the largest element is " + loc.maxValue + " at (" + loc.row + ", " + loc.column + ")");
  }
}
