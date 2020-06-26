package AmazonTest;

import OA.AmazonOA2.Amazon4;
import java.util.Arrays;

/**
 * For OAProblems.AmazonOA2.Amazon4 testing.
 */

class Amazon4Test {

  public static void main(String[] args) {
    int[][] postOffices = {{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
    int k = 3;
    int[] you = {0, 0};

    Amazon4 constructor = new Amazon4();
    System.out.println(Arrays.deepToString(constructor.findOffice(postOffices, k, you)));
  }
}
