// assignment 1 5.30

public class TwinPrime {
  public static void main(String[] args) {
    boolean[] isPrime = new boolean[1001];
    for (int i = 2; i < isPrime.length; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
        for (int j = i + i; j < isPrime.length; j += i) {
          isPrime[j] = false;
        }
      }
    }

    for (int i = 4; i < isPrime.length; i++) {
      if (isPrime[i - 2] && isPrime[i]) {
        System.out.println("(" + (i - 2) + ", " + i + ")");
      }
    }
  }
}
