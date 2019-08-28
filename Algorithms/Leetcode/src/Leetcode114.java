/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

class Leetcode114 {

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);

    TreeNode temp = root.right;
    root.right = root.left;
    root.left = null; // don't forget
    while (root.right != null) {
      root = root.right;
    }
    root.right = temp;
  }
}
