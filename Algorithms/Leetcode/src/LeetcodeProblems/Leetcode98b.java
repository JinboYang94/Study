package LeetcodeProblems;

/**
 * Another recursive method.
 */

class Leetcode98b {

  public boolean isValidBST(TreeNode root) {
    return checkValid(root, null, null);
  }

  private boolean checkValid(TreeNode node, Integer max, Integer min) {
    if (node == null) {
      return true;
    }
    if (max != null && node.val >= max) {
      return false;
    }
    if (min != null && node.val <= min) {
      return false;
    }
    return checkValid(node.left, node.val, min) && checkValid(node.right, max, node.val);
  }
}
