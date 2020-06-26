package LeetcodeProblems;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's
 * and return its area.
 *
 * <p>
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * </p>
 */

class Leetcode221 {

  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    // dp[i][j] represents the side length of square which matrix[i][j] is the lower-right corner
    // of square.
    int[][] dp = new int[row + 1][col + 1];
    // ans tracks the largest side length.
    int ans = 0;
    // dp statements means the side length of square depends on the left, right, upper-right side
    // length. To make a square, if this one is '1', then the min of these three sides + 1 will be
    // the square length; if this one is '0', it cannot be part of square, thus dp is 0.
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          ans = Math.max(ans, dp[i][j]);
        }
      }
    }
    return ans * ans;
  }
}
