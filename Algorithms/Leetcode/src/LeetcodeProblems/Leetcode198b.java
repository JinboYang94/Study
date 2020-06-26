package LeetcodeProblems;

/**
 * A more efficient way, using iterative from bottom-up.
 */

class Leetcode198b {

  public int rob(int[] nums) {
    // preRobbed represents the previous house has been robbed.
    int preRobbed = 0;
    int preNotRobbed = 0;
    for (int i = 0; i < nums.length; i++) {
      // rob current, then previous must not be robbed.
      int robCurr = preNotRobbed + nums[i];
      // not rob current, then choose previous robbed or not to get maximum.
      int notRobCurr = Math.max(preRobbed, preNotRobbed);
      // update values
      preRobbed = robCurr;
      preNotRobbed = notRobCurr;
    }
    return Math.max(preRobbed, preNotRobbed);
  }
}
