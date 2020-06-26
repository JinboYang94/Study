package AmazonTest;

import OA.AmazonOA2.Amazon17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For Amazon17 testing.
 */

class Amazon17Test {

  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 3, 1, 2, 4, 2));
    List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 6, 2));
    List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 3, 3, 2, 5));

    Amazon17 constructor = new Amazon17();
    System.out.println(constructor.saleDiscount(list1));
    System.out.println(constructor.saleDiscount(list2));
    System.out.println(constructor.saleDiscount(list3));
  }
}
