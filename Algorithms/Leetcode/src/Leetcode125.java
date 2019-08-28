/**
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * <p>
 * Example:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Input: "race a car"
 * Output: false
 * </p>
 */

class Leetcode125 {

  public boolean isPalindrome(String s) {
      s = s.toLowerCase().trim();
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      while (!checkValidation(s.charAt(i))) {
        i++;
        // avoid overflow like ".,,.,.", when ignoring all invalid characters, it is true
        if (i == s.length()) {
          return true;
        }
      }
      while (!checkValidation(s.charAt(j))) {
        j--;
      }
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private boolean checkValidation(char c) {
    if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
      return true;
    }
    return false;
  }
}
