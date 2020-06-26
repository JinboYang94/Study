package OA.AmazonOA2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Eight houses, represented as cells, are arranged in a straight line.
 * Each day every cell competes with its adjacent cells (neighbors).
 * An integer value 1 represents an active cell and a value of 0 represents an inactive cell.
 * If the neighbors on both the sides of a cell are either active or inactive,
 * the cell becomes inactive on the next day; otherwise the cell becomes active.
 * The two cells on each end have a single adjacent cell,
 * so assume that the unoccupied space on the opposite side is an inactive cell.
 * Even after updating the cell state, consider its previous state when updating the
 * state of other cells. The state information of all cells should be updated simultaneously.
 * Write an algorithm to output the state of the cells after the given number of days.
 * Input:
 * The input to the function/method consists of two arguments:
 * states, a list of integers representing the current state of cells;
 * days, an integer representing the number of days.
 * Output:
 * Return a list of integers representing the state of the cells after the given number of days.
 *
 * <p>
 * Examples 1:
 * Input:
 * [1, 0, 0, 0, 0, 1, 0, 0], 1
 *
 * Output:
 * 0 1 0 0 1 0 1 0
 *
 * Examples 2:
 * Input:
 * [1, 1, 1, 0, 1, 1, 1, 1], 2
 *
 * Output:
 * 0 0 0 0 0 1 1 0
 * </p>
 */

public class Amazon12 {

  public List<Integer> stateAfterDays(List<Integer> state, int n) {
    // use map to record every state
    Map<String, Integer> record = new HashMap<>();
    while (n > 0) {
      List<Integer> newState = new ArrayList<>(8);
      record.put(convert(state), n--);
      newState.add(0, state.get(1).equals(0) ? 0 : 1);
      for (int i = 1; i < 7; i++) {
        newState.add(i, state.get(i - 1).equals(state.get(i + 1)) ? 0 : 1);
      }
      newState.add(7, state.get(6).equals(0) ? 0 : 1);
      // next loop
      state = newState;
      // if this has already recorded in the map, from last time seen day: record.get(covert(state))
      // to current seen day: n. This duration repeats again and again, so n % this duration will
      // increase run speed
      if (record.containsKey(convert(state))) {
        n %= record.get(convert(state)) - n;
      }
    }
    return state;
  }

  private String convert(List<Integer> list) {
    StringBuilder sb = new StringBuilder();
    for (Integer i : list) {
      sb.append(i);
    }
    return sb.toString();
  }
}
