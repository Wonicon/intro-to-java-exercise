// assignment 1 6.18
import java.util.Scanner;

public class BubbleSort {
  public static void bubbleSort(double[] array) {
    for (int i = array.length; i > 1; i--) {
      for (int j = 1; j < i; j++) {
        if (array[j - 1] > array[j]) {
          // swap
          double temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.print("Enter ten numbers: ");
    Scanner scanner = new Scanner(System.in);
    double[] array = new double[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = scanner.nextDouble();
    }

    bubbleSort(array);
    System.out.print("The sorted array is");
    for (double n : array) {
      System.out.print(" ");
      System.out.print(n);
    }
  }
}
