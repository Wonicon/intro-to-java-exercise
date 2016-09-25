// assignment 1 6.20

public class EightQueens {
  private static int nQueen = 8;

  private static void displayQueens(int[] queens) {
    char bar = '|';

    for (int line = 0; line < nQueen; line++) {
      System.out.print(bar);
      for (int col = 0; col < nQueen; col++) {
        System.out.print(queens[col] == line ? "Q" : " ");
        System.out.print(bar);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static boolean eightQueens(int[] queens, int col) {
    if (col == nQueen) {
      displayQueens(queens);
      return true;
    }

    boolean[] ableToPlace = new boolean[nQueen];
    for (int i = 0; i < ableToPlace.length; i++) {
      ableToPlace[i] = true;
    }

    // horizontal exclusion
    for (int i = 0; i < col; i++) {
      ableToPlace[queens[i]] = false;
    }

    // diagonal exclusion
    for (int i = 0; i < col; i++) {
      int up = queens[i] - (col - i);
      if (0 <= up && up < ableToPlace.length) {
        ableToPlace[up] = false;
      }

      int down = queens[i] + (col - i);
      if (0 <= down && down < ableToPlace.length) {
        ableToPlace[down] = false;
      }
    }

    // try all place-able slots
    for (int i = 0; i < ableToPlace.length; i++) {
      if (ableToPlace[i]) {
        queens[col] = i;
        if (eightQueens(queens, col + 1)) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] queens = new int[nQueen];
    eightQueens(queens, 0);
  }
}
