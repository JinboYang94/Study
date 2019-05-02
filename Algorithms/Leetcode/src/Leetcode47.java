import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 *
 * <p>
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * </p>
 */

class Leetcode47 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> index = new ArrayList<>();
    dfs(nums, temp, ans, index);
    return ans;
  }

  private void dfs(int[] nums, List<Integer> pa, List<List<Integer>> ans, List<Integer> index) {
    if (pa.size() > nums.length) {
      return;
    } else if (pa.size() == nums.length) {
      ans.add(new ArrayList<>(pa));
    } else {
      for (int i = 0; i < nums.length; i++) {
        // avoid pick the same element twice
        if (index.contains(i)) {
          continue;
        }
        // avoid generate same permutation when there are duplicates in nums[].
        // !index.contains(i - 1) stands for if [1,1,2], first loop is [1] [1,1]
        // [1,1,2]. If without this statement, [1,1] will be skipped. With this,
        // the next loop when pick [1](the second in nums[]), because the first 1
        // is not contained in index[], this same permutation [1] [1,1] [1,1,2]
        // should be skipped.
        if (i - 1 >= 0 && nums[i] == nums[i - 1] && !index.contains(i - 1)) {
          continue;
        }
        index.add(i);
        pa.add(nums[i]);
        dfs(nums, pa, ans, index);
        index.remove(index.size() - 1);
        pa.remove(pa.size() - 1);
      }
    }
  }
}
