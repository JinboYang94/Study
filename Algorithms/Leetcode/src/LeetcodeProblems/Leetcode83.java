package LeetcodeProblems;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * <p>
 * Example:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * </p>
 */

class Leetcode83 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode curr = head;
    ListNode dummy2 = new ListNode(0);
    dummy2.next = dummy;
    dummy.next = head;

    while (curr != null) {
      if (curr.next != null && curr.val == curr.next.val) {
        while (curr.next != null && curr.val == curr.next.val) {
          curr = curr.next;
        }
        dummy.next = curr;  // do not skip all, save only one node
        dummy = curr; // this is for adding this qualified node into final answer (***)
      } else {
        dummy = curr;
      }
      curr = curr.next;
    }
    return dummy2.next.next;
  }
}
