package LeetcodeProblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * <p>
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * </p>
 */

class Leetcode179 {

  public String largestNumber(int[] nums) {
    // compare String
    Comparator<String> comp = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
      }
    };
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, comp);
    // check if 0 max
    if (strs[0].equals("0")) {
      return "0";
    }
    // get ans
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str);
    }
    return sb.toString();
  }
}
