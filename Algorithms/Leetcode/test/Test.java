import LeetcodeProblems.ListNode;
import java.util.Arrays;

class Test {

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    ListNode b = a;
//    b.next = new LeetcodeProblems.ListNode(3);
//    System.out.println(a.next.val);
//    a.next = new LeetcodeProblems.ListNode(3);
//    System.out.println(b.next.val);
//    a = a.next;
//    System.out.println(b.val);
//    String s = "a b c";
//    System.out.println(s.indexOf(' '));
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
