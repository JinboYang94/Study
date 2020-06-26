package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * <p>
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </p>
 */

class Leetcode113 {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, new ArrayList<>(), root, sum);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, List<Integer> temp, TreeNode root, int sum) {
    if (root == null) {
      return;
    } else if (root.left == null && root.right == null && sum == root.val) {
      temp.add(root.val);
      ans.add(new ArrayList<>(temp));
    } else {
      temp.add(root.val);
      backtrack(ans, temp, root.left, sum - root.val);
      backtrack(ans, temp, root.right, sum - root.val);
    }
    temp.remove(temp.size() - 1);
  }
}
