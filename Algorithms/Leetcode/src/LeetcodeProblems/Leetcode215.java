package LeetcodeProblems;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element
 * in the sorted order, not the kth distinct element.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * Tag: actually Arrays.sort() works better...idk why.
 *
 * <p>
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * </p>
 */

class Leetcode215 {

  public int findKthLargest(int[] nums, int k) {
    if (nums.length == 0) {
      return -1;
    }
    return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
  }

  private int quickSelect(int[] nums, int start, int end, int kSmall) {
    int idx = partition(nums, start, end);
    if (idx == kSmall - 1) {
      return nums[idx];
    } else if (idx > kSmall - 1) {
      return quickSelect(nums, start, idx - 1, kSmall);
    } else {
      return quickSelect(nums, idx + 1, end, kSmall);
    }
  }

  private int partition(int[] nums, int start, int end) {
    int pivot = nums[start];
    while (start < end) {
      while (start < end && nums[end] >= pivot) {
        end--;
      }
      nums[start] = nums[end];
      while (start < end && nums[start] < pivot) {
        start++;
      }
      nums[end] = nums[start];
    }
    nums[start] = pivot;
    return start;
  }
}
