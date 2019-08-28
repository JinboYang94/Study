/**
 * Binary search, with less time complexity.
 */

class Leetcode74b {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int row = matrix.length;
    int col = matrix[0].length;

    int left = 0;
    int right = row * col - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      int midVal = matrix[mid / col][mid % col];
      if (midVal == target) {
        return true;
      } else if (midVal < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
