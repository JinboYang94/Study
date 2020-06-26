package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * <p>
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * </p>
 */

class Leetcode199 {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<Integer> ans, TreeNode root, int lv) {
    if (root == null) {
      return;
    }
    if (ans.size() == lv) {
      ans.add(root.val);
    }
    dfs(ans, root.right, lv + 1);
    dfs(ans, root.left, lv + 1);
  }
}
