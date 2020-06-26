package LeetcodeProblems;

import java.util.Arrays;

/**
 * Sorting.
 */

class Leetcode169b {

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
