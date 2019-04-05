/**
 * Tag: Iterative
 */

class Leetcode38b {

  public String countAndSay(int n) {
    String ans = "1";

    for (int i = 2; i <= n; i++) {  // from n = 2 to given n
      StringBuilder sb = new StringBuilder(); // each n has a StringBuilder
      char[] ansToChar = ans.toCharArray();   // ans to char array

      int index = 0;   // index for ansToChar
      for ( ; index < ansToChar.length; index++) {  // loop all char in ansToChar
        int repeatTimes = 1;  // count repeat times of each char
        while (index + 1 < ansToChar.length && ansToChar[index] == ansToChar[index + 1]) {
          repeatTimes++;  // if [index] == [index  + 1], means duplicate
          index++;
        }
        sb.append(Integer.toString(repeatTimes) + ansToChar[index]);  // append to sb
      }

      ans = sb.toString();  // give sb to ans
    }

    return ans;
  }
}
