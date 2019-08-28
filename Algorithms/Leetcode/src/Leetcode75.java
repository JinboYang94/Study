/**
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to
 * represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Tag: two-pass algorithm
 *
 * <p>
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * </p>
 */

class Leetcode75 {

  public void sortColors(int[] nums) {
    int zeroCt = 0;
    int oneCt = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroCt++;
      }
      if (nums[i] == 1) {
        oneCt++;
      }
    }

    int twoCt = nums.length - zeroCt - oneCt;
    for (int i = 0; i < nums.length; i++) {
      if (i < zeroCt) {
        nums[i] = 0;
      } else if (i < (zeroCt + oneCt)) {
        nums[i] = 1;
      } else {
        nums[i] = 2;
      }
    }
  }
}
