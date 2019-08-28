/**
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Tag: This method loops through the array, see if there is a index > bound, which the
 * bound is the max length we can jump to. If index > bound, that means a unavoidable 0 exists.
 * Because if this 0 can be jumped over, the bound must be larger than (0 + 0's index).
 * <p>
 * Example:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * </p>
 */

class Leetcode55 {

  public boolean canJump(int[] nums) {
    int bound = 0;
    int maxJumpLength = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i > bound) {
        return false;
      }
      maxJumpLength = Math.max(maxJumpLength, nums[i] + i);
      if (i == bound) {
        bound = maxJumpLength;
      }
    }
    return true;
  }
}
