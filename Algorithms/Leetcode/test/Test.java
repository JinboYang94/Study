import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

class Test {

  public static void main(String[] args) {

    int[] array = new int[10];
    for (int i = 0; i < 10; i++) {
      array[i] = i;
    }
    StdRandom.shuffle(array);

    System.out.println(Arrays.toString(array));
  }

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
