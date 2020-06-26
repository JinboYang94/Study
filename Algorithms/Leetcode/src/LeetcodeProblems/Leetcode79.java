package LeetcodeProblems;

/**
 * Given a 2D board and a word, find if the word exists in the grid. The word can be constructed
 * from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
 * vertically neighboring. The same letter cell may not be used more than once. Tag: DFS
 *
 * <p>
 * Example:
 *
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 *
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given word = "ABCB", return
 * false.
 * </p>
 */

class Leetcode79 {

  public boolean exist(char[][] board, String word) {
    int row = board.length;
    int col = board[0].length;

    boolean[][] visited = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (dfs(board, word, visited, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col,
      int index) {
    // must put check in first line
    if (index == word.length()) { // already checked the last character in word
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return false;
    }

    char c = word.charAt(index);
    if (!visited[row][col] && c == board[row][col]) {
      visited[row][col] = true;
      boolean ret = dfs(board, word, visited, row - 1, col, index + 1)
          || dfs(board, word, visited, row + 1, col, index + 1)
          || dfs(board, word, visited, row, col - 1, index + 1)
          || dfs(board, word, visited, row, col + 1, index + 1);
      visited[row][col] = false;  // reset after one search
      return ret;
    }
    return false;
  }
}
