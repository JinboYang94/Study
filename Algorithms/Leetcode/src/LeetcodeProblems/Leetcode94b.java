package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Use iterative method.
 */

class Leetcode94b {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      // keep push until left nodes exhaust
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      // left exhausted, inorder traversal now save the current node
      curr = stack.pop();
      ans.add(curr.val);
      // turns to right nodes
      curr = curr.right;
    }
    return ans;
  }
}
