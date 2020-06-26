package LeetcodeProblems;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * <p>
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * </p>
 */

class Leetcode92 {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = head;
    int pos = 0;  // track fast pointer position
    ListNode mark1 = null;  // mark ListNode before m
    ListNode mark2 = null;  // mark ListNode at m

    while (slow != null) {
      pos++;
      if (pos == m) {
        mark1 = slow;
        mark2 = fast;
      }
      if (pos > m && pos <= n) {  // reverse when fast are within (m, n]
        ListNode temp = fast.next;
        fast.next = slow;
        slow = fast;
        fast = temp;
        continue;
      }
      if (pos == n + 1) { // link
        mark1.next = slow;
        mark2.next = fast;
        break;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return dummy.next;
  }
}
