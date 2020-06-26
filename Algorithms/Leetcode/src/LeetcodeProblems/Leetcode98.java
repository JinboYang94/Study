package LeetcodeProblems;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * <p>
 * Example:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * </p>
 */

class Leetcode98 {

  public boolean isValidBST(TreeNode root) {
    return checkValid(root);
  }

  private boolean checkValid(TreeNode node) {
    if (node == null) {
      return true;
    }
    if (checkValid(node.left)) {
      if (node.left != null) {
        int max = getMax(node.left);
        if (node.val <= max) {
          return false;
        }
      }
    } else {
      return false;
    }
    if (checkValid(node.right)) {
      if (node.right != null) {
        int min = getMin(node.right);
        if (node.val >= min) {
          return false;
        }
      }
    } else {
      return false;
    }
    return true;
  }

  private int getMin(TreeNode node) {
    int min = node.val;
    while (node != null) {
      if (node.val < min) {
        min = node.val;
      } else {
        if (node.left != null) {
          node = node.left;
        } else {
          node = node.right;
        }
      }
    }
    return min;
  }

  private int getMax(TreeNode node) {
    int max = node.val;
    while (node != null) {
      if (node.val > max) {
        max = node.val;
      } else {
        if (node.right != null) {
          node = node.right;
        } else {
          node = node.left;
        }
      }
    }
    return max;
  }
}
