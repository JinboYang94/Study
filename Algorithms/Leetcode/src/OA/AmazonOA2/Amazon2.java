package OA.AmazonOA2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You have a map that marks the location of a treasure island.
 * Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in.
 * There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to the treasure island.
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from the top-left corner of the map and can move one block up, down,
 * left or right at a time.
 * The treasure island is marked as ‘X’ in a block of the matrix.
 * ‘X’ will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as ‘D’.
 * You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
 * Output the minimum number of steps to get to the treasure.
 *
 * <p>
 * Example:
 * Input:
 * [
 * [‘O’, ‘O’, ‘O’, ‘O’],
 * [‘D’, ‘O’, ‘D’, ‘O’],
 * [‘O’, ‘O’, ‘O’, ‘O’],
 * [‘X’, ‘D’, ‘D’, ‘O’],
 * ]
 *
 * Output: 5
 * Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 * </p>
 */

public class Amazon2 {

  public int findTreasure(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0 || grid[0][0] == 'D') {
      return -1;
    }
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int row = grid.length;
    int col = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {0, 0});
    int ans = 1;
    // visited make more efficient, I think can be removed
    boolean[][] visited = new boolean[row][col];
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      // all valid possibilities left/right/up/down
      for (int i = 0; i < size; i++) {
        int[] curr = queue.poll();
        for (int[] dir : directions) {
          int x = curr[0] + dir[0];
          int y = curr[1] + dir[1];
          // check over bound
          if (x < 0 || x > row - 1 || y < 0 || y > col - 1 || grid[x][y] == 'D' || visited[x][y]) {
            continue;
          }
          if (grid[x][y] == 'X') {
            return ans;
          } else {
            queue.offer(new int[] {x, y});
            visited[x][y] = true;
          }
        }
      }
      // after one move, ans++
      ans++;
    }
    return -1;
  }
}
