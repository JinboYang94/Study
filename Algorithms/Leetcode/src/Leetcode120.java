import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */

class Leetcode120 {

  public int minimumTotal(List<List<Integer>> triangle) {
    int row = triangle.size();
    int col = triangle.get(row - 1).size();
    int[][] dp = new int[row][col];
    dp[0][0] = triangle.get(0).get(0);

    for (int i = 1; i < row; i++) {
      List<Integer> thisRow = triangle.get(i);
      for (int j = 0; j < thisRow.size(); j++) {
        if (j == 0) {  // left bound only one case possible
          dp[i][j] = dp[i - 1][j] + thisRow.get(j);
        } else if (j == thisRow.size() - 1) { // same to right bound
          dp[i][j] = dp[i - 1][j - 1] + thisRow.get(j);
        } else {  // elements in the middle
          dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + thisRow.get(j);
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int val : dp[row - 1]) {
      if (val < min) {
        min = val;
      }
    }
    return min;
  }
}
