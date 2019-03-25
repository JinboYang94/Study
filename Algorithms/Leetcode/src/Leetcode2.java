/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list. You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * <p>
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 * </p>
 */

class Leetcode2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;     // output ListNode
    int carry = 0;

    while (l1 != null || l2 != null) {
      int a = (l1 == null) ? 0 : l1.val;
      int b = (l2 == null) ? 0 : l2.val;

      int sum = a + b + carry;
      carry = sum / 10;
      cur.next = new ListNode(sum % 10);    // update output ListNode
      cur = cur.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      if (carry != 0) { // if the last Node > 10, that give it a carry
        cur.next = new ListNode(1);
      }
    }

    return dummy.next;
  }
}

