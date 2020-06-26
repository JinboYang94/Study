package OA.BloombergLP;

import java.util.Arrays;

/**
 * Want to fly participates to NY and SF offices. Each office can only accomodate half.
 * Goal is to assign each participate to an office in a way that the total travel
 * cost for the company is minimized.
 * Each participant is represented as pair of costs [costofNYFlight, costofSFFlight].
 * Determine the min cost given a list of participants.
 * Tag: refer to Leetcode 1029 solution b, a faster dp solution.
 *
 * <p>
 * Example:
 *
 * Input: [[500, 600], [600, 400], [200, 900], [700, 300]]
 * Output: 1400
 * Explanation: 200 + 500 + 400 + 300
 * </p>
 */

public class Bloomberg1 {

  public int minCost(int[][] costs) {
    int ans = 0;
    // sort based on difference, here means go [1] city much cheaper
    Arrays.sort(costs, (a, b) -> (a[1] - a[0] - (b[1] - b[0])));
    for (int i = 0; i < costs.length; i++) {
      if (i < costs.length / 2) {
        ans += costs[i][1];
      } else {
        ans += costs[i][0];
      }
    }
    return ans;
  }
}
