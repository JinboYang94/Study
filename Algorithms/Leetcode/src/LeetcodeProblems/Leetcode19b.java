package LeetcodeProblems;

/**
 * One pass solution. Probably not exactly one pass?
 */

class Leetcode19b {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // two pointer
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
}
