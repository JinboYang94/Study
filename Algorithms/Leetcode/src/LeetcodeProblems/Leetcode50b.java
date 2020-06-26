package LeetcodeProblems;

/**
 * Tag: Try recursive.
 * n even: x(n) = x(n / 2) * x(n / 2)
 * n odd: x(n) = x(n / 2) * x(n / 2) * x
 *
 * <p>
 * Math.pow(x, n) rules:
 * When x == 1, always return 1.0.
 * When x == -1, always return -1.0 for n odd, return 1.0 for n even.
 * When (x !=1 && x != -1) and n == Integer.MIN_VALUE, always return 0.0.
 * // below not considered in code, because in ().
 * When n is large or small enough, always return infinity or 0.0(exceed double range?).
 * </p>
 */

class Leetcode50b {

  public double myPow(double x, int n) {
    double ans;

    if (x == 1) {
      return 1.0;
    }
    if (x == -1) {
      if (n % 2 == 1) {
        return -1.0;
      } else {
        return 1.0;
      }
    }

    if (n == Integer.MIN_VALUE) {
      return 0.0;
    }

    if (n > 0) {
      ans = recursiveCall(x, n);
    } else if (n == 0) {
      return 1.0;
    } else {
      n = -n;
      ans = recursiveCall(x, n);
      ans = 1.0 / ans;
    }

    return ans;
  }

  private double recursiveCall(double x, int n) {
    // recursion breaks, here an example(ignore  .0):
    // n = 2     1            0                                  return 1 here, recursion breaks.
    //    2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = (1 * 1 * 2) * (1 * 1 * 2) = 4
    if (n == 0) {
      return 1.0;
    }

    double rlt = 0.0;
    if (n % 2 == 0) {
      rlt = recursiveCall(x, n / 2);
      return rlt * rlt;
    } else {
      rlt = recursiveCall(x, n / 2);
      return rlt * rlt * x;
    }
  }
}
