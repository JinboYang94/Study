/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * <p>
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * </p>
 */

class Leetcode42 {

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int ans = 0;

    for (int i = 1; i < height.length - 1; i++) {
      int leftMax = height[0];
      int rightMax = height[height.length - 1];

      for (int j = i - 1; j >= 0; j--) {
        leftMax = height[j] > leftMax ? height[j] : leftMax;
      }
      for (int k = i + 1; k < height.length; k++) {
        rightMax = height[k] > rightMax ? height[k] : rightMax;
      }

      int realHeight = Math.min(leftMax, rightMax);
      int tempBar = realHeight - height[i];
      if (tempBar > 0) {
        ans += tempBar;
      }
    }

    return ans;
  }
}
