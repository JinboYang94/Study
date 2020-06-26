package LeetcodeProblems;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * <p>
 * Example:
 * Input: "Hello World"
 * Output: 5
 * </p>
 */

class Leetcode58 {

  public int lengthOfLastWord(String s) {
    int count = 0;
    boolean hasChar = false;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        hasChar = true;
      }
      if (!hasChar && s.charAt(i) == ' ') {
        continue;
      }
      if (hasChar && s.charAt(i) == ' ') {
        break;
      }
      count++;
    }

    return count;
  }
}
