package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier,
 * with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * Return the final order of the logs.
 * Note:
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 * Tag: Wrong solution, cant iteratively compare the other sections while the first section
 *      are same.
 *
 * <p>
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * </p>
 */

class Leetcode937 {

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
    Map<String, Character> map = new HashMap<>();
    for (String str : letterLogs) {
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
          if (idx == 0 || str.charAt(i + 1) >= map.get(ans[idx - 1])) {
            ans[idx++] = str;
            map.put(str, str.charAt(i + 1));
            break;
          }
          if (str.charAt(i + 1) < map.get(ans[idx - 1])) {
            int j = idx;
            backward(ans, str, j, i, map);
            map.put(str, str.charAt(i + 1));
            idx++;
            break;
          }
        }
      }
    }
  }

  private void backward(String[] ret, String str, int index, int i, Map<String, Character> map) {
    while (index - 1 >= 0 && str.charAt(i + 1) < map.get(ret[index - 1])) {
      ret[index] = ret[index - 1];
      index--;
    }
    ret[index] = str;
  }
}
