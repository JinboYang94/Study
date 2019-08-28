import java.util.ArrayList;
import java.util.List;

/**
 * Using another method, separately divide problem into several functions
 */

class Leetcode68b {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int left = 0;

    while (left < words.length) {
      int right = findRight(left, words, maxWidth);
      ans.add(justify(left, right, words, maxWidth));
      left = right + 1;
    }

    return ans;
  }

  private int findRight(int left, String[] words, int maxWidth) {
    int right = left;
    int sum = words[right++].length();
    while (right < words.length && (sum + 1 +  words[right].length()) <= maxWidth) {
      sum += 1 + words[right++].length();
    }
    return right  - 1;
  }

  private String justify(int left, int right, String[] words, int maxWidth) {
    if (right - left == 0) {
      return fillAns(words[left], maxWidth);
    }
    boolean isLastLine = right == words.length - 1;
    int spaces = right - left;
    int totalSpace = maxWidth - wordsLength(left, right, words);

    String space = isLastLine ? " " : blank(totalSpace / spaces);
    int remainder = isLastLine ? 0 : totalSpace % spaces;

    StringBuilder sb = new StringBuilder();
    for (int i = left; i <= right; i++) {
      sb.append(words[i]);
      sb.append(space);
      sb.append(remainder-- > 0 ? " " : "");
    }
    return fillAns(sb.toString().trim(), maxWidth);
  }

  private int wordsLength(int left, int right, String[] words) {
    int wordsLength = 0;
    for (int i = left; i <= right; i++) {
      wordsLength += words[i].length();
    }
    return wordsLength;
  }

  private String fillAns(String noSpace, int maxWidth) {
    return noSpace + blank(maxWidth - noSpace.length());
  }

  // \0 == \u0000, means null character
  private String blank(int length) {
    return new String(new char[length]).replace('\0', ' ');
  }
}
