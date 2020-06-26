package LeetcodeProblems;

/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * <p>
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * </p>
 */

class Leetcode188 {

  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    // avoid TLE/MLE
    if (k > prices.length / 2) {
      int ans = 0;
      for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) {
          ans += prices[i] - prices[i - 1];
        }
      }
      return ans;
    }
    // dp starts
    int[][] dp = new int[prices.length][k + 1];
    int[] min = new int[k + 1];
    for (int i = 0; i < k + 1; i++) {
      min[i] = prices[0];
    }
    // see leetcode 123 solution, same
    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j < k + 1; j++) {
        min[j] = Math.min(prices[i] - dp[i - 1][j - 1], min[j]);
        dp[i][j] = Math.max(dp[i - 1][j], prices[i] - min[j]);
      }
    }
    return dp[prices.length - 1][k];
  }
}
