package LeetcodeProblems;

/**
 * Using binary search, O(nlogn) solution, slower.
 */

class Leetcode209b {

  public int minSubArrayLen(int s, int[] nums) {
    int[] sums = new int[nums.length + 1];
    // get cumulative sums, subarray sum is expressed as difference between two cumulative sums.
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    // i is start index, end is end index of subarray.
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < sums.length; i++) {
      int end = binarySearch(i + 1, nums.length, s + sums[i], sums);
      if (end == sums.length) {
        break;
      }
      ans = Math.min(end - i, ans);
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  private int binarySearch(int start, int end, int tar, int[] sums) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (sums[mid] >= tar) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }
}
