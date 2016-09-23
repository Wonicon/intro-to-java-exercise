// assignment 1 3.5
// based on listing 3.1
import java.util.Scanner;

public class AdditionQuiz {
  public static void main(String[] args) {
    int x = (int)(Math.random() * 10);
    int y = (int)(Math.random() * 10);
    int z = (int)(Math.random() * 10);

    Scanner input = new Scanner(System.in);

    System.out.print("What is " + x + " + " + y + " + " + z + "? ");

    int answer = input.nextInt();

    System.out.println(x + " + " + y + " + " + z + " = " + answer + " is " + (x + y + z == answer));
  }
}
