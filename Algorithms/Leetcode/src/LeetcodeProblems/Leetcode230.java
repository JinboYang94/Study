package LeetcodeProblems;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */

import java.util.List;
import java.util.ArrayList;

public class Leetcode230 {

  // bts's inorder traversal will return ascending order, then get kth smallest.
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> sorted = new ArrayList<>();
    inOrder(root, sorted);
    return sorted.get(k - 1);
  }

  // inorder dfs
  public void inOrder(TreeNode root, List<Integer> sorted) {
    if (root == null) {
      return;
    }
    inOrder(root.left, sorted);
    sorted.add(root.val);
    inOrder(root.right, sorted);
  }
}
