package LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * <p>
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * </p>
 */

class Leetcode217 {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> pool = new HashSet<>();
    for (int i : nums) {
      if (pool.contains(i)) {
        return true;
      } else {
        pool.add(i);
      }
    }
    return false;
  }
}
