package LeetcodeProblems;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node
 * down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Tag: recursive DFS
 *
 * <p>
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </p>
 */

class Leetcode111 {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {  // leaf on right branch
      return minDepth(root.right) + 1;
    }
    if (root.right == null) { // leaf on left branch
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
