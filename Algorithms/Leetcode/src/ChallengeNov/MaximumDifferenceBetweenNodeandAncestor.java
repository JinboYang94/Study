package ChallengeNov;

import LeetcodeProblems.TreeNode;

// Leetcode 1026
public class MaximumDifferenceBetweenNodeandAncestor {

  public int ret = 0;
  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helper(root, root.val, root.val);
    return ret;
  }

  // dfs
  private void helper(TreeNode root, int max, int min) {
    if (root == null) {
      return;
    }
    max = Math.max(max, root.val);
    min = Math.min(min, root.val);
    if (root.left == null && root.right == null) {
      ret = Math.max(ret, Math.abs(max - min));
    }
    helper(root.left, max, min);
    helper(root.right, max, min);
  }
}
