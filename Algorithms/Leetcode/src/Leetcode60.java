import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * <p>
 * Example:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * </p>
 */

class Leetcode60 {

  public String getPermutation(int n, int k) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      ans.add(i);
    }

    int[] fact = new int[n];
    fact[0] = 1;  // 0! = 1
    for (int i = 1; i < n; i++) {
      fact[i] = i * fact[i - 1];
    }

    k--; // make an example, you will find if k, returns the k + 1 permutation, so k--
    StringBuilder sb = new StringBuilder();
    for (int i = n; i > 0; i--) {
      int temp = k / fact[i - 1]; // the index of current number position
      sb.append(ans.get(temp));
      ans.remove(ans.get(temp));  // update the next permutation pool
      k = k % fact[i - 1];  // update the wanted index for next loop with new permutation pool
    }

    return sb.toString();
  }
}
