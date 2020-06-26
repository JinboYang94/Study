package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sums to target. Each number in
 * candidates may only be used once in the combination. Note: All numbers (including target) will be
 * positive integers. The solution set must not contain duplicate combinations.
 *
 * <p>
 * Example:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1, 7], [1, 2, 5], [2, 6],
 * [1, 1, 6] ]
 *
 * Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [ [1,2,2], [5] ]
 * </p>
 */

class Leetcode40 {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();
    backtracking(ans, sol, candidates, target, 0);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, List<Integer> sol, int[] pool, int tar,
      int idx) {
    if (tar < 0) {
      return;
    } else if (tar == 0) {
      ans.add(new ArrayList<>(sol));
    } else {
      for (int i = idx; i < pool.length; i++) {
        if (i - 1 >= 0 && i != idx && pool[i] == pool[i - 1]) { // avoid duplicate numbers
          continue;   // above i != idx is for guarantee ans can have same value numbers but
        }             // not the same one. or use i > index. Because i == idx && pool[i] == p[i - 1]
        sol.add(pool[i]);// this only means the [1,1,6] same value situation.
        backtracking(ans, sol, pool, tar - pool[i], i + 1);
        sol.remove(sol.size() - 1);
      }
    }
  }
}
