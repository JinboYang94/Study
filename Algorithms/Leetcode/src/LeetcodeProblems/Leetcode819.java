package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words,
 * return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * Note:
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 * <p>
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * </p>
 */

class Leetcode819 {

  public String mostCommonWord(String paragraph, String[] banned) {
    String[] word = paragraph.toLowerCase().split("[ !?',;.]+");
    List<String> banWord = new ArrayList<>(Arrays.asList(banned));
    Map<String, Integer> map = new HashMap<>();

    for (String s : word) {
      if (banWord.contains(s)) {
        continue;
      }
      if (!map.containsKey(s)) {
        map.put(s, 1);
      } else {
        map.put(s, map.get(s) + 1);
      }
    }

    String ans = null;
    for (String str : map.keySet()) {
      if (map.get(str) > map.getOrDefault(ans, 0)) {
        ans = str;
      }
    }
    return ans;
  }
}
