/**
 * ou are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * <p>
 * Example:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </p>
 */

class Leetcode70 {

  public int climbStairs(int n) {
    int f1 = 1;
    int f2 = 2;
    int ans = 0;

    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    for (int i = 3; i <= n; i++) {
      ans = f1 + f2;  // Fibonacci sequence, f(n) comes from f(n-1) + f(n-2)
      f1 = f2;
      f2 = ans;
    }
    return ans;
  }
}
