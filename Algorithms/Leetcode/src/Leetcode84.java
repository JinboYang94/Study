import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * <p>
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * </p>
 */

class Leetcode84 {

  public int largestRectangleArea(int[] heights) {
    List<Integer> allHeights = new ArrayList<>();
    for (int i = 0; i < heights.length; i++) {
      if (!allHeights.contains(heights[i])) {
        allHeights.add(heights[i]);
      }
    }
    int maxArea = 0;
    for (int h : allHeights) {
      int width = 0;
      int maxWidth = 1;
      for (int i = 0; i < heights.length; i++) {
        if (heights[i] >= h) {
          width++;
        } else {
          maxWidth = Math.max(maxWidth, width);
          width = 0;
        }
      }
      maxWidth = Math.max(maxWidth, width);
      maxArea = Math.max(maxArea, h * maxWidth);
    }
    return maxArea;
  }
}
