package LeetcodeProblems;

/**
 * Tag: This method checks whether there is a unavoidable 0.
 */

public class Leetcode55b {

  public boolean canJump(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        int j = i - 1;
        boolean canSkip = false;
        for (int k = 0; k <= j; k++) {
          if (nums[k] + k > i) {
            canSkip = true;
          }
        }
        if (!canSkip) {
          return false;
        }
      }
    }
    return true;
  }
}
