package LeetcodeProblems;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * <p>
 * Example:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * </p>
 */

class Leetcode123 {

  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int k = 2;
    // dp[i][j] means get highest profit until day i with j times transactions
    int[][] dp = new int[prices.length][k + 1]; // k = 0,1,2
    int[] min = new int[k + 1];

    for (int i = 1; i < k + 1; i++) {
      min[i] = prices[0];
    }

    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j < k + 1; j++) {
        // if make transaction, find the min for buying before day i sell (means use less money
        // to buy, and save more money on profit before day i)
        min[j] = Math.min(prices[i] - dp[i - 1][j - 1], min[j]);
        // no transaction vs sell at day i (- min[j] because must buy before sell)
        dp[i][j] = Math.max(dp[i - 1][j], prices[i] - min[j]);
      }
    }
    return dp[prices.length - 1][k];
  }
}
