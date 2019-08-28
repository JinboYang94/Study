/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * <p>
 * Example:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * </p>
 */

class Leetcode74 {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {  // case: [] and [[]]
      return false;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int index = 0;

    for (int i = 0; i < row; i++) {
      if (matrix[i][0] == target) {
        return true;
      } else if (matrix[i][0] < target) {
        index = i;
      } else {
        break;
      }
    }

    for (int i = 0; i < col; i++) {
      if (matrix[index][i] == target) {
        return true;
      }
    }

    return false;
  }
}
