package ChanllengeNov;

class Solution {

  public int[][] flipAndInvertImage(int[][] A) {
    int row = A.length;
    int col = A[0].length;
    // System.out.println(Math.ceil(col / 2.0));
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < Math.ceil(col / 2.0); j++) {
        int temp = A[i][col - j - 1];
        A[i][col - j - 1] = A[i][j];
        A[i][j] = temp;
        A[i][col - j - 1] = invert(A[i][col - j - 1]);
        if (col - j - 1 != j) {
          A[i][j] = invert(A[i][j]);
        }
      }
    }
    return A;
  }

  private int invert(int x) {
    if (x == 0) {
      return 1;
    } else {
      return 0;
    }
  }
}

// Another much cleaner solution, i * 2 < len
class Solution {

  public int[][] flipAndInvertImage(int[][] A) {
    int len = A.length;
    for (int[] row : A) {
      for (int i = 0; i * 2 < len; i++) {
        if (row[i] == row[len - i - 1]) {
          row[i] = row[len - i - 1] ^= 1;
        }
      }
    }
    return A;
  }
}