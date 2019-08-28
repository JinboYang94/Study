/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to
 * any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * <p>
 * Example:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * </p>
 */

class Leetcode124 {

  // is the value which recording whether this current root is the final root
  int maxValue = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    helper(root);
    return maxValue;
  }

  private int helper(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = Math.max(helper(node.left), 0);
    int right = Math.max(helper(node.right), 0);
    // consider about the max path including current root, update if current one is the highest node
    maxValue = Math.max(maxValue, node.val + left + right);
    // but only return max path including current root and max of left and right
    return node.val + Math.max(left, right);
  }
}
