package OA.AmazonOA2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Amazon is planning to release a new order prioritization algorithm to optimize fulfilling Prime
 * deliveries on time. All orders (Prime or otherwise) are given an alphanumeric ID code.
 * However, Prime orders are given additional metadata that consists of a space delimited list of
 * lowercase English letters, whereas non-Prime orders are given metadata that consists only Of
 * a space delimited string Of positive integers. Each order is therefore defined as their
 * alphanumeric id code, followed by a space, followed by their space delimited metadata.
 * You have been tasked with sorting a list of all orders in the order queue to assist in
 * prioritization of fulfillment. They should be sorted according to the following order:
 * 1. The Prime orders should be returned first,
 *    sorted by lexicographic sort of the alphabetic metadata.
 * 2. Only in the case of ties, the identifier should be used as a backup sort.
 * 3. The remaining non-Prime orders must all come after,
 *    in the original order they were given in the input. Write a function or method to sort
 *    the orders according to this system.
 * Input:
 * The input to the function/method consists of two arguments:
 * numOrders, an integer representing the number of orders.
 * order list, a list Of strings representing all Of the orders.
 * Output: Return a list of strings representing the correctly prioritized orders.
 * Note: The order identifier consists of only lower case English character and numbers.
 *
 * <p>
 * Example:
 * Input:
 * numOrders = 6
 * orderList:
 * [Zid 93 12]
 * [fp kindle book]
 * [IOa echo show]
 * [17g 12 256]
 * [abl kindle book]
 * [125 echo dot second generation]
 *
 * Output:
 * [125 echo dot second generation]
 * [IOa echo show]
 * [abl kindle book]
 * [fp kindle book]
 * [Zid 93 12]
 * [17g 12 256]
 *
 * Explanation:
 * There are four Prime orders (lines with words) in this order list.
 * Because "echo" comes before "kindle", those lines should come first,
 * with "dot" coming before "show". Because two lines have the metadata "kindle book",
 * their tie should be broken by the identifier, where "abl" comes before "fp".
 * Finally, the non-Prime numeric orders should come last, in the original order,
 * they were in the input.
 * </p>
 */

public class Amazon16 {

  public List<String> sortOrders(int numOfOrders, List<String> orders) {
    Comparator<String> newRule = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int space1 = s1.indexOf(" ");
        int space2 = s2.indexOf(" ");

        char ch1 = s1.charAt(space1 + 1);
        char ch2 = s2.charAt(space2 + 1);
        // s1 digits
        if (ch1 <= '9') {
          if (ch2 <= '9') { // s2 digits
            return 0;
          } else {  // s2 letters
            return 1;
          }
        }
        // s2 digits
        if (ch2 <= '9') {
          return -1;
        }
        // s1 letters, s2 letters
        String str1 = s1.substring(space1 + 1);
        String str2 = s2.substring(space2 + 1);
        int res = str1.compareTo(str2);
        if (res == 0) {
          return s1.substring(0, space1).compareTo(s2.substring(0, space2));
        }
        return res;
      }
    };

    orders.sort(newRule);
    return orders;
  }
}
