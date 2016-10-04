// assignment 3 9.12

import java.util.Scanner;

public class Anagrams {
  public static void main(String[] args) {
    System.out.print("Enter two strings: ");
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    String s2 = scanner.next();
    if (isAnagram(s1, s2)) {
      System.out.println("anagram");
    } else {
      System.out.println("not anagram");
    }
  }

  public static boolean isAnagram(String s1, String s2) {
    StringBuilder sb = new StringBuilder(s1);
    for (char ch : s2.toCharArray()) {
      int index = sb.toString().indexOf(ch);
      if (index == -1) {
        return false;  // Not found.
      } else {
        sb.deleteCharAt(index);  // Consume the same character.
      }
    }
    return true;
  }

}
