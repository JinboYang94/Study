package LeetcodeProblems;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Leetcode229 {

  public List<Integer> majorityElement(int[] nums) {
    int freq = nums.length / 3;
    List<Integer> ret = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (!ret.contains(num) && map.get(num) > freq) {
        ret.add(num);
      }
    }
    return ret;
  }
}
