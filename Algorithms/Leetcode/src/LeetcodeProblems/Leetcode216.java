package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * <p>
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * </p>
 */

class Leetcode216 {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), k, n, 1);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, List<Integer> temp, int limit, int tar, int index) {
    if (temp.size() > limit) {
      return;
    } else if (temp.size() == limit) {
      int tempSum = 0;
      for (int i : temp) {
        tempSum += i;
      }
      if (tempSum == tar) {
        ans.add(new ArrayList<>(temp));
      } else {
        return;
      }
    } else {
      for (int i = index; i <= 9; i++) {
        temp.add(i);
        dfs(ans, temp, limit, tar, i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
