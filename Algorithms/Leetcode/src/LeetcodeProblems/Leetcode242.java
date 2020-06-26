package LeetcodeProblems;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * <p>
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * </p>
 */

class Leetcode242 {

  public boolean isAnagram(String s, String t) {
    int[] table = new int[26];
    for (char ch : s.toCharArray()) {
      table[ch - 'a']++;
    }
    for (char ch : t.toCharArray()) {
      table[ch - 'a']--;
      if (table[ch - 'a'] < 0) {
        return false;
      }
    }
    for (int i : table) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }
}
