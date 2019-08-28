import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * <p>
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * </p>
 */

class Leetcode94 {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(ans, root);
    return ans;
  }

  private void helper(List<Integer> ans, TreeNode node) {
    if (node == null) {
      return;
    }
    helper(ans, node.left); // first loop left nodes
    ans.add(node.val);  // add all first
    helper(ans, node.right);  // then right
  }
}
