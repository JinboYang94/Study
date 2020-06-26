package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that
 * no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * <p>
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * </p>
 * P.S: Queen can move any steps in row, column or diagonal!
 */

class Leetcode51 {

  private Set<Integer> invalidCol = new HashSet<>();
  private Set<Integer> diag1 = new HashSet<>();
  private Set<Integer> diag2 = new HashSet<>();

  public List<List<String>> solveNQueens(int n) {
    List<String> temp = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    backtrack(n, temp, ans,0);
    return ans;
  }

  private void backtrack(int n, List<String> pa, List<List<String>> ans, int rowIndex) {
    if (pa.size() > n) {
      return;
    } else if (pa.size() == n) {
      ans.add(new ArrayList<>(pa));
    } else {
      for (int col = 0; col < n; col++) {
        // constrains on col and diagonals
        if (!validCheck(rowIndex, col)) {
          continue;
        }
        // fill this row
        char[] charArray = new char[n];
        Arrays.fill(charArray, '.');
        charArray[col] = 'Q';
        String str = new String(charArray);
        // add to answer(make choice)
        pa.add(str);
        invalidCol.add(col);
        diag1.add(rowIndex + col);
        diag2.add(rowIndex - col);
        // continue to next row
        backtrack(n, pa, ans, rowIndex + 1);
        // reset to previous status for next choice
        pa.remove(pa.size() - 1);
        invalidCol.remove(col);
        diag1.remove(rowIndex + col);
        diag2.remove(rowIndex - col);

      }
    }
  }

  // i is row, j is col. The diagonal and col are checked.
  // i + j valid second diagonal(/), because for elements on this diagonal, their
  // (row + col) are the same.
  // i - j valid the first diagonal(\), because their (row - col) are the same.
  private boolean validCheck(int i, int j) {
    if (invalidCol.contains(j) || diag1.contains(i + j) || diag2.contains(i - j)) {
      return false;
    }
    return true;
  }
}
