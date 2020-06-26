package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates,
 * nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * <p>
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * </p>
 */

class Leetcode90 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(ans, new ArrayList<>(), nums, 0);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index) {
    ans.add(new ArrayList<>(temp));
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[i - 1]) {  // same value don't count twice
        continue;
      }
      temp.add(nums[i]);
      backtrack(ans, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}
