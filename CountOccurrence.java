// assignment 5 22.9

import java.util.*;
import java.io.*;

public class CountOccurrence {
  public static void main(String[] args) throws Exception {
    // Set text in a file
    File file = new File(args[0]);
    Scanner input = new Scanner(file);
    // Create a TreeMap to hold words as key and count as value
    TreeMap<String, Integer> map = new TreeMap<>();

    while (input.hasNext()) {
      String[] words = input.nextLine().split("[ \n\t,;.:?'\"]");
      for (String word : words) {
        String key = word.toLowerCase();
        if (key.length() > 0 && !Character.isDigit(key.charAt(0))) {
          if (map.get(key) == null) {
            map.put(key, 1);
          } else {
            map.put(key, map.get(key) + 1);
          }
        }
      }
    }

    // Get all entries into a list
    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
    Collections.sort(entryList, (a, b) -> a.getValue().compareTo(b.getValue()));

    // Get key and value from each entry
    for (Map.Entry<String, Integer> entry: entryList) {
      System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
  }
}
