package OA.AmazonOA2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Give a computer with total K memory space,
 * and an array of foreground tasks and background tasks the computer need to do.
 * Write an algorithm to find a pair of tasks from each array to maximize the memory usage.
 * Notice the tasks could be done without origin order.
 * Input:
 * The input to the function/method consists of three arguments :
 * foregroundTask, an array representing the memory usage of the foreground tasks,
 * backgroundTask, an array representing the memory usage of the background tasks,
 * K, the total memory space of the computer.
 * Output:
 * Return a list of pairs of the task ids.
 *
 * <p>
 * Example 1:
 * Input:
 * foregroundTasks = [1, 7, 2, 4, 5, 6]
 * backgroundTasks = [3, 1, 2]
 * K = 6
 *
 * Output:
 * [(3, 2), (4, 1)]
 *
 * Explanation:
 * Here we have 5 foreground tasks:
 * task 0 uses 1 memory. task 1 uses 7 memory. task 2 uses 2 memory..
 * And 5 background tasks:
 * task 0 uses 3 memory. task 1 uses 1 memory. task 2 uses 2 memory..
 * We need to find two tasks with total memory usage sum <= K.
 * So we find the foreground task 3 and background task 2. Total memory usage is 6.
 * And the foreground task 4 and background task 1. Total memory usage is also 6.
 *
 * Example 2:
 * Input:
 * foregroundTasks = [1, 7, 2, 4, 5, 6]
 * backgroundTasks = [3, 1, 2]
 * K = 10
 *
 * Output:
 * [(1, 2))]
 *
 * Explanation:
 * Here we find the foreground task 1 and background task 2.
 * Total memory usage is 7 + 3 = 10, which is <= 10.
 * </p>
 */

public class Amazon14 {

  // This solution assume there are no duplicates in both foreground and background.
  // If duplicates, ? add another part to specifically deal with it. If values in ans has
  // duplicate values, add corresponding indexes into ans.
  public List<List<Integer>> assignTasks(int[] foreground, int[] background, int cap) {
    List<List<Integer>> ans = new ArrayList<>();
    // store value-index relations into map
    Map<Integer, Integer> foreMap = new HashMap<>();
    for (int i = 0; i < foreground.length; i++) {
      foreMap.put(foreground[i], i);
    }
    Map<Integer, Integer> backMap = new HashMap<>();
    for (int i = 0; i < background.length; i++) {
      backMap.put(background[i], i);
    }
    Arrays.sort(foreground);
    Arrays.sort(background);
    // two pointer loop all possibilities
    int max = Integer.MIN_VALUE;
    int i = 0;
    int j = background.length - 1;
    while (i < foreground.length && j >= 0) {
      int currSum = foreground[i] + background[j];
      if (currSum > cap) {  // over bound, lower j
        j--;
      } else {  // not over bound, upper i
        // if current sum >= max
        if (currSum >= max) {
          // update if sum > max, and clear previous recorded ans
          if (currSum > max) {
            max = currSum;
            ans.clear();
          }
          // if sum == max || sum > max, record to ans
          List<Integer> temp = new ArrayList<>();
          temp.add(foreMap.get(foreground[i]));
          temp.add(backMap.get(background[j]));
          ans.add(temp);
        }
        i++;
      }
    }
    return ans;
  }
}
