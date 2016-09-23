// assignment 1 4.16
import java.util.Scanner;

public class FindFactors {
  public static void main(String[] args) {
    System.out.print("Input an integer: ");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    String delimiter = "";

    int factor = 2;
    while (num > 0 && factor <= num) {
      if (num % factor == 0) {
        System.out.print(delimiter + factor);
        delimiter = ", ";
        num /= factor;
      } else {
        factor++;
      }
    }
  }
}
