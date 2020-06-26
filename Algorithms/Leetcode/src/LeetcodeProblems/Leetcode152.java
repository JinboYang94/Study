package LeetcodeProblems;

/**
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * <p>
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * </p>
 */

class Leetcode152 {

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int ans = nums[0];
    int max = nums[0];
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int temp = max;
      // current max value
      max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
      // current min value, for perhaps next time will get a negative value
      min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
      // update
      if (max > ans) {
        ans = max;
      }
    }
    return ans;
  }
}
