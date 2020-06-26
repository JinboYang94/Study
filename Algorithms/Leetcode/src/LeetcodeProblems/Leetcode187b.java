package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A cleaner version, a little bit faster.
 */

class Leetcode187b {

  public List<String> findRepeatedDnaSequences(String s) {
    Set seen = new HashSet();
    Set ans = new HashSet();
    for (int i = 0; i < s.length() - 9; i++) {
      String temp = s.substring(i, i + 10);
      if (!seen.add(temp)) {
        ans.add(temp);
      }
    }
    return new ArrayList<>(ans);
  }
}
