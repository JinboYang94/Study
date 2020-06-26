package LeetcodeProblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Override comparator solution, this is correct because it can recursively compare the other
 * sections.
 */

class Leetcode937b {

  public String[] reorderLogFiles(String[] logs) {
    // new comparator
    Comparator<String> logCompare = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int s1Space = s1.indexOf(' ');
        int s2Space = s2.indexOf(' ');
        char s1Char = s1.charAt(s1Space + 1);
        char s2Char = s2.charAt(s2Space + 1);
        // if s1 is number
        if (s1Char <= '9') {
          // if s2 is also number, just return as natural order
          if (s2Char <= '9') {
            return 0;
          } else {  // if s2 is letter, return 1 means s1 > s2, so s2 will be ahead of s1
            return 1;
          }
        }
        // if s1 letter, s2 number, return s1 < s2, so s1 will be ahead of s2
        if (s2Char <= '9') {
          return -1;
        }
        // compare two String
        int ret = s1.substring(s1Space + 1).compareTo(s2.substring(s2Space + 1));
        if (ret == 0) {
          return s1.substring(0, s1Space).compareTo(s2.substring(0, s2Space));
        }
        return ret;
      }
    };

    Arrays.sort(logs, logCompare);
    return logs;
  }
}
