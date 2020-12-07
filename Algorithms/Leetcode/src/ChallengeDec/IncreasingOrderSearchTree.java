package ChallengeDec;

import LeetcodeProblems.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {

  public TreeNode increasingBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    TreeNode newTree = new TreeNode(0);
    TreeNode iter = newTree;
    for (int i : list) {
      iter.right = new TreeNode(i);
      iter = iter.right;
    }
    return newTree.right;
  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }
}
