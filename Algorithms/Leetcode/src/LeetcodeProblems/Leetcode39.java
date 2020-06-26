package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * <p>
 * Example:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * </p>
 */

class Leetcode39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<Integer> solution = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    dfs(candidates, target, solution, ans, 0);
    return ans;
  }

  private void dfs(int[] cand, int tar, List<Integer> sol, List<List<Integer>> ans, int idx) {
    if (tar < 0) {
      return;
    } else if (tar == 0) {
      ans.add(new ArrayList<>(sol));  // because the sol will be cleared after finding each
    } else {                          // solution, but this copy keep a reference to sol's update,
      for (int i = idx; i < cand.length; i++) { // guarantee to record the changes
        if (cand[i] > tar) {
          break;
        }
        sol.add(cand[i]);
        dfs(cand, tar - cand[i], sol, ans, i);  // backtracking
        sol.remove(sol.size() - 1); // clear all
      }
    }
  }
}
