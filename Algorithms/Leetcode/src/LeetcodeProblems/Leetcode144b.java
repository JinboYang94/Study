package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Iterative solution. Stack FIFO.
 */

class Leetcode144b {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      if (curr != null) {
        ans.add(curr.val);
      }
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
    return ans;
  }
}
