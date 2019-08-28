import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS.
 */

class Leetcode111b {

  public int minDepth(TreeNode root) {
    Queue<TreeNode> node = new LinkedList<>();
    Queue<Integer> level = new LinkedList<>();
    node.offer(root);
    level.offer(0);

    while (!node.isEmpty()) {
      TreeNode curr = node.poll();
      int lv = level.poll();
      if (curr != null) {
        if (curr.left == null && curr.right == null) {  // leaf
          return lv + 1;
        }
        if (curr.left != null) {
          node.offer(curr.left);
          level.offer(lv + 1);
        }
        if (curr.right != null) {
          node.offer(curr.right);
          level.offer(lv + 1);
        }
      }
    }
    return 0; // root == null
  }
}
