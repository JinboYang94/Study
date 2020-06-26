package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address
 * combinations.
 *
 * <p>
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 * </p>
 */

class Leetcode93 {

  public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, new StringBuilder(), s, 0, 0);
    return ans;
  }

  private void backtrack(List<String> ans, StringBuilder sb, String s, int index, int ct) {
    if (ct > 4) { // ct means which part
      return;
    } else if (ct == 4 && index == s.length()) {  // index means character index, must have ct == 4!
      ans.add(sb.toString());
      return;
    } else {
      StringBuilder temp = new StringBuilder(sb); // keep last section's value
      for (int i = 1; i < 4; i++) {
        if (index + i > s.length()) {
          break;
        }
        sb = new StringBuilder(temp); // restore, do not use sb = temp!! Don't forget!
        String str = s.substring(index, index + i);
        if ((str.length() > 1 && str.startsWith("0")) || Integer.parseInt(str) >= 256) {
          continue;
        }
        sb.append(str);
        backtrack(ans, sb.append(ct < 3 ? "." : ""), s, index + i, ct + 1);
      }
    }
  }
}
