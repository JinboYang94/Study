package LeetcodeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 */

class Leetcode103b {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, TreeNode node, int lv) {
    if (node == null) {
      return;
    }
    if (lv == ans.size()) {
      ans.add(new LinkedList<>());
    }
    if (lv % 2 == 0) {
      ans.get(lv).add(node.val);
    } else {
      ans.get(lv).add(0, node.val);
    }
    dfs(ans, node.left, lv + 1);
    dfs(ans, node.right, lv + 1);
  }
}
