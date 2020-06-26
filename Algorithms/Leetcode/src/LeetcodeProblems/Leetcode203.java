package LeetcodeProblems;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * <p>
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * </p>
 */

class Leetcode203 {

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode temp = dummy;
    while (temp.next != null) {
      if (temp.next.val == val) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return dummy.next;
  }
}
