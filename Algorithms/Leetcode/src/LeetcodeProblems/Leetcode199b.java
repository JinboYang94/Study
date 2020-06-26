package LeetcodeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS solution.
 */

class Leetcode199b {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      ans.add(queue.peek().val);
      for (int i = 0; i < size; i++) {
        if (queue.peek().right != null) {
          queue.offer(queue.peek().right);
        }
        if (queue.peek().left != null) {
          queue.offer(queue.peek().left);
        }
        queue.poll();
      }
    }
    return ans;
  }
}
