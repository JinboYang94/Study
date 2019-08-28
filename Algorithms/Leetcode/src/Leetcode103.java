import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree,
 * return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * Tag: BFS
 */

class Leetcode103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> node = new LinkedList<>();
    Queue<Integer> level = new LinkedList<>();
    node.offer(root);
    int lv = 0;
    level.offer(lv);

    if (root == null) {
      return ans;
    }
    while (!node.isEmpty()) {
      TreeNode curr = node.poll();
      int currLevel = level.poll();
      if (curr != null) {
        if (currLevel == ans.size()) {
          ans.add(currLevel, new LinkedList<>());
        }
        if (currLevel % 2 == 0) {
          ans.get(currLevel).add(curr.val);
        } else {
          ans.get(currLevel).add(0, curr.val);
        }
        node.offer(curr.left);
        level.offer(currLevel + 1);
        node.offer(curr.right);
        level.offer(currLevel + 1);
      }
    }
    return ans;
  }
}
