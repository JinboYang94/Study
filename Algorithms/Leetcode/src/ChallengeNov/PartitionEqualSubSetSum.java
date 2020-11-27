package ChallengeNov;

public class PartitionEqualSubSetSum {

  public boolean canPartition(int[] nums) {
    int len = nums.length;
    int sum = 0;
    int max = 0;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    if (sum % 2 != 0) {
      return false;
    }
    int tar = sum / 2;
    if (max > tar) {
      return false;
    }
    // dp start, dp[i][j] stands for selecting random integer from nums[0]~nums[i], is it possible
    // to sum to j.
    boolean[][] dp = new boolean[len][tar + 1];
    dp[0][0] = true;
    for (int i = 1; i < tar + 1; i++) {
      dp[0][i] = false;
    }
    for (int i = 1; i < len; i++) {
      dp[i][0] = true;
    }
    for (int i = 1; i < len; i++) {
      for (int j = 1; j < tar + 1; j++) {
        if (j < nums[i]) {
          // can not select this num
          dp[i][j] = dp[i - 1][j];
        } else {
          // select this num or not, both are fine
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        }
      }
    }
    return dp[len - 1][tar];
  }
}
