package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </p>
 */

class Leetcode77 {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, new ArrayList<>(), n, k, 1);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, List<Integer> tempAns, int n, int k, int index) {
    if (tempAns.size() == k) {
      ans.add(new ArrayList<>(tempAns));
    } else if (tempAns.size() > k) {
      return;
    } else {
      for (int i = index; i <= n; i++) {
        tempAns.add(i);
        backtrack(ans, tempAns, n, k, i + 1);
        tempAns.remove(tempAns.size() - 1);
      }
    }
  }
}
