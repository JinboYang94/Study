package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * <p>
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </p>
 */

class Leetcode109 {

  public TreeNode sortedListToBST(ListNode head) {
    List<Integer> valMap = listNodeVal(head);
    return helper(valMap, 0, valMap.size() - 1);
  }

  private List<Integer> listNodeVal(ListNode head) {
    List<Integer> value = new ArrayList<>();
    while (head != null) {
      value.add(head.val);
      head = head.next;
    }
    return value;
  }

  private TreeNode helper(List<Integer> map, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(map.get(mid));
    root.left = helper(map, start, mid - 1);
    root.right = helper(map, mid + 1, end);
    return root;
  }
}
