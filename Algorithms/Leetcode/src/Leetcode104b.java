import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */

class Leetcode104b {

  public int maxDepth(TreeNode root) {
    int max = 0;
    Queue<TreeNode> node = new LinkedList<>();
    Queue<Integer> level = new LinkedList<>();
    node.offer(root);
    int lv = 1;
    level.offer(lv);

    if (root == null) {
      return 0;
    }
    while (!node.isEmpty()) {
      TreeNode curr = node.poll();
      int currLv = level.poll();
      if (curr != null) {
        node.offer(curr.left);
        level.offer(currLv + 1);
        node.offer(curr.right);
        level.offer(currLv + 1);
      }
      lv = currLv;
    }
    return lv - 1;
  }
}
