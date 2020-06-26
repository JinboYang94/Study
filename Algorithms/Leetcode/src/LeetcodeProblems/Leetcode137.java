package LeetcodeProblems;

/**
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * <p>
 * Example:
 *
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * </p>
 */

class Leetcode137 {

  public  int singleNumber(int[] nums) {
    int firstMeet = 0;
    int secondMeet = 0;
    for (int i = 0; i < nums.length; i++) {
      firstMeet = (firstMeet ^ nums[i]) & ~ secondMeet;
      secondMeet = (secondMeet ^ nums[i]) & ~ firstMeet;
    }
    return firstMeet;
  }
}
