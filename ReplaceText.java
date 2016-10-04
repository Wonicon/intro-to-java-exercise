// assignment 3 9.20
import java.io.*;
import java.util.*;

public class ReplaceText {
  public static void main(String[] args) throws Exception {
    // Check command-line parameter usage
    if (args.length != 4) {
      System.out.println(
          "Usage: java ReplaceText file oldStr newStr");
      System.exit(0);
    }

    // Check if file exists
    File file = new File(args[0]);
    if (!file.exists()) {
      System.out.println("Source file " + args[0] + " does not exist");
      System.exit(0);
    }

    // Create a Scanner for input and a PrintWriter for output
    Scanner input = new Scanner(file);
    StringBuilder sb = new StringBuilder();
    while (input.hasNext()) {
      String s1 = input.nextLine();
      sb.append(s1.replaceAll(args[2], args[3]));
      sb.append('\n');
    }

    input.close();

    PrintWriter output = new PrintWriter(file);
    output.print(sb.toString());
    output.close();
  }
}