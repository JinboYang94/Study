import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tag: Refer to official answer.
 */

class Leetcode49b {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List> map = new HashMap<>();

    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String rearranged = String.valueOf(charArray);
      // if ans do not contain, add to map
      if (!map.containsKey(rearranged)) {
        map.put(rearranged, new ArrayList());
      }
      map.get(rearranged).add(str);
    }

    List<List<String>> ans = new ArrayList(map.values());
    return ans;
  }
}
