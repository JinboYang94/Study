package LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * <p>
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * </p>
 */

class Leetcode128 {

  public int longestConsecutive(int[] nums) {
    int ans = 0;
    Set<Integer> pool = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      pool.add(nums[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      // find possible consecutive start
      if (pool.contains(nums[i] - 1)) {
        continue;
      } else {
        int tempCount = 0;
        tempCount++;
        while (pool.contains(nums[i] + 1)) { // ? O(n) because worst case O(2n)
          nums[i] = nums[i] + 1;
          tempCount++;
        }
        ans = Math.max(ans, tempCount);
      }
    }
    return ans;
  }
}
