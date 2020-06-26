package LeetcodeProblems;

/**
 * Implement quick sort.
 */

class Leetcode88b {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
      nums1[i + m] = nums2[i];
    }

    // Quick sort
    quickSort(nums1,0, nums1.length - 1);
  }

  private void quickSort(int[] nums, int low, int high) {
    if (low < high) {
      int mid = getMid(nums, low, high);  // split nums
      quickSort(nums, low, mid - 1);  //  sort left
      quickSort(nums, mid + 1, high); // sort right
    }
  }

  private int getMid(int[] nums, int low, int high) {
    int temp = nums[low]; // initialize first as mid
    while (low < high) {
      while (low < high && nums[high] >= temp) {
        high--;
      }
      nums[low] = nums[high]; // move those values which are smaller than mid
      while (low < high && nums[low] < temp) {
        low++;
      }
      nums[high] = nums[low];
    }

    nums[low] = temp; // set the initial mid to where it should be
    return low;
  }
}
