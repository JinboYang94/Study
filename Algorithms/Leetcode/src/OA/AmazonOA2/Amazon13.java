package OA.AmazonOA2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are in charge of preparing a recently purchased lot for Amazon’s building.
 * The lot is covered with trenches and has a single obstacle that needs to be taken down before
 * the foundation is prepared for the building.
 * The demolition robot must remove the obstacle before the progress can be made on the building.
 * Write an algorithm to determine the minimum distance required for the demolition robot to
 * remove the obstacle.
 * Assumptions:
 * • The lot is flat, except the trenches and can be represented by a 2D grid.
 * • The demolition robot must start at the top left corner of the lot, which is always flat,
 *   and can move on block up, down, right, left
 * • The demolition robot cannot enter trenches and cannot leave the lot.
 * • The flat areas are indicated by 1, areas with trenches are indicated by 0,
 *   and the obstacle is indicated by 9
 * Input:
 * The input of the function has 3 arguments: numRows – number of rows
 * numColumns – number of columns
 * lot – 2d grid of integers
 * Output:
 * Return an integer that indicated the minimum distance traversed to remove the obstacle
 * else return -1
 * Constraints:
 * 1<= numRows, numColumns <= 1000
 *
 * <p>
 * Example:
 * Input:
 * numRows = 3
 * numColumns = 3
 * lot = [
 * [1, 0, 0],
 * [1, 0, 0],
 * [1, 9, 1]]
 *
 * Output: 3
 *
 * Explanation:
 * Starting from the top-left corner, the demolition robot traversed the cells (0,0) -> (1,0)-> (2,0)->(2,1)
 * The robot moves 3 times to remove the obstacle “9”
 * </p>
 */

public class Amazon13 {

  public int moveObstacle(int row, int col, int[][] grid) {
    int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {0, 0});
    boolean[][] visited = new boolean[row][col];
    visited[0][0] = true;
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] currPoint = queue.poll();
        for (int[] dir : direction) {
          int x = currPoint[0] + dir[0];
          int y = currPoint[1] + dir[1];
          if (x < 0 || x > row - 1 || y < 0 || y > col - 1 || grid[x][y] == 0 || visited[x][y]) {
            continue;
          }
          if (grid[x][y] == 9) {
            return ans + 1;
          } else {
            visited[x][y] = true;
            queue.offer(new int[] {x, y});
          }
        }
      }
      ans++;
    }
    return -1;
  }
}
