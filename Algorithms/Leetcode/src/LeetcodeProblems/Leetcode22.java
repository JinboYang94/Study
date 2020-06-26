package LeetcodeProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * <p>
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * </p>
 */

class Leetcode22 {

  public ListNode mergeKLists(ListNode[] lists) {
    // override
    Comparator<ListNode> comp = new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val) {
          return -1;
        } else if (o1.val > o2.val) {
          return 1;
        } else {
          return 0;
        }
      }
    };
    // push all into queue
    PriorityQueue<ListNode> queue = new PriorityQueue<>(comp);
    // push all into queue
    for (ListNode node : lists) {
      while (node != null) {
        queue.offer(node);
        node = node.next;
      }
    }
    // get out
    ListNode dummy = new ListNode(0);
    ListNode ans = dummy;
    while (!queue.isEmpty()) {
      dummy.next = queue.poll();
      dummy = dummy.next;
    }
    dummy.next = null;
    return ans.next;
  }
}
