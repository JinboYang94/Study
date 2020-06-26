package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Tag: a really silly solution...brute force
 *
 * <p>
 * Example:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * </p>
 */

class Leetcode56 {

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1 || intervals.length == 0) {
      return intervals;
    }
    List<int[]> ans = new ArrayList<>();
    // sort array by first element using lambda expression
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    // loop all the int[](except the last one), compare one to the next one. If intersection,
    // three conditions:
    //(1) not reach last pair comparison and the adjacent two int[] intersect, go to
    //    a. the ans has already contained intervals[i], which means the this is a continuously
    //       merge, like ([1,2],[2,4],[3,6]) --> ([1,2],[1,4],[3,6] and ans is [1,4]) -->
    //       ([1,2],[1,4],[1,6] and ans is [1,4],[1,6]), we don't want [1,4] so remove before
    //       merge
    //    b. not continuously merge, so just add the merged result to ans and update the small
    //       int[] in the next loop with new merged int[]
    //(2) reach the last pair comparison and the last pair not intersect, go to
    //    a. if the (last - 1) int[] was not merged in previous loop, add it and go b
    //    b. if already exists, just add the last iny[]
    //(3) the adjacent two int[] not intersect, go to
    //    a. if this int[] already merged in previous loop, skip
    //    b. if not, just add this int[] to ans
    for (int i = 0; i < intervals.length - 1; i++) {
      if (i + 1 < intervals.length && checkIntersect(intervals[i], intervals[i + 1])) {
        if (ans.contains(intervals[i])) {
          ans.remove(intervals[i]);
        }
        intervals[i + 1] = mergeTwoIntervals(intervals[i], intervals[i + 1]);
        ans.add(intervals[i + 1]);
      } else if (i == intervals.length - 2 && !checkIntersect(intervals[i], intervals[i + 1])) {
        if (!ans.contains(intervals[i])) {
          ans.add(intervals[i]);
        }

        ans.add(intervals[i + 1]);
      } else {
        if (ans.contains(intervals[i])) {
          continue;
        }
        ans.add(intervals[i]);
      }
    }

    // convert from List to int[][]
    int[][] ret = new int[ans.size()][2];
    for (int i = 0; i < ans.size(); i++) {
      ret[i] = ans.get(i);
    }
    return ret;
  }

  private int[] mergeTwoIntervals(int[] i1, int[] i2) {
    int start1 = i1[0];
    int end1 = i1[1];
    int end2 = i2[1];
    int[] ans = new int[2];
    int start;
    int end;

    start = start1;
    if (end1 > end2) {
      end = end1;
    } else {
      end = end2;
    }
    ans[0] = start;
    ans[1] = end;
    return ans;
  }

  private boolean checkIntersect(int[] l1, int[] l2) {

    if (l1[1] >= l2[0]) {
      return true;
    } else {
      return false;
    }
  }
}
