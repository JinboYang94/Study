package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 *
 * <p>
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * </p>
 */

class Leetcode149 {

  public int maxPoints(int[][] points) {
    if (points == null) {
      return 0;
    }
    if (points.length <= 2) {
      return points.length;
    }

    int ans = 0;
    for (int i = 0; i < points.length - 1; i++) {
      Map<String, Integer> map = new HashMap<>();
      int overlap = 0;
      int lineMaxCount = 1;
      for (int j = i + 1; j < points.length; j++) {
        int x = points[i][0] - points[j][0];
        int y = points[i][1] - points[j][1];
        // same point
        if (x == 0 && y == 0) {
          overlap++;
          continue;
        }
        int gcd = getGcd(x, y);
        if (gcd != 0) {
          x /= gcd;
          y /= gcd;
        }
        String slope = String.valueOf(x) + String.valueOf(y);
        int count = map.getOrDefault(slope, 1);
        count++;
        map.put(slope, count);
        lineMaxCount = Math.max(lineMaxCount, count);
      }
      ans = Math.max(ans, lineMaxCount + overlap);
    }
    return ans;
  }

  // get greatest common divisor
  private int getGcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return getGcd(b, a % b);
  }
}
