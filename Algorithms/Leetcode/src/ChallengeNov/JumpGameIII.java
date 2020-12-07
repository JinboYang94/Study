package ChallengeNov;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

  public boolean canReach(int[] arr, int start) {
    return dfs(arr, start, 0);
  }

  private boolean dfs(int[] arr, int idx, int times) {
    if (idx < 0 || idx > arr.length) {
      return false;
    }
    if (arr[idx] == 0) {
      return true;
    }
    if (times == arr.length) {
      return false;
    }
    return dfs(arr, idx + arr[idx], times + 1) || dfs(arr, idx - arr[idx], times + 1);
  }

  // bfs
  public boolean canReach2(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    queue.offer(start);
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      if (visited.contains(curr) || curr < 0 || curr >= arr.length) {
        continue;
      }
      if (arr[curr] == 0) {
        return true;
      } else {
        visited.add(curr);
        queue.offer(curr + arr[curr]);
        queue.offer(curr - arr[curr]);
      }
    }
    return false;
  }
}
