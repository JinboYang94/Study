/**
 * Constant extra space O(1) solutions.
 */

class Leetcode117b {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Node curr = root; // track current node
    Node dummyHead = new Node();  // mark start point of each level
    Node pointer = dummyHead;  // track left to right process, loop though

    while (curr != null) {
      if (curr.left != null) {
        // when set pointer.next, because pointer = dummyHead, we get dummyHead.next also set as:
        // dummyHead.next = curr.left;
        pointer.next = curr.left;
        pointer = pointer.next;
      }
      if (curr.right != null) {
        pointer.next = curr.right;
        pointer = pointer.next;
      }
      if (curr.next != null) {
        curr = curr.next;
      } else {  // move to next level
        curr = dummyHead.next;
        dummyHead.next = null;  // reset dummyHead as a new Node()
        pointer = dummyHead; // same as initialization
      }
    }
    return root;
  }
}
