package LeetcodeProblems;

import java.util.Arrays;

/**
 * Based on quick sort. It is partial quick sort since we only get a mid and divide the array into
 * two parts.
 */

class Leetcode973b {

  public int[][] kClosest(int[][] points, int K) {
    int start = 0;
    int end = points.length - 1;
    while (start < end) {
      // points[mid] left all smaller, right all larger
      int mid = getMid(points, start, end);
      if (mid == K) {
        break;
      } else if (mid < K) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return Arrays.copyOfRange(points, 0, K);
  }

  // sort array, with left of s(start) < pivot, right of s(start) > pivot
  private int getMid(int[][] points, int s, int e) {
    int[] pivot = points[s];
    while (s < e) {
      // if e's value > pivot, keep going
      while (s < e && compare(points[e], pivot)) {
        e--;
      }
      points[s] = points[e];
      while (s < e && compare(pivot, points[s])) {
        s++;
      }
      points[e] = points[s];
    }
    points[s] = pivot;
    return s;
  }

  private boolean compare(int[] a, int[] b) {
    int distA = a[0] * a[0] + a[1] * a[1];
    int distB = b[0] * b[0] + b[1] * b[1];
    return distA >= distB;
  }
}
