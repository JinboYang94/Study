package BloombergTest;

import OA.BloombergLP.Bloomberg3;

/**
 * For Bloomberg3 testing.
 */

class Bloomberg3Test {

  public static void main(String[] args) {
    String s1 = "aaabbbc";
    String s2 = "aabbbacd";
    String s3 = "aabbccddeeedcba";
    String s4 = "aaabbbacd";
    String s5 = "aaaabbbacd";

    Bloomberg3 constructor = new Bloomberg3();
    System.out.println(constructor.removeDuplicate(s1));
    System.out.println(constructor.removeDuplicate(s2));
    System.out.println(constructor.removeDuplicate(s3));
    System.out.println(constructor.removeDuplicate(s4));
    System.out.println(constructor.removeDuplicate(s5));
  }
}
