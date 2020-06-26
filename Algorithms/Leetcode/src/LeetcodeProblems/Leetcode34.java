package LeetcodeProblems;

/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * <p>
 * Example:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * </p>
 */

class Leetcode34 {

  public int[] searchRange(int[] nums, int target) {

    int ans = binarySearch(nums, target);   // ans(index) for searching target in nums
    int temp = ans;   // start
    int temp2 = ans;    // end
    if (ans == -1) {    // if target not found, just return [-1, -1]
      return new int[] {-1, -1};
    } else {    // if found, search left and right to see if other index == ans
      for (int i = ans - 1; i >= 0; i--) {
        if (nums[i] == nums[ans]) {
          temp--;
        } else {
          break;
        }
      }
      for (int j = ans + 1; j < nums.length; j++) {
        if (nums[j] == nums[ans]) {
          temp2++;
        } else {
          break;
        }
      }
      return new int[] {temp, temp2};
    }

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
        high = mid - 1;
      }
    }

    return -1;
  }
}
