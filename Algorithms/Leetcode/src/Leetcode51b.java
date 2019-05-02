import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A time and space complexity better solution. Giving up HashSet.
 */

class Leetcode51b {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    // 3 boolean arrays track the col and two diagonals
    boolean[] col = new boolean[n];
    boolean[] diag1 = new boolean[n * n];
    boolean[] diag2 = new boolean[n * n];
    dfs(n, temp, ans, col, diag1, diag2, 0);
    return ans;
  }

  private void dfs(int n, List<String> pa, List<List<String>> ans, boolean[] column,
      boolean[] diag1, boolean[] diag2, int rowIdx) {
    if (pa.size() > n) {
      return;
    } else if (pa.size() == n) {
      ans.add(new ArrayList<>(pa));
    } else {
      for (int col = 0; col < n; col++) {
        // constraints, the diag2 is not [rowIdx - col] because it is a minus operation(can < 0).
        // just add (n - 1) to make it non-negative(largest possible negative num is n - 1).
        if (column[col] || diag1[rowIdx + col] || diag2[rowIdx - col + n - 1]) {
          continue;
        }
        // fill this row
        char[] charArray = new char[n];
        Arrays.fill(charArray, '.');
        charArray[col] = 'Q';
        String str = new String(charArray);
        // make choice
        pa.add(str);
        column[col] = true;
        diag1[rowIdx + col] = true;
        diag2[rowIdx - col + n - 1] = true;
        // to next row
        dfs(n, pa, ans, column, diag1, diag2, rowIdx + 1);
        // reset to previous status for next loop, if you reach here, it means
        // Q in this row this col has fails all possibilities.
        pa.remove(pa.size() - 1);
        column[col] = false;
        diag1[rowIdx + col] = false;
        diag2[rowIdx - col + n - 1] = false;
      }
    }
  }
}
