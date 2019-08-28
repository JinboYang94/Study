import java.nio.file.Watchable;
import java.util.HashSet;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 *
 * <p>
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 * </p>
 */

class Leetcode85 {

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int[] heights = new int[col];
    int maxArea = 0;

    // transform problem into leetcode 84, analyse each row one by one as 84, compute heights here
    // and parse as parameters in leetcode 84 to get maxArea row by row.
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '1') {
          heights[j] += 1;
        } else {
          heights[j] = 0;
        }
      }
      maxArea = Math.max(maxArea, leetcode84(heights));
    }
    return maxArea;
  }

  private int leetcode84(int[] heights) {
    HashSet<Integer> allHeights = new HashSet<>();
    for (int i = 0; i < heights.length; i++) {
      allHeights.add(heights[i]);
    }

    int maxArea = 0;
    for (int h : allHeights) {
      int width = 0;
      int maxWidth = 1;
      for (int i = 0; i < heights.length; i++) {
        if (heights[i] >= h) {
          width++;
        } else {
          maxWidth = Math.max(maxWidth, width);
          width = 0;
        }
      }
      maxWidth = Math.max(maxWidth, width);
      maxArea = Math.max(maxArea, h * maxWidth);
    }
    return maxArea;
  }
}
