package ChallengeNov;

import LeetcodeProblems.TreeNode;
import java.util.HashMap;

public class HouseRobberIII {

  public static int rob(TreeNode root) {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    return helper(root, map);
  }

  private static int helper(TreeNode root, HashMap<TreeNode, Integer> memo) {
    if (root == null) return 0;
    if (memo.containsKey(root)) return memo.get(root);
    int value = root.val;
    if (root.left != null) value += helper(root.left.left, memo) + helper(root.left.right, memo);
    if (root.right != null) value += helper(root.right.left, memo) + helper(root.right.right, memo);
    int res = Math.max(value, helper(root.left, memo) + helper(root.right, memo));
    System.out.println("rooted:" + root.val);
    System.out.println(res);
    memo.put(root, res);
    return res;
  }

  public static void main(String[] args) {
    TreeNode temp = createTree();
    System.out.println(rob(temp));
  }

  // build TreeNode
  static int index = 0;
  static String[] values = {"4", "1", "null", "2", "null", "3"};
  public static TreeNode createTree() {
    TreeNode node = null;
    if (index < values.length) {
      if (values[index].equals("null")) {
        index++;
        return null;
      }
      node = new TreeNode(Integer.parseInt(values[index]));
      index++;
      node.left = createTree();
      node.right = createTree();
    }
    return node;
  }
}
