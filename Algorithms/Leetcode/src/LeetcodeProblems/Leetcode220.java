package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the
 * array such that the absolute difference between nums[i] and nums[j] is at most t and the
 * absolute difference between i and j is at most k.
 * Tag: ???
 *
 * <p>
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * </p>
 */

class Leetcode220 {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0) {
      return false;
    }
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // divide the nums array into several buckets, which length t
      long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
      // t + 1 because t == 0 will cause error.
      long bucket = remappedNum / ((long) t + 1);
      // if this key duplicate, that means there must be two numbers that the difference are
      // less than t. If two different numbers are located in adjacent buckets, still possibly
      // less than t.
      if (map.containsKey(bucket)
          || map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t
          || map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) {
        return true;
      }
      // all mapping numbers >= index difference limit, then remove the last bucket could be reached
      if (map.entrySet().size() >= k) {
        long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
        map.remove(lastBucket);
      }
      // replace duplicate key
      map.put(bucket, remappedNum);
    }
    return false;
  }
}
