package LeetcodeProblems;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix
 * of the array (including the whole array) fits in a 32 bit integer.
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class Leetcode238 {

  public int[] productExceptSelf(int[] nums) {
    // left[i] is the left value of ret[i]
    int[] left = new int[nums.length];
    // right[i] is the right value of ret[i]
    int[] right = new int[nums.length];
    int[] ret = new int[nums.length];
    left[0] = right[nums.length - 1] = 1;
    // get all left values
    for (int i = 1; i < nums.length; i++) {
      left[i] = nums[i - 1] * left[i - 1];
    }
    // get all right values
    for (int i = nums.length - 2; i >= 0; i--) {
      right[i] = nums[i + 1] * right[i + 1];
    }
    for (int i = 0; i < nums.length; i++) {
      ret[i] = left[i] * right[i];
    }
    return ret;
  }
}
