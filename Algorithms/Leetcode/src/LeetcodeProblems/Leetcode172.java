package LeetcodeProblems;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * <p>
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * </p>
 */

class Leetcode172 {

  public int trailingZeroes(int n) {
    int ans = 0;
    while (n > 0) {
      n /= 5;
      ans += n;
    }
    return ans;
  }
}
