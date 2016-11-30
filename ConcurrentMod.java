// assignment 6 29.9

import java.util.*;

public class ConcurrentMod {
  private static Set<String> set;
  private static Iterator<String> it;

  public static void main(String[] args) throws Exception {
    set = new HashSet<>();
    set.add("a");
    set.add("b");
    it = set.iterator();

    Thread writer = new Thread(() -> {
      int i = 0;
      while (true) {
        set.add("hello" + i);
        i++;
        try {
          Thread.sleep(1000);
        } catch (Exception e) {}
      }
    });

    Thread printer = new Thread(() -> {
      while (true) {
        for (String s: set) {
          System.out.println(s);
          try {
            Thread.sleep(1000);
          } catch (Exception e) {}
        }
      }
    });

    writer.start();
    printer.start();
    writer.join();
    printer.join();
  }
}
