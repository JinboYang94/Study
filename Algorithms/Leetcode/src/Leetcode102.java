import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree,
 * return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Tag: BFS
 */

class Leetcode102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
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
      // pull current TreeNode and level
      TreeNode curr = node.poll();  // cannot use remove
      int currLv = level.poll();
      if (curr != null) {
        if (ans.size() <= currLv) {
          ans.add(currLv, new ArrayList<>());
        }
        ans.get(currLv).add(curr.val);
        lv = currLv + 1;
        // push queue
        node.offer(curr.left);
        level.offer(lv);
        node.offer(curr.right);
        level.offer(lv);
      }
    }
    return ans;
  }
}
