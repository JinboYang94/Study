/**
 * Constant space complexity O(1) solution. Two pointer pre and curr, with one start to remember
 * the starting point of each level.
 */

class Leetcode116b {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Node pre = root;  // the one before current node
    Node curr = null; // current node
    Node start = pre; // node when each level starts
    while (pre.left != null) {
      // already the rightest node,
      if (curr == null) {
        pre.left.next = pre.right;  // point pre.left to pre.right
        // move pre and curr to next level, start is the starting point in this level
        pre = start.left;
        curr = start.right;
        start = pre;  // update start to next level
      } else {  // not yet to the end of this level
        pre.left.next = pre.right;
        pre.right.next = curr.left;
        pre = pre.next; // move pre to next
        curr = curr.next; // move curr to next (both are set in previous level!!!)
      }
    }
    return root;
  }
}
