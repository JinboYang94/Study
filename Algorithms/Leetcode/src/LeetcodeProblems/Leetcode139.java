package LeetcodeProblems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * </p>
 */

class Leetcode139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    return dfs(s, wordDict, 0, new HashSet<>());
  }

  private boolean dfs(String s, List<String> pool, int index, Set<Integer> markFail) {
    if (index == s.length()) {
      return true;
    }
    if (markFail.contains(index)) {
      return false;
    }
    for (int i = index; i < s.length(); i++) {
      String temp = s.substring(index, i + 1);
      if (pool.contains(temp)) {
        // no use return dfs(s, pool, i + 1); this will not loop all possibilities
        if (dfs(s, pool, i + 1, markFail)) {
          return true;
        }
      }
    }
    markFail.add(index);
    return false;
  }
}
