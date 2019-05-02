/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * <p>
 * Example:
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * </p>
 */

class Leetcode41 {

  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    return nums.length + 1;
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
