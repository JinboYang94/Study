/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * <p>
 * Example:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 * </p>
 * Ps: we can use binary search directly and just return low if not found...
 */

class Leetcode35 {

  public int searchInsert(int[] nums, int target) {
    int ans = binarySearch(nums, target);

    if (ans >= 0) {
      return ans;
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > target) {
          return i;
        }
      }
    }
    return nums.length;
  }

  private int binarySearch(int[] nums, int tar) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == tar) {
        return mid;
      }
      if (nums[mid] < tar) {
        low = mid + 1;
      }
      if (nums[mid] > tar) {
        high = high - 1;
      }
    }
    return -1;
  }
}
