package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * My solution tries to get correct, cant backtrack somehow.
 */

class Leetcode140b {

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> ans = new ArrayList<>();
    dfs(ans, s, new StringBuilder(), wordDict, 0);
    return ans;
  }

  private void dfs(List<String> ans, String s, StringBuilder sb, List<String> pool, int index) {
    if (index == s.length() && !ans.contains(sb.toString())) {
      sb.delete(sb.length() - 1, sb.length());
      ans.add(new String(sb.toString()));
    }
    for (int i = index; i < s.length(); i++) {
      String temp = s.substring(index, i + 1);
      if (pool.contains(temp)) {
        dfs(ans, s, sb.append(temp).append(" "), pool, i + 1);
        sb = new StringBuilder();
        index = 0;
      }
    }
  }
}
