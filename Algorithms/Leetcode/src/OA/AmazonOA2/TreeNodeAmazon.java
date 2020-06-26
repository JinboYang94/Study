package OA.AmazonOA2;

import java.util.List;

public class TreeNodeAmazon {
  public int val;
  public List<TreeNodeAmazon> children;
  public TreeNodeAmazon() {}
  public TreeNodeAmazon(int _val, List<TreeNodeAmazon> _children) {
    val = _val;
    children = _children;
  }
}