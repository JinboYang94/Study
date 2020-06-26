package AmazonTest;

import OA.AmazonOA2.Amazon6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For OAProblems.AmazonOA2.Amazon6 testing.
 */

class Amazon6Test {

  public static void main(String[] args) {
    String text = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
    List<String> commonWords = new ArrayList<>(Arrays.asList("and", "he", "the", "to", "is", "Jack", "Jill"));

    Amazon6 constructor = new Amazon6();
    System.out.println(constructor.wordFilter(text, commonWords));
  }
}
