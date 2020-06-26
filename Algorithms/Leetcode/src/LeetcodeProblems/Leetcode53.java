package LeetcodeProblems;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 * Follow up:
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * </p>
 */

class Leetcode53 {

  public int maxSubArray(int[] nums) {
    int max = nums[0];
    // here dp stores the largest sum of elements ending at nums[i], e.g.[a, b, c, d]
    // when i = 2, count (a + b) if > 0, that means make sum larger, so add it.
    // else the dp[i] is nums[i]. Then update max
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (dp[i  - 1] > 0) {
        dp[i] = dp[i - 1] + nums[i];
      } else {
        dp[i] = nums[i];
      }
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return max;
  }
}
