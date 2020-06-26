package LeetcodeProblems;

/**
 * Binary search, iterative.
 */

class Leetcode162b {

  public int findPeakElement(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      int mid = i + (j - i) / 2;
      // mid is on descending sequence, peak is front.
      if (nums[mid] > nums[mid + 1]) {
        j = mid;
      } else {  // mid is on ascending sequence, peak is behind.
        i = mid + 1;
      }
    }
    return i; // or return j
  }
}
