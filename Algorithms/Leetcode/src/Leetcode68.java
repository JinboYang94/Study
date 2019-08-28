import java.util.ArrayList;
import java.util.List;
/**
 * Given an array of words and a width maxWidth,
 * format the text such that each line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text,
 * it should be left justified and no extra space is inserted between words.
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * <p>
 *  Example:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * </p>
 */

class Leetcode68 {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int index = 0;

    while (index < words.length) {
      int ct = words[index].length(); // total word length for this line
      int last = index + 1; // index of last word in this line
      while (last < words.length) {
        if (words[last].length() + ct + 1 > maxWidth) { // if out of bound, break
          break;
        }
        ct += 1 + words[last].length(); // each loop add a space and a word to count(ct)
        last++; // update the last index
      }

      StringBuilder sb = new StringBuilder();
      sb.append(words[index]);
      int diff = last - index - 1;  // number of words not yet appended in this line

      if (last == words.length || diff == 0) {  // if last line or only one word in line
        for (int i = index + 1; i < last; i++) {  // if last line, add space between each word
          sb.append(" ");
          sb.append(words[i]);
        }
        for (int i = sb.length(); i < maxWidth; i++) {  // add space until this line full capacity
          sb.append(" ");
        }
      } else {  // if not last line
        int space = (maxWidth - ct) / diff; // total spaces be evenly distributed after each word
        int extra = (maxWidth - ct) % diff;// total spaces left waiting for adding from left until 0
        for (int i = index + 1; i < last; i++) {
          for (int k = space; k > 0; k--) { // add same amount spaces for each word
            sb.append(" ");
          }
          if (extra > 0) {  // if extra spaces left, add one space after this word
            sb.append(" ");
            extra--;
          }
          sb.append(" "); // because ct has a space, here make it up
          sb.append(words[i]);  // next word
        }
      }
      ans.add(sb.toString());
      index = last; // set next line's start index as last
    }
    return ans;
  }
}
