// assignment 1 6.5
import java.util.Scanner;

public class PrintDistinctNumber {
  public static class DistinctArray {
    private int capacity;
    private int size;
    private int[] data;

    DistinctArray(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.data = new int[capacity];
    }

    boolean include(int elem) {
      for (int i = 0; i < size; i++) {
        if (data[i] == elem) return true;
      }
      return false;
    }

    void add(int elem) {
      if (size < capacity) {
        data[size++] = elem;
      }
    }

    int getCapacity() {
      return capacity;
    }

    void print() {
      for (int i = 0; i < size; i++) {
        System.out.print(" " + data[i]);
      }
    }
  }

  public static void main(String[] args) {
    System.out.print("Enter ten numbers: ");
    DistinctArray distinctArray = new DistinctArray(10);
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < distinctArray.getCapacity(); i++) {
      int elem = scanner.nextInt();
      if (!distinctArray.include(elem)) {
        distinctArray.add(elem);
      }
    }
    System.out.print("The distinct numbers are");
    distinctArray.print();
  }
}
