/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * <p>
 * Example:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 * </p>
 */

class Leetcode4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int a = nums1.length;
    int b = nums2.length;

    if (a > b) {    // make sure nums1.length <nums2.length
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
      int temp2 = a;
      a = b;
      b = temp2;
    }

    int min = 0;
    int max = a;
    int half = (a + b + 1) / 2;

    while (min <= max) {
      int i = (min + max) / 2;
      int j = half - i;

      // if this i makes nums2's left part larger than nums1's right part, min change.
      if (i < max && nums2[j - 1] > nums1[i]) {
        min = i + 1;
      } else if (i > min && nums1[i - 1] > nums2[j]) {
        max = i - 1;
      } else {        // here already find the correct i

        int maxL;   // left max
        if (i == 0) {
          maxL = nums2[j - 1];
        } else if (j == 0) {
          maxL = nums1[i - 1];
        } else {
          maxL = Math.max(nums1[i - 1], nums2[j - 1]);
        }

        if ((a + b) % 2 == 1) {
          return maxL;
        }

        int minR;   // right min
        if (i == a) {
          minR = nums2[j];
        } else if (j == b) {
          minR = nums1[i];
        } else {
          minR = Math.min(nums1[i], nums2[j]);
        }
        return (double) (maxL + minR) / 2;  // maxL + minR
      }
    }

    return 0.0;
  }
}
