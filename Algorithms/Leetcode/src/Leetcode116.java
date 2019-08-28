import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Tag: BFS, but not constant extra space O(1), it is O(n).
 *
 * <p>
 * Example:
 *        1                            1----> null
 *    2       3                    2------>3----> null
 *  4  5    6  7               4---->5-->6--->7---->null
 *   Figure A
 * Input: {"$id":"1","left":{"$id":"2","left":
 * {"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":
 * {"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":
 * {"$id":"5","left":
 * {"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":
 * {"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * Output: {"$id":"1","left":{"$id":"2","left":
 * {"$id":"3","left":null,"next":
 * {"$id":"4","left":null,"next":
 * {"$id":"5","left":null,"next":
 * {"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},
 *        "right":null,"val":5},"right":null,"val":4},"next":
 * {"$id":"7","left":{"$ref":"5"},"next":null,"right":
 * {"$ref":"6"},"val":3},"right":
 * {"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node,
 * just like in Figure B.
 * </p>
 */

class Leetcode116 {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> node = new LinkedList<>();
    Queue<Integer> level = new LinkedList<>();
    node.offer(root);
    level.offer(0);

    while (!node.isEmpty()) {
      Node curr = node.poll();
      int lv = level.poll();
      if (curr != null) {
        if (!node.isEmpty() && !level.isEmpty()) {  // if more nodes in queue, means not root
          int lv2 = level.peek();
          if (lv2 == lv) {  // if this one is same level with curr, then must be its right node
            Node temp = node.peek();
            curr.next = temp;
          } else {  // not same level, then must be the rightest node
            curr.next = null;
          }
        }
        node.offer(curr.left);  // first push left
        level.offer(lv + 1);
        node.offer(curr.right);
        level.offer(lv + 1);
      }
    }

    return root;
  }
}
