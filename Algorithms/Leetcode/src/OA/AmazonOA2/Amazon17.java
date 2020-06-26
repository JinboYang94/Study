package OA.AmazonOA2;

import java.util.List;

/**
 * A shopkeeper has a sale to complete and has arranged the items being sold in a list.
 * Starting from the left, the shop keeper rings up each item at its full price less the price of
 * the first lower or equally priced item to its right.
 * If there is no item to the right that costs less than or equal to the current item's price,
 * the current item is sold at full price.
 * Note: here only return total cost.
 *
 * <p>
 * Example 1:
 * Input: [2, 3, 1, 2, 4, 2]
 * Output:
 * 8
 * 2 5
 * Explanation:
 * The first and second items would each be discounted by 1 unit,
 * the first equal or lower price to the right.
 * The item priced 1 unit would sell at a full price.
 * The next item, at 2 units, would be discounted 2 units as would the 4 unit item.
 * The sixth and final item must be purchased at full price.
 * The total cost is 1+2+1+0+2+2 = 8 units.
 * Print total cost of all items on the first line.
 * On the second line print a space separated list of integers representing the indexes of the
 * non-discounted items in ascending index order.
 *
 * Example 2:
 * Input 2: [5,1,3,4,6,2]
 * Output:
 * 14
 * 1 5
 *
 * Example 3:
 * Input 3: [1,3,3,2,5]
 * Output:
 * 9
 * 0 3 4
 * </p>
 */

public class Amazon17 {

  public int saleDiscount(List<Integer> list) {
    int toBeDeducted = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j <list.size(); j++) {
        if (list.get(j) <= list.get(i)) {
          toBeDeducted += list.get(j);
          break;
        }
      }
    }
    int ans = 0;
    for (int i : list) {
      ans += i;
    }
    return ans - toBeDeducted;
  }
}
