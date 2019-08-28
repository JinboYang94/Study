/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same
 * if they are structurally identical and the nodes have the same value.
 *
 * <p>
 * Example:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 * </p>
 */

class Leetcode100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    }  else {
      if (p.val != q.val) {
        return false;
      }
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
