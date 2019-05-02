class Leetcode44b {

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;

    for (int i = s.length(); i >= 0; i--) {
      for (int j = p.length(); j >= 0; j--) {
        if (i == s.length() && j == p.length()) {
          continue;
        }

        if (i == s.length() && j < p.length()) {
          if (p.charAt(j) == '*') {
            dp[i][j] = dp[i][j + 1];
          } else if (p.charAt(j) == ' ' || p.charAt(j) == '?') {
            dp[i][j] = false;
          }
        }

        if (j == p.length() && i < s.length()) {
          dp[i][j] = false;
        }

        if (i < s.length() && j < p.length()) {
          if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = dp[i + 1][j + 1];
          } else if (p.charAt(j) == '*') {
            dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
          }
        }
      }
    }
    return dp[0][0];
  }
}
