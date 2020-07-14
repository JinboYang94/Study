package LeetcodeProblems;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * <p>
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 * </p>
 */

public class Leetcode231 {

  public boolean isPowerOfTwo(int n) {
    // use recursive
    return n == 1 || (n > 0 && n % 2 == 0 && isPowerOfTwo(n / 2));
  }
}
