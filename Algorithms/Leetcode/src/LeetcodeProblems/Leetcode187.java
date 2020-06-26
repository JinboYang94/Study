package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA,
 * it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than
 * once in a DNA molecule.
 *
 * <p>
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * </p>
 */

class Leetcode187 {

  public List<String> findRepeatedDnaSequences(String s) {
    List<String> ans = new ArrayList<>();
    Set<String> pool = new HashSet<>();
    for (int i = 0; i < s.length() - 9; i++) {
      if (pool.contains(s.substring(i, i + 10)) && !ans.contains(s.substring(i, i + 10))) {
        ans.add(s.substring(i, i + 10));
      } else {
        pool.add(s.substring(i, i + 10));
      }
    }
    return ans;
  }
}
