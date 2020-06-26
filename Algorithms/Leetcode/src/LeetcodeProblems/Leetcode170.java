package LeetcodeProblems;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * <p>
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 * </p>
 */

class Leetcode170 {

  public int titleToNumber(String s) {
    int ans = 0;
    char[] chs = s.toCharArray();
    for (int i = 0; i < chs.length; i++) {
      ans = chs[i] - 'A' + 1 + 26 * ans;
    }
    return ans;
  }
}
