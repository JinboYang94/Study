import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 */

class Leetcode107b {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, TreeNode node, int lv) {
    if (node == null) {
      return;
    }
    if (lv == ans.size()) {
      ans.add(0, new LinkedList<>());
    }
    ans.get(ans.size() - 1 - lv).add(node.val); // get corresponding index
    dfs(ans, node.left, lv + 1);
    dfs(ans, node.right, lv + 1);
  }
}
