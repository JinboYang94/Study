package LeetcodeProblems;

/**
 * Reverse a singly linked list.
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * Tag: iterative solution.
 *
 * <p>
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * </p>
 */

class Leetcode206 {

  public ListNode reverseList(ListNode head) {
    ListNode dummy = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = dummy;
      dummy = head;
      head = temp;
    }
    return dummy;
  }
}
