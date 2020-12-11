package OA.Others;

public class XingYeShuJin {

  // wrong for negative input, need update
  public String changeFormatNumber(String number) {
    int strToNum = 0;
    int ct = 1;
    boolean flag = true;
    for (int i = number.toCharArray().length - 1; i >= 0; i--) {
      // sign handle
      if (i == 0 && number.toCharArray()[i] == '-') {
        flag = false;
        continue;
      }
      char temp = number.toCharArray()[i];
      strToNum += Integer.parseInt(String.valueOf(temp)) * ct;
      ct *= 10;
      // boundary
      if (i == 1 && (Integer.MAX_VALUE / 10 < strToNum || Integer.MIN_VALUE / 10 > strToNum)) {
        return "NODATA";
      }
      // digit validation
      if (!Character.isDigit(temp)) {
        return "INPUTERROR";
      }
    }
    // start transit
    // binary
    StringBuilder binary = new StringBuilder();
    int curr = strToNum;
    while (curr != 0) {
      int div = curr / 2;
      int mod = curr % 2;
      if (!flag) {
        mod = Math.abs(1 - mod);
      }
      String temp = String.valueOf(mod);
      binary.append(temp);
      curr = div;
    }
    StringBuilder binaryRet = new StringBuilder();
    if (binary.toString().length() < 16) {
      for (int i = 0; i < 16 - binary.toString().length(); i++) {
        binaryRet.append('0');
      }
    }
    // hex
    StringBuilder hex = new StringBuilder();
    while (strToNum != 0) {
      int div = strToNum / 16;
      int mod = strToNum % 16;
      String temp = "";
      if (mod < 10) {
        temp = String.valueOf(mod);
      } else {
        if (mod == 10) {
          temp = "A";
        }
        if (mod == 11) {
          temp = "B";
        }
        if (mod == 12) {
          temp = "C";
        }
        if (mod == 13) {
          temp = "D";
        }
        if (mod == 14) {
          temp = "E";
        }
        if (mod == 15) {
          temp = "F";
        }
      }
      hex.append(temp);
      strToNum = div;
    }
    StringBuilder hexRet = new StringBuilder();
    if (hex.toString().length() < 4) {
      for (int i = 0; i < 4 - hex.toString().length(); i++) {
        hexRet.append('0');
      }
    }
    return binaryRet.append(binary) + "," + hexRet.append(hex);
  }
}
