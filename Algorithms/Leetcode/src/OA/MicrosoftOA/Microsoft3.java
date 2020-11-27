package OA.MicrosoftOA;

import LeetcodeProblems.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Microsoft3 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    dfs(root, map);
    return helper(p, q, map);
  }

  private void dfs(TreeNode root, HashMap<Integer, TreeNode> map) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      map.put(root.left.val, root);
      dfs(root.left, map);
    }
    if (root.right != null) {
      map.put(root.right.val, root);
      dfs(root.right, map);
    }
  }

  private TreeNode helper(TreeNode p, TreeNode q, HashMap<Integer, TreeNode> map) {
    Set<Integer> visitedP = new HashSet<>();
    while (p != null) {
      visitedP.add(p.val);
      p = map.get(p.val);
    }
    while (q != null) {
      if (visitedP.contains(q.val)) {
        return q;
      }
      q = map.get(q.val);
    }
    return null;
  }
}
