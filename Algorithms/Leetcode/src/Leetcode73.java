/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * </p>
 */

class Leetcode73 {

  public void setZeroes(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;

    boolean[] zeroesInRow = new boolean[row];
    boolean[] zeroesInCol = new boolean[col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == 0) {
          zeroesInRow[i] = true;
          zeroesInCol[j] = true;
        }
      }
    }

    for (int i = 0; i < row; i++) {
      if (zeroesInRow[i]) {
        for (int j = 0; j < col; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < col; i++) {
      if (zeroesInCol[i]) {
        for (int j = 0; j < row; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }
}
