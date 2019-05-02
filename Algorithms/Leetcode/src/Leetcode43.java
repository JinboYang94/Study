/**
 * This one uses String to represent answer.
 */

class Leetcode43 {

  public String multiply(String num1, String num2) {
    if (num1.length() == 0 || num2.length() == 0) {
      return "0";
    }

    int[] temp = new int[num1.length() + num2.length()];
    StringBuilder ans = new StringBuilder();

    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        int partialProduct = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int idx1 = i + j;
        int idx2 = i + j + 1;
        int sum = partialProduct + temp[idx2];
        temp[idx1] += sum / 10; // carry
        temp[idx2] = sum % 10;
      }
    }

    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == 0 && ans.length() == 0) {
        continue;
      }
      ans.append(temp[i]);
    }

    return ans.length() == 0 ? "0" : ans.toString();
  }
}
