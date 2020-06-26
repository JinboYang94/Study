package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * <p>
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * </p>
 */

class Leetcode140 {

  public List<String> wordBreak(String s, List<String> wordDict) {
    return dfs(s, wordDict, new HashMap<>());
  }

  private List<String> dfs(String s, List<String> pool, HashMap<String, LinkedList<String>> map) {
    if (map.containsKey(s)) {
      return map.get(s);
    }
    LinkedList<String> ret = new LinkedList<>();
    if (s.length() == 0) {
      ret.add("");
      return ret;
    }
    for (String word : pool) {
      if (s.startsWith(word)) {
        List<String> subList = dfs(s.substring(word.length()), pool, map);
        for (String sub : subList) {
          ret.add(word + (sub.isEmpty() ? "" : " ") + sub);
        }
      }
    }
    map.put(s, ret);
    return ret;
  }
}
