// assignment 6 29.9

import java.util.*;

public class ConcurrentModSync {
  private static Set<String> set;

  public static void main(String[] args) throws Exception {
    set = Collections.synchronizedSet(new HashSet<>());
    set.add("a");
    set.add("b");

    Thread writer = new Thread(() -> {
      int i = 0;
      while (true) {
        synchronized (set) {
          set.add("hello" + i);
        }
        i++;
        try {
          Thread.sleep(1000);
        } catch (Exception e) {}
      }
    });

    Thread printer = new Thread(() -> {
      while (true) {
        synchronized (set) {
          for (String s : set) {
            System.out.println(s);
            try {
              Thread.sleep(1000);
            } catch (Exception e) {
            }
          }
        }
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
        }
      }
    });

    writer.start();
    printer.start();
    writer.join();
    printer.join();
  }
}
