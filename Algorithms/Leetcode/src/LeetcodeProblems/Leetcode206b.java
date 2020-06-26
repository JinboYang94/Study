package LeetcodeProblems;

/**
 * Recursive solution.
 */

class Leetcode206b {

  public ListNode reverseList(ListNode head) {
    return helper(head, null);
  }

  private ListNode helper(ListNode curr, ListNode prev) {
    if (curr == null) {
      return prev;
    }
    ListNode temp = curr.next;
    curr.next = prev;
    return helper(temp, curr);
  }
}
