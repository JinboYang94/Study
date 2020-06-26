package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * <p>
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * </p>
 */

class Leetcode208 {

  private TrieNode head;

  /**
   * Initialize data structure.
   */
  public Leetcode208() {
    head = new TrieNode();
  }

  /**
   * Insert a word into the trie.
   * @param word a word in lowercase.
   */
  public void insert(String word) {
    if (word == null) {
      return;
    }
    TrieNode node = head;
    for (char ch : word.toCharArray()) {
      if (!node.charNode.containsKey(ch)) {
        node.charNode.put(ch, new TrieNode());
      }
      node = node.charNode.get(ch);
    }
    node.isEnd = true;
  }

  /**
   * Returns if the word is in the trie.
   * @param word a word in lowercase.
   * @return true of false.
   */
  public boolean search(String word) {
    if (word == null) {
      return false;
    }
    TrieNode node = head;
    for (char ch : word.toCharArray()) {
      if (!node.charNode.containsKey(ch)) {
        return false;
      } else {
        node = node.charNode.get(ch);
      }
    }
    return node.isEnd;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   * @param prefix a prefix.
   * @return true or false.
   */
  public boolean startsWith(String prefix) {
    if (prefix == null) {
      return false;
    }
    TrieNode node = head;
    for (char ch : prefix.toCharArray()) {
      if (!node.charNode.containsKey(ch)) {
        return false;
      } else {
        node = node.charNode.get(ch);
      }
    }
    return true;
  }
}

class TrieNode {

  Map<Character, TrieNode> charNode;
  boolean isEnd = false;

  public TrieNode() {
    charNode = new HashMap<>();
  }
}
