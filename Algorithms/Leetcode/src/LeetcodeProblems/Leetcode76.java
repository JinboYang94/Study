package LeetcodeProblems;

import java.util.HashMap;

/**
 * Given a string S and a string T,
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Tag: two pointer
 * <p>
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * </p>
 */

class Leetcode76 {

  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    int left = 0;
    int minLeft = 0;
    int minLen = s.length() + 1;
    int count = 0;
    for (int right = 0; right < s.length(); right++) {
      char r = s.charAt(right);
      if (map.containsKey(r)) {
        map.put(r, map.get(r) - 1);
        if (map.get(r) >= 0) {
          count++;  // keep moving right index until satisfied
        }
      }
      while (count == t.length()) { // first time reach means first satisfied window
        if (right - left + 1 < minLen) {  // update left index, contract window
          minLeft = left;
          minLen = right - left + 1;
        }
        char l = s.charAt(left);
        if (map.containsKey(l)) { // stop moving left index when it's on a necessary character
          map.put(l, map.get(l) + 1);
          if (map.get(l) > 0) {
            count--;  // break while loop
          }
        }
        left++; // contract window, move left because for already satisfied window, no more benefit
      }         // to move right index, so we turn to move left index
    }
    return minLen == s.length() + 1 ? "" : s.substring(minLeft, minLeft + minLen);
  }
}
