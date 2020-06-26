package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * A discuss O(n) solution, hard to come up.
 */

class Leetcode128b {

  public int longestConsecutive(int[] num) {
    int ans = 0;
    // bound index, length
    Map<Integer, Integer> map = new HashMap<>();

    for (int n : num) {
      if (!map.containsKey(n)) {
        int leftBound = map.containsKey(n - 1) ? map.get(n - 1) : 0;
        int rightBound = map.containsKey(n + 1) ? map.get(n + 1) : 0;
        int sum = leftBound + rightBound + 1;
        map.put(n, sum);
        // update max length
        ans = Math.max(ans, sum);
        // extend length to bounds, do noting if no left && right
        map.put(n - leftBound, sum);
        map.put(n + rightBound, sum);
      } else {
        continue;
      }
    }
    return ans;
  }
}
