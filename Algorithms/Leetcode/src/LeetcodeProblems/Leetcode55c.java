package LeetcodeProblems;

/**
 * Tag: try backtracking solution.
 * TLE...abandon it.
 */

class Leetcode55c {

  public boolean canJump(int[] nums) {
    return jump(nums, 0);
  }

  private boolean jump(int[] pool, int position) {
    if (position == pool.length - 1) {
      return true;
    }

    int jumpLength = position + pool[position];

    for (int pos = position + 1; pos <= jumpLength; pos++) {
      if (jump(pool, pos) || jumpLength >= pool.length - 1) {
        return true;
      }
    }

    return false;
  }
}
