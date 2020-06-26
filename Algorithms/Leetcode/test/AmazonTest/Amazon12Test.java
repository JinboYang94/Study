package AmazonTest;

import OA.AmazonOA2.Amazon12;
import java.util.ArrayList;
import java.util.List;

/**
 * For OAProblems.AmazonOA2.Amazon12 testing.
 */

class Amazon12Test {

  public static void main(String[] args) {
    List<Integer> state1 = new ArrayList<>();
    state1.add(1);
    state1.add(0);
    state1.add(0);
    state1.add(0);
    state1.add(0);
    state1.add(1);
    state1.add(0);
    state1.add(0);
    int days1 = 15;

    List<Integer> state2 = new ArrayList<>();
    state2.add(1);
    state2.add(1);
    state2.add(1);
    state2.add(0);
    state2.add(1);
    state2.add(1);
    state2.add(1);
    state2.add(1);
    int days2 = 2;

    Amazon12 constructor = new Amazon12();
    System.out.println(constructor.stateAfterDays(state1, days1));
    System.out.println(constructor.stateAfterDays(state2, days2));
  }
}
