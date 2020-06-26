package LeetcodeProblems;

import java.util.Stack;

/**
 * Using stack is more sufficient. Actually not enough sufficient, just 59 on 63ms.
 */

class Leetcode173b {

  private Stack<TreeNode> stack;

  public Leetcode173b(TreeNode root) {
    stack = new Stack<>();
    pushNodes(root);
  }

  public int next() {
    TreeNode temp = stack.pop();
    if (temp.right != null) {
      pushNodes(temp.right);
    }
    return temp.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void pushNodes(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
