package ChallengeDec;

public class SpiralMatrixII {

  public int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];

    int count = 1;
    int rowStart = 0;
    int rowEnd = n - 1;
    int colStart = 0;
    int colEnd = n - 1;

    while (count <= n * n) {
      // right
      for (int i = colStart; i <= colEnd; i++) {
        ret[rowStart][i] = count++;
      }
      rowStart++;
      // stop, is a optimise
      if (count - 1 == n * n) {
        break;
      }
      // down
      for (int i = rowStart; i <= rowEnd; i++) {
        ret[i][colEnd] = count++;
      }
      colEnd--;
      // left
      for (int i = colEnd; i >= colStart; i--) {
        ret[rowEnd][i] = count++;
      }
      rowEnd--;
      // stop, is a optimise
      if (count - 1 == n * n) {
        break;
      }
      // up
      for (int i = rowEnd; i >= rowStart; i--) {
        ret[i][colStart] = count++;
      }
      colStart++;
    }
    return ret;
  }
}
