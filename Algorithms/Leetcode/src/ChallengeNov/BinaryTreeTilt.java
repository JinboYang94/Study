package ChallengeNov;

import LeetcodeProblems.TreeNode;

public class BinaryTreeTilt {

  public int ret = 0;

  public int findTilt(TreeNode root) {
    postOrder(root);
    return ret;
  }

  private int postOrder(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = postOrder(root.left);
    int right = postOrder(root.right);
    ret += Math.abs(left - right);
    System.out.println(ret);
    return root.val + left + right;
  }
}
