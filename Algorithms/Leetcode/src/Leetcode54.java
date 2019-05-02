import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * <p>
 * Example:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * </p>
 */

class Leetcode54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix.length == 0) {
      return ans;
    }

    int rowStart = 0;
    int rowEnd = matrix[0].length - 1; // how many cols
    int colStart = 0;
    int colEnd = matrix.length - 1; // how many rows


    while (ans.size() < matrix.length * matrix[0].length) {
      // go right
      for (int i = rowStart; i <= rowEnd; i++) {
        ans.add(matrix[colStart][i]);
      }
      colStart++; // the upper right element should not be included in go down again!

      if (ans.size() == matrix.length * matrix[0].length) {
        break;
      }
      // go down
      for (int i = colStart; i <= colEnd; i++) {
        ans.add(matrix[i][rowEnd]);
      }
      rowEnd--; // the lower right element should not be included in go left again!

      if (ans.size() == matrix.length * matrix[0].length) {
        break;
      }
      // go left
      for (int i = rowEnd; i >= rowStart; i--) {
        ans.add(matrix[colEnd][i]);
      }
      colEnd--; // the lower left element should not be included in go up again!

      if (ans.size() == matrix.length * matrix[0].length) {
        break;
      }
      // go up
      for (int i = colEnd; i >= colStart; i--) {
        ans.add(matrix[i][rowStart]);
      }
      rowStart++; // the upper left element should not be included in the next go right again!
    }
    return ans;
  }
}
