package OA.AmazonOA2;

import java.util.Arrays;

/**
 * Find the k post offices located closest to you,
 * given your location and a list of locations of all post offices available.
 * Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
 * Euclidean distance is applied to find the distance between you and a post office.
 * Assume your location is [m, n] and the location of a post office is [p, q],
 * the Euclidean distance between the office and you is
 * SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
 * K is a positive integer much smaller than the given number of post offices.
 *
 * <p>
 * Example:
 * Input:
 * you: [0, 0]
 * post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
 * k = 3
 *
 * Output:
 * [[-1, 2], [0, 3], [4, 3]]
 * </p>
 */

public class Amazon4 {

  public int[][] findOffice(int[][] points, int k, int[] origin) {
    if (points.length == 0 || points[0].length == 0) {
      return null;
    }
    int start = 0;
    int end = points.length - 1;
    while (start < end) {
      int mid = getMid(points, start, end, origin);
      if (mid == k) {
        break;
      } else if (mid < k) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return Arrays.copyOfRange(points, 0, k);
  }

  private int getMid(int[][] points, int s, int e, int[] origin) {
    int[] pivot = points[s];
    while (s < e) {
      while (s < e && compare(points[e], pivot, origin)) {
        e--;
      }
      points[s] = points[e];
      while (s < e && compare(pivot, points[s], origin)) {
        s++;
      }
      points[e] = points[s];
    }
    points[s] = pivot;
    return s;
  }

  private boolean compare(int[] a, int[] b, int[] o) {
    int distA = (a[0] - o[0]) * (a[0] - o[0]) + (a[1] - o[1]) * (a[1] - o[1]);
    int distB = (b[0] - o[0]) * (b[0] - o[0]) + (b[1] - o[1]) * (b[1] - o[1]);
    return distA >= distB;
  }
}
