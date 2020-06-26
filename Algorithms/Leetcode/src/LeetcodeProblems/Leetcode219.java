package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct
 * indices i and j in the array such that nums[i] = nums[j] and the absolute difference
 * between i and j is at most k.
 *
 * <p>
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * </p>
 */

class Leetcode219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> pool = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (pool.containsKey(nums[i])) {
        if (i - pool.get(nums[i]) <= k) {
          return true;
        }
      }
      pool.put(nums[i], i);
    }
    return false;
  }
}
