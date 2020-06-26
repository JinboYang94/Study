package LeetcodeProblems;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * <p>
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * </p>
 */

class Leetcode200 {

  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int ans = 0;
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          ans++;
        }
      }
    }
    return ans;
  }

  private void dfs(char[][] grid, int i, int j) {
    // out of bound
    if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
      return;
    }
    // if '1', mark all neighbour '1' to 'x'
    if (grid[i][j] == '1') {
      grid[i][j] = 'x';
      dfs(grid, i - 1, j);
      dfs(grid, i + 1, j);
      dfs(grid, i, j - 1);
      dfs(grid, i, j + 1);
    }
  }
}
