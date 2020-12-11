package ChallengeDec;

import LeetcodeProblems.TreeNode;
import java.util.ArrayList;

public class BinarySearchTreeIterator {

  // other solutions go to leetcode 173 and 173b, this one is intuitive
  // O(1) time O(h) space is 173b using PriorityQueue
  private int pointer;
  private ArrayList<Integer> res;

  public BinarySearchTreeIterator(TreeNode root) {
    res = new ArrayList<>();
    inOrder(root);
    this.pointer = - 1;
  }

  public int next() {
    return res.get(++pointer);
  }

  public boolean hasNext() {
    return pointer + 1 < res.size();
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    this.res.add(root.val);
    inOrder(root.right);
  }
}
