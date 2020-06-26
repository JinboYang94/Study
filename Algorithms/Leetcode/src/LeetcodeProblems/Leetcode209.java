package LeetcodeProblems;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of
 * a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time
 * complexity is O(n log n).
 *
 * <p>
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * </p>
 */

class Leetcode209 {

  public int minSubArrayLen(int s, int[] nums) {
    int ans = Integer.MAX_VALUE;
    int sum = 0;
    int count = 0;
    int j = 0;  // start of subarray
    for (int i = 0; i < nums.length; i++) { // i is end of subarray
      sum += nums[i];
      count++;
      // while the condition satisfied, try to move start index
      while (sum >= s) {
        ans = Math.min(ans, count--);
        sum -= nums[j++];
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
