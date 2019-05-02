/**
 * Tag: two pointers with less complexity O(n)
 */

class Leetcode11b {

  public int maxArea(int[] height) {
    int low = 0;
    int high = height.length - 1;
    int maxArea = (high - low) * Math.min(height[low], height[high]);

    while (low < high) {
      if (height[low] > height[high]) {
        high--;
      } else {
        low++;
      }
      int temp = (high - low) * Math.min(height[low], height[high]);
      maxArea = temp > maxArea ? temp : maxArea;
    }

    return maxArea;
  }
}
