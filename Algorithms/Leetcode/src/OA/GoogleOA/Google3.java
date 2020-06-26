package OA.GoogleOA;

/**
 * You are a gardener and you take care of your plants.
 * The plants are planted in a row and each of them needs a specific amount of water.
 * You are about to water them using a watering can. To avoid mistakes like applying too much
 * water, or not watering a plant at all. You have to decided to:
 * - Water the plants in the order which they appear, from left to right;
 * - Water each plant if you have sufficient water for it, otherwise refill your watering can;
 * - water each plant in one go, i.e. without taking a break to refill the watering can
 *   in the middle of watering a single plant.
 *   This means that you may sometimes have to refill your watering can before or after
 *   watering a plant, even though it's not completely empty.
 * You start at the water container, which is positioned one step before the first plant.
 * How many steps will you take, in order to water all the plants in the row?
 * You must take one step to move to the next or the previous plant
 * (all plants are positioned one step apart from each other).
 * Given an array plants of n integers (for the amount of water needed by each plan)
 * and the watering can capacity, return the number of steps needed to water all the plants.
 * Constraints:
 * n is an integer within the range [1..1,000];
 * each element of array plants is an integer within the range [1..1,000,000];
 * capacity is an integer within the range [1..1,000,000,000];
 * the watering can is large enough to fully water any single plant.
 *
 * <p>
 * Example 1:
 *
 * Input: plants = [2, 4, 5, 1, 2], capacity = 6
 * Output: 17
 * Explanation:
 * First you water plants[0] and plants[1] (2 steps).
 * Then you have to go back to refill (2 steps) and water plants[2] and plants[3] (4 steps).
 * Then again you have to refill (4 steps) and water plants[4] (5 steps).
 * So 2 + 2 + 4 + 4 + 5 = 17.
 * </p>
 */

public class Google3 {

  public int minStepsWaterPlants(int[] plants, int capacity) {
    int len = plants.length;
    int currCap = capacity;
    int ans = 0;
    for (int i = 0; i < len; i++) {
      // water
      if (plants[i] <= currCap) {
        currCap -= plants[i];
        ans++;
      } else {  // refill
        currCap = capacity;
        ans += 2 * i;
        i--;
      }
    }
    return ans;
  }
}
