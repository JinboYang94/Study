package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * Note:
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 * <p>
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 * </p>
 */

class Leetcode212 {

  public List<String> findWords(char[][] board, String[] words) {
    List<String> ans = new ArrayList<>();
    TrieNodeD root = buildGraph(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, root, ans, i, j);
      }
    }
    return ans;
  }

  private void dfs(char[][] board, TrieNodeD node, List<String> ans, int row, int col) {
    char ch = board[row][col];
    // if dfs to itself or no more children, quit dfs
    if (ch == '$' || node.graphNode[ch - 'a'] == null) {
      return;
    }
    // if a valid word found, add to ans.
    node = node.graphNode[ch - 'a'];
    if (node.word != null) {
      ans.add(node.word);
      node.word = null; // avoid duplicate
    }
    // dfs
    board[row][col] = '$';  // visited
    if (row > 0) {
      dfs(board, node, ans, row - 1, col);
    }
    if (row < board.length - 1) {
      dfs(board, node, ans, row + 1, col);
    }
    if (col > 0) {
      dfs(board, node, ans, row, col - 1);
    }
    if (col < board[0].length - 1) {
      dfs(board, node, ans, row, col + 1);
    }
    // restore
    board[row][col] = ch;
  }

  private TrieNodeD buildGraph(String[] words) {
    TrieNodeD root = new TrieNodeD();
    for (String word : words) {
      TrieNodeD temp = root;
      for (char ch : word.toCharArray()) {
        if (temp.graphNode[ch - 'a'] == null) {
          temp.graphNode[ch - 'a'] = new TrieNodeD();
        }
        temp = temp.graphNode[ch - 'a'];
      }
      temp.word = word;
    }
    return root;
  }
}

class TrieNodeD {

  TrieNodeD[] graphNode = new TrieNodeD[26];  // children
  String word;
}
