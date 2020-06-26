package OA.AmazonOA2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You have a map that marks the locations of treasure islands.
 * Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in. There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to one of the treasure island.
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from one of the starting point (marked as S) of the map and can move
 * one block up, down, left or right at a time.
 * The treasure island is marked as X in a block of the matrix.
 * Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks.
 * You cannot leave the map area. Other areas O are safe to sail in.
 * Output the minimum number of steps to get to any of the treasure.
 *
 * <p>
 * Example:
 * Input:
 * [
 * [‘S’, ‘O’, ‘O’, 'S', ‘S’],
 * [‘D’, ‘O’, ‘D’, ‘O’, ‘D’],
 * [‘O’, ‘O’, ‘O’, ‘O’, ‘X’],
 * [‘X’, ‘D’, ‘D’, ‘O’, ‘O’],
 * [‘X', ‘D’, ‘D’, ‘D’, ‘O’],
 * ]
 *
 * Output: 5
 * Explanation:
 * You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0).
 * Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 * </p>
 */

public class Amazon3 {

  public int findTreasure2(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int row = grid.length;
    int col = grid[0].length;
    int[][] direction = new int[][] {{0, - 1}, {0, 1}, {-1, 0}, {1, 0}};
    int ans = 1;
    boolean[][] visited = new boolean[row][col];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 'S') {
          queue.offer(new int[] {i, j});
//          grid[i][j] = 'D';
          visited[i][j] = true;
        }
      }
    }

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] curr = queue.poll();
        int x = curr[0];
        int y = curr[1];
        for (int[] dir : direction) {
          int newX = x + dir[0];
          int newY = y + dir[1];
          // check over bound
          if (newX < 0 || newX > row - 1 || newY < 0 || newY > col - 1 || grid[newX][newY] == 'D'
              || visited[newX][newY]) {
            continue;
          }
          if (grid[newX][newY] == 'X') {
            return ans;
          } else {
            queue.offer(new int[] {newX, newY});
            visited[newX][newY] = true;
          }
        }
      }
      ans++;
    }
    return -1;
  }
}
