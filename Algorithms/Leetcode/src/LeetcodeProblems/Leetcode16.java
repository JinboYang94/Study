package LeetcodeProblems;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly
 * one solution.
 *
 * <p>
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </p>
 */

class Leetcode16 {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      // binary search
      while (j < k) {
        // update ans
        int currSum = nums[i] + nums[j] + nums[k];
        if (Math.abs(ans - target) > Math.abs(currSum - target)) {
          ans = currSum;
        }
        // get close to target
        if (currSum > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return ans;
  }
}
