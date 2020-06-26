package LeetcodeProblems;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared
 * at most twice and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * <p>
 * Example:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * </p>
 */

class Leetcode80 {

  public int removeDuplicates(int[] nums) {
    int slow = 0;
    int fast = 1;
    int count = 1;
    for (; fast < nums.length; fast++) {
      if (nums[slow] == nums[fast]) {
        if (count < 2) {
          count++;
          slow++;
          nums[slow] = nums[fast];
        }
      } else {
        count = 1;  // reset count
        slow++;
        nums[slow] = nums[fast];
      }
    }
    return ++slow;
  }
}
