package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Iterative solution.
 */

class Leetcode145b {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode currTop = root;
    TreeNode lastVisited = root;
    //
    while (currTop != null || !stack.isEmpty()) {
      // find left branch until end, push each nodes into stack
      while (currTop != null) {
        stack.push(currTop);
        currTop = currTop.left;
      }
      // check current top node in the stack
      currTop = stack.peek();
      // if no right branch || already visited
      if (currTop.right == null || currTop.right == lastVisited) {
        ans.add(currTop.val);
        stack.pop();
        lastVisited = currTop;
        currTop = null; // remember to clear, avoid get into while loop again
      } else {
        // get right branch
        currTop = currTop.right;
      }
    }
    return ans;
  }
}
