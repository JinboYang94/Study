import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Tag: Use the previous 56, first make new int[][] then merge.
 *
 * <p>
 * Example:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * </p>
 */

class Leetcode57 {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int[][] intervalsNew = new int[intervals.length + 1][2];

    for (int i = 0; i < intervals.length; i++) {
      intervalsNew[i] = intervals[i];
    }
    intervalsNew[intervalsNew.length - 1] = newInterval;

    Leetcode56 a = new Leetcode56();
    return a.merge(intervalsNew);
  }
}
