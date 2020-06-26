package BloombergTest;

import OA.BloombergLP.Bloomberg4;

/**
 * For Bloomberg4 testing.
 */

class Bloomberg4Test {

  public static void main(String[] args) {
    String s1 = "3[a]2[bc]";
    String s2 = "3[a2[c]]";
    String s3 = "2[abc]3[cd]ef";

    Bloomberg4 constructor = new Bloomberg4();
    System.out.println(constructor.decodeString(s1));
    System.out.println(constructor.decodeString(s2));
    System.out.println(constructor.decodeString(s3));
  }
}
