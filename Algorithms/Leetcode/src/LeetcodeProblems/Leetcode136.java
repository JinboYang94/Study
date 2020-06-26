package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * <p>
 * Example:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 * </p>
 */

class Leetcode136 {

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> pool = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (pool.containsKey(nums[i])) {
        pool.put(nums[i], pool.get(nums[i]) + 1);
      } else {
        pool.put(nums[i], 1);
      }
    }
    int ans = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (pool.get(nums[i]) == 1) {
        ans = nums[i];
      }
    }
    return ans;
  }
}
