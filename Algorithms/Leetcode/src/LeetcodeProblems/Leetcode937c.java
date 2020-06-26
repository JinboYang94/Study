package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Improvement to my solution.
 */

class Leetcode937c {

  public String[] reorderLogFiles(String[] logs) {
    String[] ans = new String[logs.length];
    int letterCt = 0;
    Map<String, List<String>> map = new HashMap<>();
    map.put("Letter", new ArrayList<>());
    map.put("Number", new ArrayList<>());
    // distinguish letter log and number log
    for (String log : logs) {
      if (identifyLog(log)) {
        map.get("Letter").add(log);
        letterCt++;
      } else {
        map.get("Number").add(log);
      }
    }
    // sort letter part and combine with number part
    sortLetter(ans, map.get("Letter"));
    combineTwoParts(ans, map.get("Number"), letterCt);
    return ans;
  }

  private void combineTwoParts(String[] ans, List<String> list, int idx) {
    int j = 0;
    while (idx < ans.length) {
      ans[idx++] = list.get(j++);
    }
  }

  private boolean identifyLog(String s) {
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == ' ') {
        // return true if letter log
        if (charArray[i + 1] >= 'a' && charArray[i + 1] <= 'z') {
          return true;
        }
      }
    }
    return false;
  }

  private void sortLetter(String[] ans, List<String> letterLogs) {
    int idx = 0;
    Map<String, Integer> map = new HashMap<>();
    for (String str : letterLogs) {
      for (int i = 0; i < str.length(); i++) {
        // ignore identifier
        if (str.charAt(i) == ' ') {
          // if str lexicographically larger than previous ans, just add to this ans
          if (idx == 0 ||
              str.substring(i + 1).compareTo(ans[idx - 1].substring(map.get(ans[idx - 1]))) > 0) {
            ans[idx++] = str;
            map.put(str, i + 1);
            break;
          }
          // if not, have to insert this str into correct position
          if (str.substring(i + 1).compareTo(ans[idx - 1].substring(map.get(ans[idx - 1]))) <= 0) {
            int j = idx;
            backward(ans, str, j, i, map);
            map.put(str, i + 1);
            idx++;
            break;
          }
        }
      }
    }
  }

  private void backward(String[] ret, String str, int index, int i, Map<String, Integer> map) {
    while ((index - 1 >= 0
        && str.substring(i + 1).compareTo(ret[index - 1].substring(map.get(ret[index - 1]))) <= 0)) {
      ret[index] = ret[index - 1];
      index--;
    }
    ret[index] = str;
  }
}
