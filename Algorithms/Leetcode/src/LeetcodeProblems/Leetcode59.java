package LeetcodeProblems;

/**
 * Given a positive integer n,
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * <p>
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </p>
 */

class Leetcode59 {

  public int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];

    int rowStart = 0;
    int rowEnd = n - 1;
    int colStart = 0;
    int colEnd = n - 1;
    int count = 1;

    while (count <= n * n) {
      // go right
      for (int i = rowStart; i <= rowEnd; i++) {
        ret[colStart][i] = count;
        count++;
      }
      colStart++;
      if (count - 1 == n * n) {
        break;
      }
      // go down
      for (int i = colStart; i <= colEnd; i++) {
        ret[i][rowEnd] = count;
        count++;
      }
      rowEnd--;
      if (count - 1 == n * n) {
        break;
      }
      // go left
      for (int i = rowEnd; i >= rowStart; i--) {
        ret[colEnd][i] = count;
        count++;
      }
      colEnd--;
      if (count - 1 == n * n) {
        break;
      }
      // go up
      for (int i = colEnd; i >= colStart; i--) {
        ret[i][rowStart] = count;
        count++;
      }
      rowStart++;
    }

    return ret;
  }
}
