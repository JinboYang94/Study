package LeetcodeProblems;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

public class Leetcode234 {

  public boolean isPalindrome(ListNode head) {
    int len = 0;
    ListNode dummy = head;
    while (dummy != null) {
      dummy = dummy.next;
      len++;
    }
    ListNode dummy2 = head;
    for (int i = 0; i < (int) Math.ceil(len / 2.0); i++) {
      dummy2 = dummy2.next;
    }
    ListNode secondHalf = reverse(dummy2);
    // judge
    ListNode n1 = head;
    ListNode n2 = secondHalf;
    for (int i = 0; i < len / 2; i++) {
      if (n1.val == n2.val) {
        n1 = n1.next;
        n2 = n2.next;
      } else {
        return false;
      }
    }
    // should restore list, but not necessary here
    return true;
  }

  public ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode curr = node;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }
}
