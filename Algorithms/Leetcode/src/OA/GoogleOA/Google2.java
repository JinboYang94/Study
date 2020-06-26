package OA.GoogleOA;

import java.util.HashMap;
import java.util.Map;

/**
 * Several coupons are placed in a row, and to win prize you need to pick up at least two coupons
 * of the same value. Notice you can only pick up consecutive coupons from the row.
 * Given an array of integers representing the value of coupons,
 * return the minimum number of consecutive coupons to pick up to win the prize.
 * Return -1 if it’s not possible.
 *
 * <p>
 * Example 1:
 * Input: coupons = [1, 3, 4, 2, 3, 4, 5, 8]
 * Output: 4
 * Explanation: Here you can either pick up [3, 4, 2, 3] or [4, 2, 3, 4]
 *
 * Example 2:
 * Input: coupons = [2, 5, 0, 3]
 * Output: -1;
 * </p>
 */

public class Google2 {

  public int minPickUpCoupons(int[] coupons) {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < coupons.length; i++) {
      if (map.containsKey(coupons[i])) {
        ans = Math.min(ans, i - map.get(coupons[i]) + 1);
      }
      map.put(coupons[i], i);
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
