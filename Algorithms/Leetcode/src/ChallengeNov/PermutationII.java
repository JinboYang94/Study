package ChallengeNov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Leetcode 47
public class PermutationII {

  List<List<Integer>> ret = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    heapPermute(nums, 0);
    return ret;
  }

  private void heapPermute(int[] nums, int start) {
    if (start == nums.length) {
      List<Integer> temp = new ArrayList<>();
      for (int num : nums) {
        temp.add(num);
      }
      if (!ret.contains(temp)) {
        ret.add(temp);
      }
    } else {
      for (int i = start; i < nums.length; i++) {
        swap(nums, i, start);
        heapPermute(nums, start + 1);
        swap(nums, i, start);
      }
    }
  }

  private void swap(int[] A, int x, int y) {
    int temp = A[x];
    A[x] = A[y];
    A[y] = temp;
  }
}

// the upper solution is heap algorithm, but too slow here, try dfs:

class PermutationII2 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    List<Integer> idx = new ArrayList<>();
    dfs(nums, temp, ret, idx);
    return ret;
  }

  private void dfs(int[] nums, List<Integer> temp, List<List<Integer>> ans, List<Integer> idx) {
    if (temp.size() > nums.length) {
      return;
    } else if (temp.size() == nums.length) {
      ans.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (idx.contains(i)) {
          continue;
        }
        // prune duplicate
        if (i - 1 >= 0 && nums[i] == nums[i - 1] && !idx.contains(i - 1)) {
          continue;
        }
        temp.add(nums[i]);
        idx.add(i);
        dfs(nums, temp, ans, idx);
        temp.remove(temp.size() - 1);
        idx.remove(idx.size() - 1);
      }
    }
  }
}
