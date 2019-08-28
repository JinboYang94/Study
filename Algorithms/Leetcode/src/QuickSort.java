/**
 * Quick sort which is used by Arrays.sort() for int...
 */

class QuickSort {

  public int[] quickSortInterface(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    quickSort(nums, low, high);
    return nums;
  }

  public void quickSort(int[] nums, int low, int high) {
    if (low < high) {
      int idx = getIdx(nums, low, high);
      quickSort(nums, low, idx - 1);
      quickSort(nums, idx + 1, high);
    }
  }

  private int getIdx(int[] nums, int low, int high) {
    int temp = nums[low];
    while (low < high) {
      while (low < high && nums[high] >= temp) {
        high--;
      }
      nums[low] = nums[high];
      while (low < high && nums[low] < temp) {
        low++;
      }
      nums[high] = nums[low];
    }

    nums[low] = temp;
    return low;
  }
}
