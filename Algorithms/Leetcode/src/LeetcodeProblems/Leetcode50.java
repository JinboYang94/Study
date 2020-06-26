package LeetcodeProblems;

/**
 * Implement pow(x, n), which calculates x raised to the power n.
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1].
 *
 * <p>
 * Example:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * </p>
 * Tag: TLE, fail
 */

class Leetcode50 {

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1.0;
    }

    boolean sign;
    if (x == Math.abs(x)) {
      sign = true;
    } else {
      sign = false;
      x = Math.abs(x);
    }

    double ans = x;

    if (n > 0) {
      for (int i = 1; i < n; i++) {
        ans = ans * x;
      }
    } else {
      double temp = x;
      if (n == Integer.MIN_VALUE) {
//        temp = x * x;
        return 0.0;
      }
      n = Math.abs(n);
      for (int i = 1; i < n; i++) {
        temp = temp * x;
      }
      ans = 1.0 / temp;
    }

    if (sign) {
      return ans;
    } else {
      if (n % 2 == 0) {
        return ans;
      } else {
        return - ans;
      }
    }

  }
}
