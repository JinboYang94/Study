import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * <p>
 * Example:
 *
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * </p>
 */

class Leetcode46 {

  public List<List<Integer>> permute(int[] nums) {
    Arrays.sort(nums);
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, temp, ans);
    return ans;
  }

  private void backtrack(int[] input, List<Integer> temp, List<List<Integer>> ans) {
    if (temp.size() > input.length) {
      return;
    } else if (temp.size() == input.length) {
      ans.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < input.length; i++) {
        if (temp.contains(input[i])) {
          continue;
        }
        temp.add(input[i]);
        backtrack(input, temp, ans);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
