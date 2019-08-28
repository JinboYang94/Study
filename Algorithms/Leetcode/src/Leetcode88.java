import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space
 * (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * <p>
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * </p>
 */

class Leetcode88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
      nums1[i + m] = nums2[i];
    }

    // Arrays.sort(nums1);  change to bubble sort
    int slow = 0;
    for (; slow < m + n; slow++) {
      int fast = slow + 1;
      while (fast < m + n) {
        if (nums1[slow] > nums1[fast]) {
          int temp = nums1[slow];
          nums1[slow] = nums1[fast];
          nums1[fast] = temp;
        }
        fast++;
      }
    }
  }
}
