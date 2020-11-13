package ChallengeNov;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    // bfs
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node temp = queue.poll();
        if (i < size - 1) {
          temp.next = queue.peek();
        } else {
          temp.next = null;
        }
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
    }
    return root;
  }
}

// recursive method
class PopulatingNextRightPointersInEachNode2 {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    root.next = null;
    helper(root);
    return root;
  }

  private void helper(Node root) {
    if (root.left == null) {
      return;
    }
    root.left.next = root.right;
    if (root.next != null) {
      root.right.next = root.next.left;
    }
    helper(root.left);
    helper(root.right);
  }
}

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};