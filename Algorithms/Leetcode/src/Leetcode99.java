import org.jetbrains.annotations.Contract;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * <p>
 * Example:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * </p>
 */

class Leetcode99 {

  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode max = getMax(root.left);
    TreeNode min = getMin(root.right);
    // left <-> right
    if (min != null && max != null) {
      if (root.val < max.val && root.val > min.val) {
        int temp = max.val;
        max.val = min.val;
        min.val = temp;
      }
    }
    // root <-> left
    if (max != null) {
      if (root.val < max.val) {
        int temp = max.val;
        max.val = root.val;
        root.val = temp;
      }
    }
    // root <-> right
    if (min != null) {
      if (root.val > min.val) {
        int temp = min.val;
        min.val = root.val;
        root.val = temp;
      }
    }
    // left <-> left
    recoverTree(root.left);
    // right <-> right
    recoverTree(root.right);
  }

  private TreeNode getMax(TreeNode node) {
    if (node == null) {
      return null;
    }
    TreeNode max = node;
    TreeNode maxL = getMax(node.left);
    TreeNode maxR = getMax(node.right);
    if (maxL != null && maxL.val > max.val) {
      max = maxL;
    }
    if (maxR != null && maxR.val > max.val) {
      max = maxR;
    }
    return max;
  }

  private TreeNode getMin(TreeNode node) {
    if (node == null) {
      return null;
    }
    TreeNode min = node;
    TreeNode minL = getMin(node.left);
    TreeNode minR = getMin(node.right);
    if (minL != null && minL.val < min.val) {
      min = minL;
    }
    if (minR != null && minR.val < min.val) {
      min = minR;
    }
    return min;
  }
}
