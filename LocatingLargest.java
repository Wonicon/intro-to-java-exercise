// assignment 1 7.13
import java.util.Scanner;

public class LocatingLargest {
  public static int[] getMaxIndex(double[][] arr) {
    int max_i = 0, max_j = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      for (int j = arr[i].length - 1; j >= 0; j--) {
        if (arr[max_i][max_j] < arr[i][j]) {
          max_i = i;
          max_j = j;
        }
      }
    }
    return new int[] { max_i, max_j };
  }

  public static void main(String[] args) {
    System.out.print("Enter the number of rows and columns of the array: ");
    Scanner scanner = new Scanner(System.in);
    int row = scanner.nextInt();
    int column = scanner.nextInt();
    double[][] arr = new double[row][column];
    System.out.println("Enter the array:");
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        arr[i][j] = scanner.nextDouble();
      }
    }
    int[] max = getMaxIndex(arr);
    System.out.printf("The location of the largest element is at (%d, %d)", max[0], max[1]);
  }
}
