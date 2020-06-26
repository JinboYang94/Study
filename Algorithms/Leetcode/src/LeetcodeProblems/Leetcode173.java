package LeetcodeProblems;

import java.util.PriorityQueue;
import sun.reflect.generics.tree.Tree;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 * You may assume that next() call will always be valid, that is,
 * there will be at least a next smallest number in the BST when next() is called.
 *
 * <p>
 * Example:
 *       7
 *   3      15
 *        9   20
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * </p>
 */

class Leetcode173 {

  private PriorityQueue<TreeNode> queue;

  public Leetcode173(TreeNode root) {
    queue = new PriorityQueue<>((TreeNode o1, TreeNode o2) -> (o1.val - o2.val));
    push(root);
  }

  /**
   * Method: next.
   * @return the next smallest number.
   */
  public int next() {
    return queue.poll().val;
  }

  /**
   * Method: hasNext.
   * @return whether we have a next smallest number.
   */
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  private void push(TreeNode root) {
    if (root == null) {
      return;
    }
    push(root.left);
    queue.offer(root);
    push(root.right);
  }
}
