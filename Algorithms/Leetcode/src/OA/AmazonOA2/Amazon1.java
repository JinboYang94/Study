package OA.AmazonOA2;

import java.util.Arrays;

/**
 * You are on a flight and wanna watch two movies during this flight.
 * You are given int[] movie_duration which includes all the movie durations.
 * You are also given the duration of the flight which is d in minutes.
 * Now, you need to pick two movies and the total duration of the two movies is
 * less than or equal to (d - 30min).
 * Find the pair of movies with the longest total duration.
 * If multiple found, return the pair with the longest movie.
 *
 * <p>
 * Example 1:
 *
 * Input: movie_duration = [90, 85, 75, 60, 120, 150, 125], d = 250
 * Output: [90, 125]
 * Explanation: 90min + 125min = 215 is the maximum number within 220 (250min - 30min)
 * </p>
 */

public class Amazon1 {

  public int[] chooseMovie(int[] movies, int flightDuration) {
    int[] ans = new int[2];
    int start = 0;
    int end = movies.length - 1;
    int tar = flightDuration - 30;
    int currMax = Integer.MIN_VALUE;
    Arrays.sort(movies);

    while (start < end) {
      if (movies[start] + movies[end] <= tar) {
        if (movies[start] + movies[end] > currMax) {
          ans[0] = movies[start];
          ans[1] = movies[end];
          currMax = movies[start] + movies[end];
        }
        start++;
      }
      if (movies[start] + movies[end] > tar) {
        end--;
      }
    }
    return ans;
  }
}
