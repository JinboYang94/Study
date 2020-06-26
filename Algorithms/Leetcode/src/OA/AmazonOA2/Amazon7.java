package OA.AmazonOA2;

import java.util.Comparator;
import java.util.List;

/**
 * You have been given a task of recording some data 40M a log file. In the log file,
 * every line is a space-delimited list of strings. All lines begin with an alphanumeric identifier.
 * There will be no lines consisting only of an identifier.
 * After the alphanumeric identifier a line will consist of either:
 * - a list of words using only lowercase English letters
 * - or list of only integers.
 * You have to reorder the data such that all of the lines with words are at the top of the
 * log file. The lines with words are ordered lexicographically.
 * ignoring the identifier except in the case of ties In the case of ties
 * (if there are two lines that are identical except for the identifier) the identifier is used to
 * order lexicographically. Alphanumeric should be sorted in ASCII order
 * (numbers come before letters) The identifiers most still be pan of the lines in the
 * output Strings. Lines with integers must be left in the original order they were in the file.
 * Write an algorithm to reorder the data in the log file, according to the rules above.
 * Input:
 * The input to the function/method consists of two argument
 * logFileSize, an integer representing the number of log lines.
 * logLines, a list of strings representing the log file.
 * Output:
 * Return a list of strings representing the reordered log file data.
 * Note:
 * Identifier consists of only lower case english character and numbers.
 *
 * <p>
 * Example:
 *
 * Input:
 * logFileSize = 5
 * logLines =
 * [a1 9 2 3 1]
 * [g1 act car] [zo4 4 7]
 * [ab1 off key dog]
 * [a8 act zoo]
 *
 * Output:
 * [g1 act car]
 * [a8 act zoo]
 * [ab1 off key dog]
 * [a1 9 2 3 1]
 * [zo4 4 7]
 * </p>
 */

public class Amazon7 {

  public List<String> sortLogFiles(int number, List<String> logFiles) {
    Comparator<String> newComparator = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int space1 = s1.indexOf(" ");
        int space2 = s2.indexOf(" ");
        char char1 = s1.charAt(space1 + 1);
        char char2 = s2.charAt(space2 + 1);
        if (char1 <= '9') {
          if (char2 <= '9') {
            return 0;
          } else {
            return 1;
          }
        }
        if (char2 <= '9') {
          return -1;
        }
        int res = s1.substring(space1 + 1).compareTo(s2.substring(space2 + 1));
        if (res == 0) {
          return s1.substring(0, space1).compareTo(s2.substring(0, space2));
        }
        return res;
      }
    };

    // String[] temp = logFiles.toArray(new String[number]);
    // Arrays.sort(temp, newComparator);
    // return Arrays.asList(temp);

    // Collections.sort(logFiles, newComparator);
    logFiles.sort(newComparator);
    return logFiles;
  }
}
