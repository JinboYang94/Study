package LeetcodeProblems;

/**
 * Follow-up: O(N) time + O(1) space solution, Boyer-Moore Majority Vote algorithm.
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode229b {

  public List<Integer> majorityElement(int[] nums) {
    int freq = nums.length / 3;
    List<Integer> ret = new ArrayList<>();
    // two candidates,
    int cand1 = 0, cand2 = 0;
    int ct1 = 0, ct2 = 0;
    for (int num : nums) {
      // cand1 -> cand1 number++
      if (num == cand1) {
        ct1++;
        continue;
      }
      // cand2 -> cand2 number++
      if (num == cand2) {
        ct2++;
        continue;
      }
      // not cand1 or cand2, then replace the one which number == 0
      if (ct1 == 0) {
        cand1 = num;
        ct1++;
        continue;
      }
      if (ct2 == 0) {
        cand2 = num;
        ct2++;
        continue;
      }
      // moore vote, after majority element--, if -> 0 it will be replaced, if not its major
      ct1--;
      ct2--;
    }
    // until now, we get the most frequent 2 candidates, but may not satisfy > n/3.
    // check ct1 and ct2 satisfy > n/3 this condition, its not mentioned in problem.
    ct1 = ct2 = 0;
    for (int num : nums) {
      if (num == cand1) {
        ct1++;
      } else if (num == cand2) {
        ct2++;
      }
    }
    if (ct1 > freq) {
      ret.add(cand1);
    }
    if (ct2 > freq) {
      ret.add(cand2);
    }
    return ret;
  }
}
