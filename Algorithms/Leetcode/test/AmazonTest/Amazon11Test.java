package AmazonTest;

import OA.AmazonOA2.Amazon11;
import OA.AmazonOA2.TreeNodeAmazon;
import java.util.ArrayList;
import java.util.List;

/**
 * For OAProblems.AmazonOA2.Amazon11 testing.
 */

class Amazon11Test {

  public static void main(String[] args) {
    TreeNodeAmazon node1 = new TreeNodeAmazon(11, null);
    TreeNodeAmazon node2 = new TreeNodeAmazon(2, null);
    TreeNodeAmazon node3 = new TreeNodeAmazon(3, null);
    TreeNodeAmazon node4 = new TreeNodeAmazon(15, null);
    TreeNodeAmazon node5 = new TreeNodeAmazon(8, null);

    List<TreeNodeAmazon> children6 = new ArrayList<>();
    children6.add(node1);
    children6.add(node2);
    children6.add(node3);
    TreeNodeAmazon node6 = new TreeNodeAmazon(12, children6);
    List<TreeNodeAmazon> children7 = new ArrayList<>();
    children7.add(node4);
    children7.add(node5);
    TreeNodeAmazon node7 = new TreeNodeAmazon(18, children7);

    List<TreeNodeAmazon> children8 = new ArrayList<>();
    children8.add(node6);
    children8.add(node7);
    TreeNodeAmazon head = new TreeNodeAmazon(20, children8);

    Amazon11 constructor = new Amazon11();
    System.out.println(constructor.maxAverageTree(head).val);
  }
}
