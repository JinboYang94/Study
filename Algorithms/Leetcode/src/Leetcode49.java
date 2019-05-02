import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * <p>
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * </p>
 * Tag: Fail at 100/101, TLE...
 */

class Leetcode49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    boolean[] added = new boolean[strs.length];

    for (int i = 0; i < strs.length; i++) {
      List<String> temp = new ArrayList<>();
      if (!added[i]) {
        temp.add(strs[i]);
        added[i] = true;
        // if two String has same components, set status to true and add to temp list
        for (int j = i + 1; j < strs.length; j++) {
          if (isEqual(strs[i], strs[j])) {
            temp.add(strs[j]);
            added[j] = true;
          }
        }
      }

      // if temp has something, add to ans list
      if (temp.size() != 0) {
        ans.add(temp);
      }
    }

    return ans;
  }

  /**
   * Compare whether the two String has same chars.
   * @param str1  first {@link String}.
   * @param str2  second {@link String}.
   * @return
   */
  private boolean isEqual(String str1, String str2) {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    // count the char numbers in str1, store in a hash map
    fillMap(map1, str1);

    // same as above
    fillMap(map2,str2);

    if (map1.equals(map2)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Fill the hash map which counts the number of a char in given String.
   * @param map a {@link HashMap}.
   * @param str a {@link String}.
   */
  private void fillMap(Map<Character, Integer> map, String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i), 1);
      } else {
        map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
      }
    }
  }
}
