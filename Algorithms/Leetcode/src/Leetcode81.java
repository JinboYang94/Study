/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search.
 * If found in the array return true, otherwise return false.
 * <p>
 * Example:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * </p>
 */

class Leetcode81 {

  public boolean search(int[] nums, int target) {
    int start = 0;
    int end =  nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return true;
      } else {
        if (nums[start] > nums[mid]) {
          if (target > nums[mid] && target <= nums[end]) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        } else if (nums[start] < nums[mid]) {
          if (target >= nums[start] && target < nums[mid]) {
            end = mid - 1;
          } else {
            start = mid + 1;
          }
        } else {  // nums[start] == nums[mid] && nums[mid] != target, skip start
          start++;
        }
      }
    }
    return false;
  }
}
