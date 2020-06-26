package LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * <p>
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * </p>
 */

class Leetcode202 {

  public boolean isHappy(int n) {
    Set<Integer> visited = new HashSet<>();
    return helper(n, visited);
  }

  private boolean helper(int n, Set<Integer> visited) {
    if (visited.contains(n)) {
      return false;
    }
    visited.add(n);
    String nToString = Integer.toString(n);
    int newInt = 0;

    for (int i = 0; i < nToString.length(); i++) {
      newInt += (nToString.charAt(i) - '0') * (nToString.charAt(i) - '0');
    }

    if (newInt == 1) {
      return true;
    } else {
      return helper(newInt, visited);
    }
  }
}
