package OA.AmazonOA2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Amazon is partnering with the linguistics department at a local university to analyze important
 * works of English literature and identify patterns in word usage across different eras.
 * To ensure a cleaner output. the linguistics department has provided a list of commonly used words
 * (e.g., “an”, “the”. etc.) to exclude from the analysis. In the context of this search,
 * a word is an alphabetic sequence of characters having no whitespace or punctuation.
 * Write an algorithm to find the most frequently used word in the text excluding the
 * commonly used words.
 * Input:
 * The input to the function/method consists of two arguments:
 * literatureText: a string representing the block of text,
 * wordsToExclude: a list of strings representing the commonly used words to be excluded while
 * analyzing the word frequency.
 * Output:
 * Return a list of strings representing the most frequently used word in the text or
 * in case of a tie, all of the most frequently used words in the text..
 * Note:
 * Words that have a different case are counted as the same word.
 * The order of words does not matter in the output list.
 * All words in the ‘wordsToExclude’ list are unique. Punctuation should be treated as white space.
 *
 * <p>
 * Example
 * Input :
 * literature Text = “Jack and Jill went to the market to buy bread and cheese.
 *                    Cheese is Jack’s and Jill’s favorite food.”
 * wordsToExclude = [“and”, “he”, “the”, “to”, “is”. “Jack”, “Jill”]
 * Output :
 * [“cheese”, “s”]
 *
 * Explanation :
 * The word `and" has a maximum of three frequency but this word should be excluded
 * while analyzing the word frequency. The words “Jack’. 'Jill”, “s”, “to” and “cheese” have
 * the next maximum frequency(two) in the given text but the words “Jack”, “to” and "Jill’
 * should be excluded as these are commonly used words which you are not interested to include.
 * </p>
 */

public class Amazon6 {

  public List<String> wordFilter(String text, List<String> commonWords) {
    // lower case
    text = text.toLowerCase();
    List<String> commonLower = new ArrayList<>();
    for (String str : commonWords) {
      commonLower.add(str.toLowerCase());
    }
    // set up
    List<String> ans = new ArrayList<>();
    Map<String, Integer> times = new HashMap<>();
    // split with regex
    String[] words = text.split("[ !?',;.]+");
    // count
    for (String word : words) {
      if (commonLower.contains(word)) {
        continue;
      } else {
        if (!times.containsKey(word)) {
          times.put(word, 1);
        } else {
          times.put(word, times.get(word) + 1);
        }
      }
    }
    // find largest one
    String temp = null;
    for (String word : times.keySet()) {
      if (times.get(word) >= times.getOrDefault(temp, 0)) {
        if (times.get(word) > times.getOrDefault(temp, 0)) {
          temp = word;
          ans.clear();
        }
        ans.add(word);
      }
    }
//    ans.add(temp);
    // find all largest ones
//    for (String word : times.keySet()) {
//      if (!word.equals(temp) && times.get(word).equals(times.get(temp))) {
//        ans.add(word);
//      }
//    }

    return ans;
  }
}
