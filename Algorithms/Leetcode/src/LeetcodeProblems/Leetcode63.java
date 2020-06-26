package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 *
 * <p>
 * Example:
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * </p>
 */

class Leetcode63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int len = obstacleGrid.length;  // how many rows
    int width = obstacleGrid[0].length; // how many columns
    int[][] ans = new int[len][width];
    ans[0][0] = 1;

    // initialize first row with conditions: if not obstacle and previous is viable, set to 1.
    // this guarantees the position after obstacle cannot be reached, otherwise can be reached
    for (int i = 1; i < len; i++) {
      if (obstacleGrid[i][0] == 0 && ans[i - 1][0] == 1) {
        ans[i][0] = 1;
      } else {
        ans[i][0] = 0;
      }
    }
    // initialize first column with conditions: if not obstacle and previous is viable, set to 1.
    // this guarantees the position after obstacle cannot be reached, otherwise can be reached.
    for (int j = 1; j < width; j++) {
      if (obstacleGrid[0][j] == 0 && ans[0][j - 1] == 1) {
        ans[0][j] = 1;
      } else {
        ans[0][j] = 0;
      }
    }
    // With first row and column initialized, the inner matrix are same as 62.
    for (int i = 1; i < len; i++) {
      for (int j = 1; j < width; j++) {
        if (obstacleGrid[i][j] == 1) {
          ans[i][j] = 0;
        } else {
          ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
        }
      }
    }

    return ans[len - 1][width - 1];
  }
}
