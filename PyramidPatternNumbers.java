// assignment 1 4.19

public class PyramidPatternNumbers {
  public static void main(String[] args) {
    int width = 5;  // The width for each number, left-padded.
    int level = 8;  // The level of the pyramid.

    String format = "%" + width + "s";
    String pad = String.format(format, "");

    for (int i = 1; i <= level; i++) {
      // Print left pad for each level
      // System.out.printf("%" + width * (level - i) + "s", "") cannot handle the last line.
      for (int j = level - i; j > 0; j--) {
        System.out.print(pad);
      }


      int n = 1;
      for (int j = 1; j < i; j++) {
        System.out.printf(format, n);
        n *= 2;
      }
      System.out.printf(format, n);
      for (int j = 1; j < i; j++) {
        n /= 2;
        System.out.printf(format, n);
      }

      System.out.println();
    }
  }
}
