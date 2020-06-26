package LeetcodeProblems;

/**
 * DP solution.
 */

class Leetcode1029b {

  public int twoCitySchedCost(int[][] costs) {
    int cap = costs.length / 2;
    int[][] dp = new int[cap + 1][cap + 1];
    // assign to a and b
    for (int i = 1; i <= cap; i++) {
      dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
      dp[0][i] = dp[0][i - 1] + costs[i - 1][1];
    }
    // combining both situations
    for (int i = 1; i <= cap; i++) {
      for (int j = 1; j <= cap; j++) {
        dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
      }
    }
    return dp[cap][cap];
  }
}
