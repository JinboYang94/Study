package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * <p>
 * Example:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * </p>
 */

class Leetcode127 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    int ans = 0;
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    boolean found = false;
    Set<String> pool = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    while (!queue.isEmpty()) {
      int size = queue.size();
      Set<String> subVisited = new HashSet<>();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        List<String> neighbour = getNeighbour(curr, pool);
        for (String str : neighbour) {
          if (!visited.contains(str)) {
            if (str.equals(endWord)) {
              subVisited.add(str);
              found = true;
              break;
            }
            subVisited.add(str);
            queue.offer(str);
          }
        }
      }
      // this level added something, ans length++
      if (subVisited.size() > 0) {
        ans++;
      }
      visited.addAll(subVisited);
      if (found) {
        ans++;
        break;
      }
    }
    return ans;
  }

  private List<String> getNeighbour(String s, Set<String> pool) {
    List<String> ret = new ArrayList<>();
    char[] chArray = s.toCharArray();

    for (int i = 0; i < chArray.length; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        if (chArray[i] == ch) {
          continue;
        }
        char temp = chArray[i];
        chArray[i] = ch;
        if (pool.contains(String.valueOf(chArray))) {
          ret.add(String.valueOf(chArray));
        }
        chArray[i] = temp;
      }
    }
    return ret;
  }
}
