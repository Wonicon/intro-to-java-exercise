// assignment 1 5.22
import java.util.Scanner;

public class ApproximateSquareRoot {
  public static double sqrt(double num) {
    double nextGuess = 1.0, lastGuess = 1.0;
    do {
      lastGuess = nextGuess;
      nextGuess = (lastGuess + (num / lastGuess)) / 2;
    } while (Math.abs(nextGuess - lastGuess) > 0.0001);
    return nextGuess;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input a real number: ");
    double num = input.nextDouble();
    System.out.println("The square root of " + num + " is " + sqrt(num));
  }
}
