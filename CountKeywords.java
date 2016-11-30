// assignment 5 22.3

import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.util.Arrays;

public class CountKeywords {
  private static String filterLiteralsAndComments(Scanner input) {
    final int NORMAL = 0;
    final int ESCAPE = 1;
    final int CHAR = 2;
    final int STRING = 3;
    final int DIV_OR_COMMENT_START = 4;
    final int LINE_COMMENT = 5;
    final int COMMENT = 6;
    final int OUT_COMMENT = 7;

    int state = NORMAL;
    int pre = state;
    StringBuilder sb = new StringBuilder();
    while (input.hasNext()) {
      for (char ch : input.nextLine().toCharArray()) {
        switch (state) {
          case NORMAL:
            if (ch == '\'') {
              state = CHAR;
            } else if (ch == '"') {
              state = STRING;
            } else if (ch == '/') {
              state = DIV_OR_COMMENT_START;
            } else {
              sb.append(ch);
            }
            break;
          case ESCAPE:
            state = pre;
            break;
          case CHAR:
            if (ch == '\'') state = NORMAL;
            else if (ch == '\\') {
              pre = state;
              state = ESCAPE;
            }
            break;
          case STRING:
            if (ch == '"') state = NORMAL;
            else if (ch == '\\') {
              pre = state;
              state = ESCAPE;
            }
            break;
          case DIV_OR_COMMENT_START:
            if (ch == '/') {
              state = LINE_COMMENT;
            } else if (ch == '*') {
              state = COMMENT;
            } else {
              sb.append('/').append(ch);
              state = NORMAL;
            }
            break;
          case COMMENT:
            if (ch == '*') {
              state = OUT_COMMENT;
            }
            break;
          case OUT_COMMENT:
            if (ch == '/') {
              state = NORMAL;
            } else if (ch == '*') {
              state = OUT_COMMENT;
            } else {
              state = COMMENT;
            }
            break;
          case LINE_COMMENT:
            break;
        }
      }
      if (state == LINE_COMMENT) {
        state = NORMAL;
      }
      sb.append('\n');
    }

    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    String[] keywords = new String[] {
        "abstract", "continue", "for", "new",
        "switch", "assert", "default", "goto", "package", "synchronized", "boolean",
        "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte",
        "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient",
        "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
        "long", "strictfp", "volatile", "const", "float", "native", "super", "while", "true", "false", "null"
    };
    Set<String> keywordsSet = new HashSet<>();
    keywordsSet.addAll(Arrays.asList(keywords));

    File javaCode = new File(args[0]);
    Scanner codeStream = new Scanner(javaCode);
    String code = filterLiteralsAndComments(codeStream);
    int count = 0;
    for (String s : code.split("[ \n\t\\[\\]\\{\\}\\(\\)\\.;,=\\?<>:!+/\\*-]")) {
      if (keywordsSet.contains(s)) {
        count++;
      }
    }
    System.out.println(count + " keywords");
  }
}