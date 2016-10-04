// assignment 3 9.3

import java.util.Scanner;

public class CheckPassword {
  private static final int leastLength = 8;

  private static final int leastDigits = 2;

  public static boolean checkPassword(String password) {
    if (password.length() < leastLength) {
      return false;
    }

    int digitCount = 0;
    for (char ch : password.toCharArray()) {
      if (Character.isDigit(ch)) {
        digitCount++;
      } else if (!Character.isLetter(ch)) {
        return false;
      }
    }

    if (digitCount < leastDigits) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.print("Enter a password: ");
    Scanner scanner = new Scanner(System.in);
    String password = scanner.next();
    if (checkPassword(password)) {
      System.out.println("Valid Password");
    } else {
      System.out.println("Invalid Password");
    }
  }
}
