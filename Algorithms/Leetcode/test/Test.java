import java.util.Arrays;
import java.util.LinkedList;

class Test {

  public static void main(String[] args) {
    Node c = new Node();
    c.val = 4;

    Node a = new Node();
    Node b = a;
    b.next = c;
    System.out.println(a.next.val);
  }

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
  public static int[][] deepCopy(int[][] original) {
    if (original == null) {
      return null;
    }

    final int[][] result = new int[original.length][];
    for (int i = 0; i < original.length; i++) {
      result[i] = Arrays.copyOf(original[i], original[i].length);
      // For Java versions prior to Java 6 use the next:
      // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
    }
    return result;
  }
}
