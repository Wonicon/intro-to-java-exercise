// assignment 1 2.6
import java.util.Scanner;
import java.util.InputMismatchException;

public class SumDigits {
  private final static int begin = 0;
  private final static int end = 1000;
  private final static String prompt = "Enter a number between " + begin + " and " + end + ": ";

  private static int sumDigits(int number) {
    int sum = 0;
    while (number != 0) {
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    int number = begin - 1;

    while (true) {
      System.out.print(prompt);
      try {
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
        if (begin <= number && number <= end) {
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input!");
      }
    }

    System.out.println("The sum of the digits is " + sumDigits(number));
  }
}
