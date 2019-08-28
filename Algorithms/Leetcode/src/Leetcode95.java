import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n,
 * generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * <p>
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </p>
 */

class Leetcode95 {

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return helper(1, n);
  }

  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> ans = new ArrayList<>();
    if (start > end) {
      ans.add(null);
      return ans;
    }
    // i as root, recursively divide into two parts until reach null statement
    for (int i = start; i <= end; i++) {
      List<TreeNode> left = helper(start, i - 1);
      List<TreeNode> right = helper(i + 1, end);
      // splice the left and right trees with root i, all combinations
      for (TreeNode leftNode : left) {
        for (TreeNode rightNode : right) {
          TreeNode root = new TreeNode(i);
          root.left = leftNode;
          root.right = rightNode;
          ans.add(root);
        }
      }
    }
    return ans;
  }
}
