package LeetcodeProblems;

/**
 * O(1) space solution.
 * bitwise XOR operation in Java:
 * 0 ^ N = N
 * N ^ N = 0
 * so N is the single number, will finally gen N
 */

class Leetcode136b {

  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      ans ^= nums[i];
    }
    return ans;
  }
}
