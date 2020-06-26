package LeetcodeProblems;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * <p>
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * </p>
 */

class Leetcode112 {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    }
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}
