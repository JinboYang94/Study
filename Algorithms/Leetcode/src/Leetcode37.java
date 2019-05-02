import java.util.HashSet;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 * <p>
 * Note:
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 * </p>
 */

class Leetcode37 {

  public void solveSudoku(char[][] board) {
    dfs(board);
  }

  private boolean dfs(char[][] bd) {
    for (int i = 0; i < bd.length; i++) {
      for (int j = 0; j < bd[0].length; j++) {
        if (bd[i][j] == '.') {
          for (char ch = '1'; ch <= '9'; ch++) {
            if (validSukudo(bd, i, j, ch)) {
              bd[i][j] = ch;
              if (dfs(bd)) {
                return true;
              } else {
                bd[i][j] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean validSukudo(char[][] bd, int row, int col, char ch) {
    for (int i = 0; i < bd.length; i++) {
      if (bd[i][col] == ch) {
        return false;
      }
      if (bd[row][i] == ch) {
        return false;
      }
      if (bd[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
        return false;
      }
    }

    return true;
  }
}
