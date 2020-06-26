package LeetcodeProblems;

/**
 * Given a complete binary tree, count the number of nodes.
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * <p>
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 * </p>
 */

public class Leetcode222 {

  public int countNodes(TreeNode root) {
    int ct = 0;
    // get total height of the tree (ignore incomplete), starting from 0 level
    int height = height(root);
    while (root != null) {
      // if right side is complete, take all the left side tree which is (2^height-1) and root
      // node which is 1 and all right side tree which is recursively as set root to right;
      // height of right side is just height of root - 1: means left height == right height;
      if (height(root.right) == height - 1) {
        ct += 1 << height;
        root = root.right;
      } else {
        // if incomplete, take all the right side tree which is (2^(height-1)-1) and root node which
        // is 1 and all left side tree which is recursively as set root to left;
        ct += 1 << (height - 1);
        root = root.left;
      }
      height--;
    }
    return ct;
  }

  private int height(TreeNode node) {
    return node == null ? -1 : 1 + height(node.left);
  }
}
