package LeetcodeProblems;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * <p>
 * Example:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Input: m = 7, n = 3
 * Output: 28
 * </p>
 */

class Leetcode62 {

  public int uniquePaths(int m, int n) {
    // This dp[][] stores the possibilities to reach this position with right and down
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) { // these two lines can only be reached by always go right or go down
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[m - 1][n - 1];
  }

}
