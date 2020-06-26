package LeetcodeProblems;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * <p>
 * Example:
 *
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first,
 * second and third child with 2, 1, 2 candies respectively.
 *
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *              The third child gets 1 candy because it satisfies the above two conditions.
 * </p>
 */

class Leetcode135 {

  public int candy(int[] ratings) {
    int minIndex = 0;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] < ratings[minIndex]) {
        minIndex = i;
      }
    }
    int ans = 1;
    int giveCandy = 1;
    int[] eachGive = new int[ratings.length]; // keep track each child are given
    eachGive[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {  // getting larger
        ++giveCandy;
        ans += giveCandy;
        eachGive[i] = giveCandy;
      } else if (ratings[i] == ratings[i - 1]) {  // keep same
        giveCandy = 1;
        ans += 1;
        eachGive[i] = giveCandy;
      } else {  // getting smaller
        if (giveCandy > 1) {  // if last given > 1, means nothing
          giveCandy = 1;
          ans += 1;
          eachGive[i] = giveCandy;
        } else {  // if last given == 1, we have to calculate how many are influenced
          giveCandy = 1;
          eachGive[i] = giveCandy;
          // calculate how many previous children should get one more candy
          int j = i - 1;
          // when previous down part
          while (j - 1 >= 0 && ratings[j] < ratings[j - 1]) {
            // if last given which is ++1 still >= previous given, need to add 1, move j
            if (++eachGive[j] >= eachGive[j - 1]) {
              j--;
            } else {
              break;
            }
          }
          ans += giveCandy + i - j;
        }
      }
    }
    return ans;
  }
}
