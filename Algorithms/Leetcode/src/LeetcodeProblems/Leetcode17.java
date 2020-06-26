package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
 * Note:
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 *
 * <p>
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </p>
 */

class Leetcode17 {

  public List<String> letterCombinations(String digits) {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    if (digits.length() == 0) {
      return ans;
    }
    backtrack(new StringBuilder(), digits, ans, mapping);
    return ans;
  }

  private void backtrack(StringBuilder sb, String leftDigits, List<String> ans, String[] map) {
    if (leftDigits.isEmpty()) {
      ans.add(sb.toString());
    } else {
      String curr = leftDigits.substring(0, 1);
      String letters = map[Integer.parseInt(curr)];
      for (int i = 0; i < letters.length(); i++) {
        sb.append(letters.substring(i, i + 1));
        backtrack(sb, leftDigits.substring(1), ans, map);
        // restore to previous status
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
