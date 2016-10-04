// assignment 3 9.31

import java.util.Scanner;

public class Hangman {
  private static String[] words = {
      "hello", "aloha", "java", "hangman", "private"
  };

  private static class Word {
    private String word;

    /**
     * True if the char of the corresponding index is validated.
     */
    private boolean[] validated;

    private int validCount;

    Word(String word) {
      this.word = word;
      validated = new boolean[this.word.length()];
      validCount = 0;
      for (int i = 0; i < validated.length; i++) {
        validated[i] = false;
      }
    }

    /**
     * @param ch The character used for validation.
     * @return True if the char is in the word and unvalidated.
     */
    public boolean validate(char ch) {
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == ch && !validated[i]) {
          validated[i] = true;
          validCount++;
          return true;
        }
      }
      return false;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        if (validated[i]) {
          sb.append(word.charAt(i));
        } else {
          sb.append('*');
        }
      }
      return sb.toString();
    }

    /**
     * @return True if all chars are validated.
     */
    public boolean valid() {
      return validCount == validated.length;
    }
  }

  public static void hangman(String word) {
    Word w = new Word(word);
    Scanner input = new Scanner(System.in);
    int missCount = 0;
    while (!w.valid()) {
      System.out.print("(Guess) Enter a letter in word " + w + " > ");
      char ch = input.next().charAt(0);
      if (!w.validate(ch)) {
        System.out.println("\t" + ch + " is already in the word");
        missCount++;
      }
    }

    System.out.print("The word is " + word + ". You missed " + missCount + " time(s)");
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    boolean another;
    do {
      String word = words[(int)(Math.random() * words.length)];
      hangman(word);
      System.out.print("\nDo you want to guess for another word? Enter y or n> ");
      another = input.next().charAt(0) == 'y';
    } while (another);
  }
}
