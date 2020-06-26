package OA.GoogleOA;

/**
 * One string is strictly smaller than another when the frequency of occurrence of the smallest
 * character in the string is less than the frequency of occurrence of the smallest character in
 * the comparision string.
 * For example, string "abcd" is smaller than string "aaa" because the smallest character (in
 * lexicographical order) in "abcd" is 'a', with a frequency of 1, and the smallest character in
 * "aaa" is also 'a', but with a frequency of 3.
 * In another example, string "a" is smaller than string "bb" because the smallest character in "a"
 * is 'a' with a frequency of 1, and the smallest character in "bb" is 'b' with frequency of 2.
 * Write a function that, given string A (which contains M strings delimited by',')
 * and string B (which contains N strings delimited by ','), returns an array C of N integers.
 * For 0 <= J < N, values of C[J] specify the number of strings in A which are strictly smaller
 * than the comparison J-th string in B (starting from 0).
 * Assume:
 * 1 <= N, M <= 10000
 * 1 = length of any string contained by A or B <= 10
 * All the input strings comprise only lowercase English alphabet letters (a-z)
 *
 * <p>
 * Example:
 * A = "abcd aabc bd"
 * B = "aaa aa"
 * the function should return [3, 2]
 * Explanation: All the strings in the A array are strictly smaller than "aaa" on the basis of the
 *              given comparision criteria; string "abcd" and "bd" are strictly smaller than "aa".
 * </p>
 */

public class Google4 {

  public int[] compareStrings(String s1, String s2) {
    String[] strs1 = s1.split(",");
    String[] strs2 = s2.split(",");
    int len1 = strs1.length;
    int len2 = strs2.length;
    int[] freqs = new int[11];
    int[] ans = new int[len2];
    // get A's frequency
    for (String str1 : strs1) {
      int[] count1 = new int[26];
      int minCh = 26;
      for (char ch1 : str1.toCharArray()) {
        count1[ch1 - 'a']++;
        minCh = Math.min(minCh, ch1 - 'a');
      }
      int freq = count1[minCh];
      freqs[freq]++;
    }
    // calculate whole frequency in A
    for (int i = 1; i < 11; i++) {
      freqs[i] += freqs[i - 1];
    }
    // get ans
    for (int i = 0; i < len2; i++) {
      String str2 = strs2[i];
      int[] count2 = new int[26];
      int minCh = 26;
      for (char ch2 : str2.toCharArray()) {
        count2[ch2 - 'a']++;
        minCh = Math.min(minCh, ch2 - 'a');
      }
      int freq = count2[minCh];
      ans[i] = (freq - 1 >= 0) ? freqs[freq - 1] : 0;
    }
    return ans;
  }
}
