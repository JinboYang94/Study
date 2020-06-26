package LeetcodeProblems;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * <p>
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * </p>
 */

class Leetcode204 {

  public int countPrimes(int n) {
    // stores whether number i is dividable by a prime number < i
    boolean[] isMultipleOfPrime = new boolean[n];
    int ans = 0;
    for (int i = 2; i < n; i++) {
      // if i is not dividable by previous number, it is a prime
      if (!isMultipleOfPrime[i]) {
        ans++;
        // mark all multiples of this prime non-prime
        for (int j = i; j < n; j = j + i) {
          isMultipleOfPrime[j] = true;
        }
      }
    }
    return ans;
  }
}
