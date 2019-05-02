/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Tag: This is recursion.
 */

class Leetcode38 {

  // recursive from the first String "1" to previous String, return the next String of it.
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }

    String prev = countAndSay(n - 1);

    return nextString(prev);
  }

  // recursive from s.charAt(0) until reach the end of the String, that gives the next String
  private String nextString(String s) {
    if (s == null) {
      throw new IllegalArgumentException();
    }

    if (s.length() == 0) {
      return "";
    }

    int numOfRepeat = repeatNum(s);
    return Integer.toString(numOfRepeat) + s.charAt(0) + nextString(s.substring(numOfRepeat));
  }

  // calculate the repeating times of the first char in String s.
  private int repeatNum(String s) {
    int count = 1;
    char temp = s.charAt(0);

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == temp) {
        count++;
      } else {
        break;
      }
    }

    return count;
  }
}
