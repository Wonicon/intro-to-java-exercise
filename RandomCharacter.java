// assignment 1 5.23

public class RandomCharacter {
  public static char getRandomCharacter(char ch1, char ch2) {
    return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
  }

  public static char getRandomLowerCaseLetter() {
    return getRandomCharacter('a', 'z');
  }

  public static char getRandomUpperCaseLetter() {
    return getRandomCharacter('A', 'Z');
  }

  public static char getRandomDigitCharacter() {
    return getRandomCharacter('0', '9');
  }

  public static char getRandomCharacter() {
    return getRandomCharacter('\u0000', '\uFFFF');
  }

  // see http://stackoverflow.com/a/22530536
  private static void iterate(Runnable task) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        task.run();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    iterate(() -> { System.out.print(getRandomUpperCaseLetter()); });
    iterate(() -> { System.out.print(getRandomDigitCharacter()); });
  }
}
