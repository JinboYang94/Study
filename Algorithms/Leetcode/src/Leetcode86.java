/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * <p>
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * </p>
 */

class Leetcode86 {

  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(0); // save part 1 (< x)
    ListNode dummy2 = new ListNode(0);  // save part 2 (>= x)
    ListNode dummy3 = new ListNode(0);  // refer to dummy
    ListNode dummy4 = new ListNode(0);  // refer to dummy2
    ListNode curr = head;
    dummy3.next = dummy;
    dummy4.next = dummy2;

    while (curr != null) {
      if (curr.val < x) {
        dummy.next = curr;
        dummy = curr;
        curr = curr.next;
      } else {
        dummy2.next = curr;
        dummy2 = curr;
        curr = curr.next;
      }
    }
    dummy2.next = null; // important, to terminate the list!!! or list is broken
    dummy.next = dummy4.next.next;  // merge two lists
    return dummy3.next.next;
  }
}
