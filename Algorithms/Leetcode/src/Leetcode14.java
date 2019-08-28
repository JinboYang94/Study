/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Note:
 * All given inputs are in lowercase letters a-z.
 *
 * <p>
 * Example:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * </p>
 */

class Leetcode14 {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    String str = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (!strs[i].startsWith(str)) {
        str = str.substring(0, str.length() - 1);
      }
    }

    return str.isEmpty() ? "" : str;
  }
}
