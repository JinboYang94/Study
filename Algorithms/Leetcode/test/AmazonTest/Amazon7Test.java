package AmazonTest;

import OA.AmazonOA2.Amazon7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For testing OAProblems.AmazonOA2.Amazon7.
 */

class Amazon7Test {

  public static void main(String[] args) {
    List<String> logFile1 = new ArrayList<>(Arrays.asList("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"));
    int size = 5;

    Amazon7 constructor = new Amazon7();
    System.out.println(constructor.sortLogFiles(size, logFile1));
  }
}
