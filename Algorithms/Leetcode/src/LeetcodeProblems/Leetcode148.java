package LeetcodeProblems;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * <p>
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * </p>
 */

class Leetcode148 {

  public ListNode sortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int count = 0;
    // get list length
    while (head != null) {
      head = head.next;
      count++;
    }
    // from bottom, from size 1 to 2^k, each loop from head split list into 1, 2, 4...2^k segments,
    // and merge each two 1, 2, 4...2^k size adjacent segments
    for (int size = 1; size < count; size *= 2) {
      ListNode pre = dummy;
      ListNode curr = dummy.next;
      while (curr != null) {
        ListNode leftPart = curr; // left part's head
        ListNode rightPart = split(leftPart, size); // right part's head
        curr = split(rightPart, size);
        pre = merge(leftPart, rightPart, pre);
      }
    }
    return dummy.next;
  }

  // divide the list into two parts, the first contains first size nodes, return the second's head
  private ListNode split(ListNode head, int size) {
    if (head == null) {
      return null;
    }
    for (int i = 1; head.next != null && i < size; i++) {
      head = head.next;
    }
    ListNode right = head.next;
    head.next = null; // cut off list
    return right;
  }

  private ListNode merge(ListNode left, ListNode right, ListNode mergedRes) {
    // mergedRes means previous merged result
    ListNode curr = mergedRes;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }
    // handle the lonely node
    if (left != null) {
      curr.next = left;
    }
    if (right != null) {
      curr.next = right;
    }
    // move pointer curr to the end of merged result and return
    while (curr.next != null) {
      curr = curr.next;
    }
    return curr;
  }
}
