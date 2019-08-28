import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

class Leetcode106 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(inorder, postorder, 0, inorder.length - 1, 0,
        postorder.length - 1, map);
  }

  private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,
      int postEnd, Map<Integer, Integer> map) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postEnd]);
    int inRoot = map.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = helper(inorder, postorder, inStart, inRoot - 1, postStart,
        postStart + numsLeft - 1, map);
    root.right = helper(inorder, postorder, inRoot + 1, inEnd,
        postStart + numsLeft, postEnd - 1, map);
    return root;
  }
}
