package LeetcodeProblems;

/**
 * fast and low pointer to find mid value in ListNode.
 */

class Leetcode109b {

  public TreeNode sortedListToBST(ListNode head) {
    return helper(head, null);
  }

  private TreeNode helper(ListNode start, ListNode end) {
    if (start == end) {
      return null;
    }
    ListNode slow = start;
    ListNode fast = start;
    while (fast != end && fast.next != end) { //  slow fast find mid
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = helper(start, slow);
    root.right = helper(slow.next, end);
    return root;
  }
}
