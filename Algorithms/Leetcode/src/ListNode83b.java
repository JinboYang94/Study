/**
 * More straight-forward way.
 */

class ListNode83b {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    while (curr != null && curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
        // curr = curr.next; deleted, because will cause problem: only skip once
      } else {
        curr = curr.next;
      }
    }
    return head;
  }
}
