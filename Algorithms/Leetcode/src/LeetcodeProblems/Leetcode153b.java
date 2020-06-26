package LeetcodeProblems;

/**
 * A much more simple solution, a little bit slower in ide.
 */

class Leetcode153b {

  public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[end]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return nums[start];
  }
}
