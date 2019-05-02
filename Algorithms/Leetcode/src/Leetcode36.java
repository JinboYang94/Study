import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * <p>
 * Example:
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * </p>
 */

class Leetcode36 {

  public boolean isValidSudoku(char[][] board) {
    HashSet noDuplicate = new HashSet();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (!noDuplicate.add((board[i][j] + "in row" + i))
              || !noDuplicate.add(board[i][j] + "in col" + j)
              || !noDuplicate.add(board[i][j] + "in cube" + "row" + i / 3 + "col" + j / 3)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean isValidSudoku2(char[][] board) {
    //row
    for (int i = 0; i < 9; i++) {
      HashSet validRow = new HashSet();
      HashSet validCol = new HashSet();
      HashSet validCube = new HashSet();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !validRow.add(board[i][j])) { // notice [i][j] and [j][i]
          return false;
        }
        if (board[j][i] != '.' && !validCol.add(board[j][i])) {
          return false;
        }
        // in cube
        int cubeRow = 3 * (i / 3);
        int cubeCol = 3 * (i % 3);
        if (board[cubeRow + j / 3][cubeCol + j % 3] != '.'
            && !validCube.add(board[cubeRow + j / 3][cubeCol + j % 3])) {
          return false;
        }

      }
    }

    return true;
  }
}

