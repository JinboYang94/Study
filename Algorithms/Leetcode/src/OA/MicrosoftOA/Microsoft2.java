package OA.MicrosoftOA;

import LeetcodeProblems.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// leetcode 94
public class Microsoft2 {

  // recursive
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    helper(root, ret);
    return ret;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    helper(root.left, list);
    list.add(root.val);
    helper(root.right, list);
  }

  // follow-up: using stack
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      ret.add(root.val);
      root = root.right;
    }
    return ret;
  }
}
