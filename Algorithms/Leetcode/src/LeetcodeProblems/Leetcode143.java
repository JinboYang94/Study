package LeetcodeProblems;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * <p>
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * </p>
 */

class Leetcode143 {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode slow = head;
    ListNode fast = head;
    // find mid place
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse right part
    ListNode pre = slow;  // left part last node, not moving
    ListNode curr = slow.next;
    while (curr.next != null) {
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = pre.next;
      pre.next = temp;
    }
    // link
    fast = pre.next;
    slow.next = null; // split into two parts
    slow = head;
    while (fast != null) {
      ListNode temp = slow.next;
      ListNode temp2 = fast.next;
      fast.next = slow.next;
      slow.next = fast;
      slow = temp;
      fast = temp2;
    }
  }
}
