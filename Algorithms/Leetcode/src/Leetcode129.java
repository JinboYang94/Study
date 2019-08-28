import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree containing digits from 0-9 only,
 * each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * <p>
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * </p>
 */

class Leetcode129 {

  public int sumNumbers(TreeNode root) {
    return getValue(root, 0);
  }

  private int getValue(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    // leaf
    if (root.left == null && root.right == null) {
      return sum * 10 + root.val;
    }
    // each time to next level, sum * 10 + current root.val
    return getValue(root.left, 10 * sum + root.val) + getValue(root.right, 10 * sum + root.val);
  }
}
