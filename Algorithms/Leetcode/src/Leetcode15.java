import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * <p>
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * </p>
 */

class Leetcode15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {  // avoid duplicate nums[i]
        continue;
      }
      int j = i + 1;  // binary search
      int k = nums.length - 1;
      int tar = -nums[i];
      while (j < k) {
        if (nums[j] + nums[k] == tar) {
          ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) {  // avoid duplicate nums[j]
            j++;
          }
          while (j < k && nums[k] == nums[k + 1]) {  // avoid duplicate nums[k]
            k--;
          }
        } else if (nums[j] + nums[k] > tar) {
          k--;
        } else {
          j++;
        }
      }
    }

    return ans;
  }
}
