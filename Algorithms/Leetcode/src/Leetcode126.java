import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each transformed word must exist in the word list.
 * Note that beginWord is not a transformed word.
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Tag: Dijkstra algorithm
 *
 * <p>
 * Example:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * </p>
 */

class Leetcode126 {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return ans;
    }
    // bfs: Dijkstra
    Queue<List<String>> queue = new LinkedList<>(); // store updated paths
    List<String> path = new ArrayList<>();  // path
    path.add(beginWord);
    queue.offer(path);
    boolean found = false;
    Set<String> words = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord); // already checked

    while (!queue.isEmpty()) {
      int size = queue.size();
      Set<String> subVisited = new HashSet<>(); // ? visited in this path, important
      // for each path in the queue
      for (int i = 0; i < size; i++) {
        List<String> currPath = queue.poll();
        // get the end String in this path
        String pathEnd = currPath.get(currPath.size() - 1);
        // get all possible changes(all neighbour String)
        List<String> neighbour = getNeighbour(pathEnd, words);
        // for each String linked to current node, see if matches endWord
        for (String str : neighbour) {
          if (!visited.contains(str)) {
            if (str.equals(endWord)) {  // find
              found = true;
              currPath.add(str);
              ans.add(new ArrayList<>(currPath));
              currPath.remove(currPath.size() - 1);
            } else {  // not find, add current String and path, also marked as subVisited
              currPath.add(str);
              queue.offer(new ArrayList<>(currPath));
              currPath.remove(currPath.size() - 1);
              subVisited.add(str);
            }
          }
        }
      }
      visited.addAll(subVisited);
      if (found) {
        break;
      }
    }
    return ans;
  }

  // find all neighbour of the String s
  private List<String> getNeighbour(String s, Set<String> pool) {
    List<String> ret = new ArrayList<>();
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        // skip s itself
        if (charArray[i] == c) {
          continue;
        }
        char temp = charArray[i];
        charArray[i] = c;
        // if change one character, it exists in word pool, store to return list
        if (pool.contains(String.valueOf(charArray))) {
          ret.add(String.valueOf(charArray));
        }
        charArray[i] = temp;
      }
    }
    return ret;
  }
}
