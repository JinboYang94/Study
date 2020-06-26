package LeetcodeProblems;

import java.util.HashMap;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * <p>
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </p>
 */

class Leetcode96 {

  public int numTrees(int n) {
    return helper(1, n, new HashMap<>());
  }

  private int helper(int start, int end, HashMap<Integer, Integer> memo) {
    // why must memo use (end - start) to track?? I tried use index (which index = i) fail at n = 19
    // when n = 18 pass. 19 is the last valid n value, 20 will exceed int range. why??
    if (memo.containsKey(end - start)) {
      return memo.get(end - start);
    }
    int ans = 0;
    if (start > end) {
      return 1;
    }
    for (int i = start;i <= end; i++) {
      int left = helper(start, i - 1, memo);
      int right = helper(i + 1, end, memo);
      ans += left * right;
    }
    memo.put(end - start, ans);
    return ans;
  }
}
