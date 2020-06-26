package LeetcodeProblems;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 *
 * <p>
 * Example:
 *
 * Input: 4
 * Output: 2
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * </p>
 */

class Leetcode69 {

  public int mySqrt(int x) {
    int left = 1;
    int right = x;
    int ans = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;  // avoid MAX_INTEGER overflow
      if (mid == x / mid) {
        ans = mid;
        break;
      } else if (mid < x / mid) {
        ans = mid;  // because abandon the decimal part, ans must come here.
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
