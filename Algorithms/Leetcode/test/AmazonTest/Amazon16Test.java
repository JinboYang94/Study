package AmazonTest;

import OA.AmazonOA2.Amazon16;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For Amazon16 testing.
 */

class Amazon16Test {

  public static void main(String[] args) {
    int numberOfOrders1 = 6;
    List<String> orders1 = new ArrayList<>(Arrays.asList(
        "Zid 93 12", "fp kindle book", "IOa echo show", "17g 12 256",
        "abl kindle book", "125 echo dot second generation"));

    Amazon16 constructor = new Amazon16();
    System.out.println(constructor.sortOrders(6, orders1));
  }
}
