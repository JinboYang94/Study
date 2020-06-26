package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

class Leetcode105 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(preorder, inorder, 0, preorder.length - 1, 0,
        inorder.length - 1, map);
  }

  private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
      int inEnd, Map<Integer, Integer> map) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]); // root place
    int inRoot = map.get(root.val); // find root position in inorder traversal
    int numsLeft = inRoot - inStart;  // number of elements in left part

    root.left = helper(preorder, inorder, preStart + 1, preStart + numsLeft,
        inStart, inRoot - 1, map);
    root.right = helper(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1,
        inEnd, map);
    return root;
  }
}
