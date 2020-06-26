package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Another solution, easy-understand.
 */

class Leetcode205b {

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Integer> poolS = new HashMap<>();
    Map<Character, Integer> poolT = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int indexS = poolS.getOrDefault(s.charAt(i), -1);
      int indexT = poolT.getOrDefault(t.charAt(i), -1);
      if (indexS != indexT) {
        return false;
      }
      poolS.put(s.charAt(i), i);
      poolT.put(t.charAt(i), i);
    }
    return true;
  }
}
