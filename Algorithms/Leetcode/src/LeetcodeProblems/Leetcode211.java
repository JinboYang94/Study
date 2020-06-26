package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing
 * only letters a-z or .. A . means it can represent any one letter.
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * <p>
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * </p>
 */

class Leetcode211 {

  TrieNodeC head;

  /**
   * Initialize your data structure here.
   */
  public Leetcode211() {
    head = new TrieNodeC();
  }

  /**
   * Add a word into data structure.
   * @param word string.
   */
  public void addWord(String word) {
    TrieNodeC node = head;
    for (char ch : word.toCharArray()) {
      if (!node.mapNode.containsKey(ch)) {
        node.mapNode.put(ch, new TrieNodeC());
      }
      node = node.mapNode.get(ch);
    }
    node.isEnd = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   * @param word string.
   * @return true or false.
   */
  public boolean search(String word) {
    return dfsSearch(word, head, 0);
  }

  private boolean dfsSearch(String word, TrieNodeC node, int index) {
    if (index == word.length()) {
      return node.isEnd;
    }
    char[] charArray = word.toCharArray();
    if (charArray[index] != '.') {
      return node.mapNode.get(charArray[index]) != null
          && dfsSearch(word, node.mapNode.get(charArray[index]), index + 1);
    } else {
      for (Character ch : node.mapNode.keySet()) {
        if (node.mapNode.get(ch) != null) {
          if (dfsSearch(word, node.mapNode.get(ch), index + 1)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

class TrieNodeC {

  Map<Character, TrieNodeC> mapNode;
  boolean isEnd = false;

  public TrieNodeC() {
    mapNode = new HashMap<>();
  }
}
