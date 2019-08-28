/**
 * Follow up: A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * Here try the one-pass algorithm, use two pointer.
 */

class Leetcode75b {

  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int twoIndex = nums.length - 1;
    for (int i = 0; i <= twoIndex; i++) { // when meet 2nd index stop
      if (nums[i] == 0) {
        swap(nums, i, zeroIndex++);
      }
      if (nums[i] == 2) {
        swap(nums, i--, twoIndex--);  // i-- because we need to check the new nums[i]
      }
    }
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
