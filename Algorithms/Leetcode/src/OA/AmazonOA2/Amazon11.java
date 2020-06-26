package OA.AmazonOA2;

/**
 * Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
 * A subtree of a tree is the node which have at least 1 child plus all its descendants.
 * The average value of a subtree is the sum of its values, divided by the number of nodes.
 *
 * <p>
 * Example 1:
 * Input:
 *        20
 *      /   \
 *    12    18
 *  / | \  /  \
 * 11 2 3 15   8
 *
 * Output: 18
 * Explanation:
 * There are 3 nodes which have children in this tree:
 * 12 => (11 + 2 + 3 + 12) / 4 = 7
 * 18 => (18 + 15 + 8) / 3 = 13.67
 * 20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125
 *
 * 18 has the maximum average so output 18.
 * </p>
 */

public class Amazon11 {

  private double maxVal = Integer.MIN_VALUE;
  private TreeNodeAmazon ans = null;

  public TreeNodeAmazon maxAverageTree(TreeNodeAmazon head) {
    if (head == null) {
      return null;
    }
    helper(head);
    return ans;
  }

  private double[] helper(TreeNodeAmazon root) {
    // to the leaf
    if (root.children == null) {
      return new double[] {root.val, 1};
    }
    // total: all value, count: number of visited nodes
    double total = root.val;
    double count = 1;
    // recursively get from the bottom
    for (TreeNodeAmazon node : root.children) {
      double[] curr = helper(node);
      total += curr[0];
      count += curr[1];
    }
    double avg = total / count;
    // if at least 1 child && average larger, update
    if (count > 1 && avg > maxVal) {
      maxVal = avg;
      ans = root;
    }
    return new double[] {total, count};
  }
}
