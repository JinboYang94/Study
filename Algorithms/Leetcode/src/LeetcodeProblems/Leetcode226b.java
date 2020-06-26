package LeetcodeProblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Using stack (iterative).
 */

public class Leetcode226b {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      TreeNode left = temp.left;
      temp.left = temp.right;
      temp.right = left;

      if (temp.left != null) {
        stack.push(temp.left);
      }
      if (temp.right != null) {
        stack.push(temp.right);
      }
    }
    return root;
  }
}
