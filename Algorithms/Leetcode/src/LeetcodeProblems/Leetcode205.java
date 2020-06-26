package LeetcodeProblems;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character but a character may
 * map to itself.
 * Note:
 * You may assume both s and t have the same length.
 *
 * <p>
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * </p>
 */

class Leetcode205 {

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> pool = new HashMap<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (pool.containsKey(s.charAt(i))) {
        if (pool.get(s.charAt(i)).equals(t.charAt(i))) {
          continue;
        } else {
          return false;
        }
      } else {
        if (!pool.containsValue(t.charAt(i))) {
          pool.put(s.charAt(i), t.charAt(i));
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
