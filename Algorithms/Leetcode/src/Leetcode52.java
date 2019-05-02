import java.util.Arrays;

/**
 * Almost same as 51, but only need to return the number of the solutions.
 */

class Leetcode52 {

  public int totalNQueens(int n) {
    int ans = 0;
    boolean[] col = new boolean[n];
    boolean[] diag1 = new boolean[n * n];
    boolean[] diag2 = new boolean[n * n];
    ans = dfs(n, col, diag1, diag2, ans, 0);
    return ans;
  }

  private int dfs(int n, boolean[] column, boolean[] diag1, boolean[] diag2, int ans, int rowIdx) {
    if (rowIdx > n) {
      return ans;
    } else if (rowIdx == n) {
      ans++;
    } else {
      for (int col = 0; col < n; col++) {
        if (column[col] || diag1[rowIdx + col] || diag2[rowIdx - col + n - 1]) {
          continue;
        }
        // skip add solution operations, and just set the boolean array status
        column[col] = true;
        diag1[rowIdx + col] = true;
        diag2[rowIdx - col + n - 1] = true;
        // to next row
        ans = dfs(n, column, diag1, diag2, ans, rowIdx + 1);
        // reset
        column[col] = false;
        diag1[rowIdx + col] = false;
        diag2[rowIdx - col + n - 1] = false;
      }
    }
    return ans;
  }
}
