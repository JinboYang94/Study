package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * <p>
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * </p>
 */

class Leetcode132 {

  public int minCut(String s) {
    int[] min = new int[s.length()];  // min[i] means 0 ~ i minCut
    boolean[][] palindrome = new boolean[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++) {  //
      min[i] = i;
      for (int j = 0; j <= i; j++) {
        // i - 1 < j + 1 means p[i - 1][j + 1] is overflow
        if (s.charAt(i) == s.charAt(j) && (i - 1 < j + 1 || palindrome[i - 1][j + 1])) {
          palindrome[i][j] = true;
          // ? min[j - 1] means the last cut place, because j <= i, we must come to i == j case,
          // always palindrome, update min[i]. like cdd, when i == 2, j == 1 can enter if condition,
          // so min[j - 1] can get the previous 0 ~ j - 1 minCut.
          min[i] = j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);
        }
      }
    }
    return min[s.length() - 1];
  }
}
