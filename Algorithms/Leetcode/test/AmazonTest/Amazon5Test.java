package AmazonTest;

import OA.AmazonOA2.Amazon5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For testing OAProblems.AmazonOA2.Amazon5.
 */

class Amazon5Test {

  public static void main(String[] args) {
    List<Integer> packageSpace = new ArrayList<>(Arrays.asList(1, 10, 25, 35, 60));
    int truckSpace = 90;

    Amazon5 constructor = new Amazon5();
    System.out.println(constructor.assignTruck(truckSpace, packageSpace));
  }
}
