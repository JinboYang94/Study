package LeetcodeProblems;

/**
 * Another way using array.
 */

class Leetcode208b {

  private TrieNodeB head;

  /**
   * Initialize data structure.
   */
  public Leetcode208b() {
    head = new TrieNodeB();
  }

  /**
   * Insert a word into the trie.
   * @param word a word in lowercase.
   */
  public void insert(String word) {
    TrieNodeB node = head;
    for (char ch : word.toCharArray()) {
      if (node.children[ch - 'a'] == null) {
        node.children[ch - 'a'] = new TrieNodeB();
      }
      node = node.children[ch - 'a'];
    }
    node.isEnd = true;
  }

  /**
   * Returns if the word is in the trie.
   * @param word a word in lowercase.
   * @return true of false.
   */
  public boolean search(String word) {
    TrieNodeB node = head;
    for (char ch: word.toCharArray()) {
      if (node.children[ch - 'a'] == null) {
        return false;
      } else {
        node = node.children[ch - 'a'];
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
    TrieNodeB node = head;
    for (char ch : prefix.toCharArray()) {
      if (node.children[ch - 'a'] == null) {
        return false;
      } else {
        node = node.children[ch - 'a'];
      }
    }
    return true;
  }
}

class TrieNodeB {

  boolean isEnd = false;
  TrieNodeB[] children = new TrieNodeB[26];

  public TrieNodeB() {}
}
