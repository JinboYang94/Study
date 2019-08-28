/**
 * Two-pointer.
 */

class Leetcode121b {

  public int maxProfit(int[] prices) {
    int ans = 0;
    int buy = 0;  // slow
    int sell = 0; // fast
    for (; sell < prices.length; sell++) {
      if (prices[sell] < prices[buy]) {
        buy = sell;
      } else {
        ans = Math.max(ans, prices[sell] - prices[buy]);
      }
    }
    return ans;
  }
}
