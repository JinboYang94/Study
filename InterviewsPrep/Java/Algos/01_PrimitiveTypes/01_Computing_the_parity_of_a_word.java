// x in binary number, parity is 1 if number of 1s in x is odd, 0 if number of 1s in x is even.
// e.g. 0000 1011 is 1
public short isParity(int x) {
  short ret = 0;
  // digit by digit check if 1
  while (x != 0) {
    ret ^= (x & 1);
    x >>> = 1;
  }
  return ret;
}
