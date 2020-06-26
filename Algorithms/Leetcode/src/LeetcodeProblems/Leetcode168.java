package LeetcodeProblems;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * <p>
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 * </p>
 */

class Leetcode168 {

  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      // change 1-26 A-Z to 0-25 A-Z
      sb.append((char) ('A' + (n - 1) % 26));
      n = (n - 1) / 26;
    }
    return sb.reverse().toString();
  }
}
