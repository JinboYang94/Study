package ChallengeDec;

import LeetcodeProblems.TreeNode;

public class MaximumDepthOfBinaryTree {

  int max = 0;
  public int maxDepth(TreeNode root) {
    dfs(root, 0);
    return max;
  }

  private void dfs(TreeNode root, int count) {
    if (root == null) {
      return;
    }
    max = Math.max(max, count + 1);
    if (root.left != null) {
      dfs(root.left, count + 1);
    }
    if (root.right != null) {
      dfs(root.right, count + 1);
    }
  }
}
