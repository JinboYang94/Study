package LeetcodeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 */

class Leetcode102b {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, TreeNode node, int lv) {
    if (node == null) {
      return;
    }
    if (ans.size() == lv) {  // means full, need more List
      ans.add(new LinkedList<>());
    }
    ans.get(lv).add(node.val);
    dfs(ans, node.left, lv + 1);
    dfs(ans, node.right,lv + 1);
  }
}
