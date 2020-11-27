package ChallengeNov;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

  public int longestSubstring(String s, int k) {
    int[] freq = new int[26];
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    StringBuffer sb = new StringBuffer(s);
    for (int i = 0; i < sb.length(); i++) {
      if (map.get(sb.charAt(i)) > 0 && map.get(sb.charAt(i)) < k) {
        sb.setCharAt(i, ',');
      }
    }

    String[] strs = sb.toString().split(",");

    if (strs.length == 1) {
      return strs[0].length();
    }

    int ret = 0;
    for (int i = 0; i < strs.length; i++) {
      ret = Math.max(ret, longestSubstring(strs[i], k));
    }
    return ret;
  }
}
