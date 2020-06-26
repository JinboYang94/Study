package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * </p>
 */

class Leetcode145 {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(ans, root);
    return ans;
  }

  private void helper(List<Integer> ans, TreeNode node) {
    if (node != null) {
      helper(ans, node.left);
      helper(ans, node.right);
      ans.add(node.val);
    }
  }
}
