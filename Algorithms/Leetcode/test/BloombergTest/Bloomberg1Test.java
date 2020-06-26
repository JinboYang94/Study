package BloombergTest;

import OA.BloombergLP.Bloomberg1;

public class Bloomberg1Test {

  public static void main(String[] args) {
    int[][] cost1 = {{500, 600}, {600, 400}, {200, 900}, {700, 300}};

    Bloomberg1 constructor = new Bloomberg1();
    System.out.println(constructor.minCost(cost1));
  }
}
