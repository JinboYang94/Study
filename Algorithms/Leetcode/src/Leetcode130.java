/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * <p>
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be
 * flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally
 * or vertically.
 * </p>
 */

class Leetcode130 {

  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return;
    }
    int row = board.length;
    int col = board[0].length;
    // avoid border case
    for (int i = 0; i < row; i++) {
      if (board[i][0] == 'O') {
        borderCase(board, i, 0);
      }
      if (board[i][col - 1] == 'O') {
        borderCase(board, i, col - 1);
      }
    }
    for (int i = 0; i < col; i++) {
      if (board[0][i] == 'O') {
        borderCase(board, 0, i);
      }
      if (board[row - 1][i] == 'O') {
        borderCase(board, row - 1, i);
      }
    }
    // overall
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '!') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void borderCase(char[][] board, int rowIndex, int colIndex) {
    if (rowIndex < 0 || rowIndex > board.length - 1
        || colIndex < 0 || colIndex > board[0].length - 1) {
      return;
    }
    if (board[rowIndex][colIndex] == 'O') {
      board[rowIndex][colIndex] = '!';
    }
    // check up
    if (rowIndex - 1 >= 0 && board[rowIndex - 1][colIndex] == 'O') {
      borderCase(board, rowIndex - 1, colIndex);
    }
    // check down
    if (rowIndex + 1 <= board.length - 1 && board[rowIndex + 1][colIndex] == 'O') {
      borderCase(board, rowIndex + 1, colIndex);
    }
    // check left
    if (colIndex - 1 >= 0 && board[rowIndex][colIndex - 1] == 'O') {
      borderCase(board, rowIndex, colIndex - 1);
    }
    // check right
    if (colIndex + 1 <= board[0].length - 1 && board[rowIndex][colIndex + 1] == 'O') {
      borderCase(board, rowIndex, colIndex + 1);
    }
  }
}
