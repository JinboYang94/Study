package GoogleTest;

import OA.GoogleOA.Google4;
import java.util.Arrays;

/**
 * For Google4 testing.
 */

class Google4Test {

  public static void main(String[] args) {
    String s1 = "abcd,aabc,bd";
    String s2 = "aaa,aa";

    Google4 constructor = new Google4();
    System.out.println(Arrays.toString(constructor.compareStrings(s1, s2)));
  }
}
