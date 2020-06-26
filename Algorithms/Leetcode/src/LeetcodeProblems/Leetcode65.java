package LeetcodeProblems;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 * However, here is a list of characters that can be in a valid decimal number:
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 */

class Leetcode65 {

  public boolean isNumber(String s) {
    NumberValid nv =
  }
}

interface NumberValidate {
  boolean validate(String s);
}

abstract class NumberValidBasic implements NumberValidate {

  public boolean validate(String s) {
    if (isStringEmpty(s)) {
      return false;
    }
    s = trimString(s);
    if (s.length() == 0) {
      return false;
    }
    return doValidate(s);
  }

  private boolean isStringEmpty(String s) {
    if (s.equals("")) {
      return true;
    }
    return false;
  }

  private String trimString(String s) {
    s = s.trim();
    if (s.startsWith("+") || s.startsWith("-")) {
      s = s.substring(1);
    }

    return s;
  }

  protected abstract boolean doValidate(String s);
}

class IntegerValidate extends NumberValidBasic {

  protected boolean doValidate(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}

class FloatValidate extends NumberValidBasic {
  protected boolean doValidate(String s) {
    int pos = s.indexOf(".");
    if (pos == - 1) {
      return false;
    }
    if (s.length() == 1) {
      return false;
    }
    NumberValidate nv = new IntegerValidate();
    String first = s.substring(0, pos);
    String second = s.substring(pos + 1, s.length());
    if (validateFirst(first) || validateSecond(second)) {
      return true;
    }
    return false;
  }

  private boolean validateFirst(String s) {
    if (!s.equals("") && !checkPart(s)) {
      return false;
    }
    return true;
  }

  private boolean checkPart(String s) {
    if (!Character.isDigit(s.charAt(0)) || !Character.isDigit(s.charAt(s.length() - 1))) {
      return false;
    }

    NumberValidate nv = new IntegerValidate();
    if (!nv.validate(s)) {
      return false;
    }
    return true;
  }
}

class scienceFormatValidate extends NumberValidBasic {

  protected boolean doValidate(String s) {
    s = s.toLowerCase();
    int pos = s.indexOf("e");
    if (pos == -1) {
      return false;
    }
    if (s.length() == 1) {
      return false;
    }
    String first = s.substring(0, pos);
    String second = s.substring(pos + 1, s.length());
    if (!validateFirst(first) || !validateSecond(second)) {
      return false;
    }
    return true;
  }

  private boolean validateFirst(String str) {
    if (str.equals("")) {
      return false;
    }
    if (!checkSpace(str)) {
      return false;
    }
    NumberValidate intergerValid = new IntegerValidate();
    NumberValidate floatValid = new FloatValidate();
    if (!intergerValid.validate(str) && !floatValid.validate(str)) {
      return false;
    }
    return true;
  }

  private boolean checkSpace(String s) {
    if (s.startsWith(" ") || s.endsWith(" ")) {
      return  false;
    }
    return true;
  }

  private boolean validateSecond(String str) {

  }
}
