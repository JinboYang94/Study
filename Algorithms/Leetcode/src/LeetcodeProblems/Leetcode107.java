package LeetcodeProblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * Tag: BFS
 */

class Leetcode107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    Queue<TreeNode> node = new LinkedList<>();
    Queue<Integer> level = new LinkedList<>();
    node.offer(root);
    level.offer(0);

    while (!node.isEmpty()) {
      TreeNode curr = node.poll();
      int lv = level.poll();
      if (curr != null) {
        if (lv == ans.size()) {
          ans.add(0, new LinkedList<>()); // each add to first position
        }
        ans.get(0).add(curr.val); // get head
        node.offer(curr.left);
        level.offer(lv + 1);
        node.offer(curr.right);
        level.offer(lv + 1);
      }
    }
    return ans;
  }
}
