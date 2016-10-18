// assignment 4 14.9

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Largest {
  public static Object max(Comparable[] a) {
    Comparable m = a[0];
    for (Comparable i : a) {
      if (i.compareTo(m) > 0) {
        m = i;
      }
    }
    return m;
  }

  public static void main(String[] args) {
    String[] strings = new String[] {
      "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
      "January", "February", "March", "April", "May"
    };
    Integer[] integers = new Integer[]{
        56, 33, 78, 33, 22,
        23, 4, 0, -1, 4
    };
    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  // Found from http://stackoverflow.com/a/43807
    String[] dateStrings = new String[] {
        "1999/12/03", "1970/01/01", "2020/03/06", "2014/11/11", "2016/11/08",
        "2001/09/11", "2016/11/18", "1111/11/11", "1933/07/07", "1400/10/22"
    };
    Date[] dates = new Date[10];
    try {
      for (int i = 0; i < dates.length; i++) {
        dates[i] = formatter.parse(dateStrings[i]);
      }
    } catch (ParseException e) {}
    System.out.println("Max string is " + max(strings));
    System.out.println("Max integer is " + max(integers));
    System.out.println("Max date is " + max(dates));
  }
}
