package LeetcodeProblems;

/**
 * A two pointer solution.
 */

class Leetcode151b {

  public String reverseWords(String s) {
    if (s == null) {
      return null;
    }
    char[] array = s.toCharArray();
    int len = array.length;

    reverse(array, 0, len - 1);
    reverseAll(array, len);
    return cleanSpaces(array, len);
  }

  private void reverse(char[] array, int start, int end) {
    while (start < end) {
      char temp = array[start];
      array[start++] = array[end];
      array[end--] = temp;
    }
  }

  private void reverseAll(char[] array, int len) {
    int i = 0;
    int j = 0;

    while (i < len) {
      // skip spaces
      while (i < j || i < len && array[i] == ' ') {
        i++;
      }
      // skip non spaces
      while (j < i || j < len && array[j] != ' ') {
        j++;
      }
      reverse(array, i, j - 1);
    }
  }

  private String cleanSpaces(char[] chars, int len) {
    int i = 0;
    int j = 0;

    while (j < len) {
      // skip spaces
      while (j < len && chars[j] == ' ') {
        j++;
      }
      // keep non spaces
      while (j < len && chars[j] != ' ') {
        chars[i++] = chars[j++];
      }
      // skip spaces
      while (j < len && chars[j] == ' ') {
        j++;
      }
      // leave only one space
      if (j < len) {
        chars[i++] = ' ';
      }
    }
    return new String(chars).substring(0, i);
  }
}
