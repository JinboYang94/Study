package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * </p>
 */

class Leetcode144 {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(root, ans);
    return ans;
  }

  private void helper(TreeNode node, List<Integer> ans) {
    if (node != null) {
      ans.add(node.val);
      helper(node.left, ans);
      helper(node.right, ans);
    }
  }
}
