/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * <p>
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * </p>
 */

class Leetcode61 {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int len = 0;
    while (dummy.next != null) {
      len++;
      dummy = dummy.next;
    }
    // when break, dummy at the end of the LinkedList, point it from null to head for linking
    // now it locates at 5, so link 5 to 1 to make a LinkedList.
    dummy.next = head;

    k = k % len;
    // now because we move k right, we need to find the head point to what: the head should point to
    // the kth(counted from end), so it would be len - k from begin.
    for (int i = 0; i < len - k; i++) {
      dummy = dummy.next;
    }
    // here dummy just at the node before break, give an example:
    // 1 -> 2 -> 3 -> 4 -> 5 -> null, k = 2 turns to 4 -> 5 -> 1 -> 2 -> 3 -> null
    // we want to find 4, so now the dummy goes to 3, set the head.next to 3, and set 3.next to null
    head = dummy.next;
    dummy.next = null;

    return head;
  }
}
