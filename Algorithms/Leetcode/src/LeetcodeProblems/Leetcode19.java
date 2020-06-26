package LeetcodeProblems;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 *
 * <p>
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * </p>
 */

class Leetcode19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int len = 0;

    while (head != null) {
      head = head.next;
      len++;
    }
    int pos = len - n;
    head = dummy;
    while (pos > 0) {
      head = head.next;
      pos--;
    }
    head.next = head.next.next;
    return dummy.next;
  }
}
