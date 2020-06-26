package OA.GoogleOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an int array of length n. Split it into strictly decreasing subsequences.
 * Output the minimum number of decreasing subsequences you can get by splitting the array.
 * Challenge: O(nlogn)
 * Solution: A principle is minimum number of decreasing subsequences partitions == length of
 *           longest increasing subsequence (vice versa).
 *
 * <p>
 * Example 1:
 * Input: [5, 2, 4, 3, 1,6]
 * Output: 3
 * Explanation: You can split this array into: [5, 2, 1], [4, 3], [6]. And there are 3 decreasing
 * subsequences you get. Or you can split it into[5, 4, 3], [2, 1], [6]. Also 3 decreasing
 * subsequences. But [5, 4, 3, 2, 1], [6] is not legal because [5, 4, 3, 2, 1] is not a
 * subsequence of the original array.
 *
 * Example 2:
 * Input: [2, 9, 12, 13, 4, 7, 6, 5, 10]
 * Output: 4
 * Explanation: [2], [9, 4], [12, 10], [13, 7, 6, 5]
 *
 * Example 3:
 * Input: [1, 1, 1]
 * Output: 3
 * Explanation: [1], [1], [1]
 * </p>
 */

public class Google1 {

  public int minDesSubseq(int[] array) {
    int[] temp = new int[array.length];
    int size = 0;
    for (int val : array) {
      int stop = binarySearch(temp, 0, size, val);
      temp[stop] = val;
      if (stop == size) {
        size++;
      }
    }
    return size;
  }

  // find first element greater than target
  private int binarySearch(int[] nums, int low, int high, int tar) {
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] <= tar) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  // O(n^2) greedy
  public int minDesSubseq2(int[] array) {
    // This list record all last elements of subsequences in ans
    List<Integer> minSub = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      boolean sign = false;
      for (int j = 0; j < minSub.size(); j++) {
        // if descending, update the last element of this subsequence
        if (array[i] < minSub.get(j)) {
          minSub.remove(j);
          minSub.add(j, array[i]);
          sign = true;
          break;
        }
      }
      // if not, add this as a new subsequence
      if (!sign) {
        minSub.add(array[i]);
      }
      // sort to make sure it can always update the last element?
      Collections.sort(minSub);
    }
    return minSub.size();
  }
}
