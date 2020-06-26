package OA.BloombergLP;

/**
 * Given a string, reduce the string by removing 3 or more consecutive identical characters.
 * You should greedily remove characters from left to right.
 * Follow up: What if you need to find the shortest string after removal?
 * ?
 *
 * <p>
 * Example 1:
 *
 * Input: "aaabbbc"
 * Output: "c"
 * Explanation:
 * 1. Remove 3 'a': "aaabbbc" => "bbbc"
 * 2. Remove 3 'b': "bbbc" => "c"
 * Example 2:
 *
 * Input: "aabbbacd"
 * Output: "cd"
 * Explanation:
 * 1. Remove 3 'b': "aabbbacd" => "aaacd"
 * 2. Remove 3 'a': "aaacd" => "cd"
 * Example 3:
 *
 * Input: "aabbccddeeedcba"
 * Output: ""
 * Explanation:
 * 1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba"
 * 2. Remove 3 'd': "aabbccdddcba" => "aabbcccba"
 * 3. Remove 3 'c': "aabbcccba" => "aabbba"
 * 4. Remove 3 'b': "aabbba" => "aaa"
 * 5. Remove 3 'a': "aaa" => ""
 * Example 4:
 *
 * Input: "aaabbbacd"
 * Output: "acd"
 * Explanation:
 * 1. Remove 3 'a': "aaabbbacd" => "bbbacd"
 * 2. Remove 3 'b': "bbbacd" => "acd"
 * Follow up Example:
 *
 * Input: "aaabbbacd"
 * Output: "cd"
 * Explanation:
 * 1. Remove 3 'b': "aaabbbacd" => "aaaacd"
 * 2. Remove 4 'a': "aaaacd" => "cd"
 * </p>
 */

public class Bloomberg3 {

  public String removeDuplicate(String s) {
    String temp = s;
    for (int i = 1; i < s.length() - 1; i++) {
      if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == s.charAt(i + 1)) {
        int j = i + 2;
        while (j < s.length() && s.charAt(j) == s.charAt(i - 1)) {
          j++;
        }
        temp = s.substring(0, i - 1).concat(s.substring(j));
        break;
      }
    }
    // quit recursion
    if (temp.equals(s)) {
      return s;
    }
    return removeDuplicate(temp);
  }
}
