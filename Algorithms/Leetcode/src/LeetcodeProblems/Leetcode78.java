package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * <p>
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </p>
 */

class Leetcode78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, new ArrayList<>(), nums, 0);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index) {
    ans.add(new ArrayList<>(temp));
    for (int i = index; i < nums.length; i++) {
      temp.add(nums[i]);
      backtrack(ans, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}
