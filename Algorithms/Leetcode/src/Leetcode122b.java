/**
 * Peak-valley approach. Find local minimum and find local maximum.
 */

class Leetcode122b {

  public int maxProfit(int[] prices) {
    int profit = 0;
    int i = 0;
    while (i < prices.length) { // range
      // find local minimum as valley
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      int valley = prices[i];
      // find local maximum as peak
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      int peak = prices[i];
      profit += peak - valley;
      i++;
    }
    return profit;
  }
}
