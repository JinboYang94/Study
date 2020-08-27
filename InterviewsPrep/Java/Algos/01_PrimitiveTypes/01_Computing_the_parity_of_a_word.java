// x in binary number, parity is 1 if number of 1s in x is odd, 0 if number of 1s in x is even.
// e.g. 0000 1011 is 1. O(n)
public short isParity(long x) {
  short ret = 0;
  // digit by digit check if 1
  while(x != 0) {
    ret ^= (x & 1);
    x >>> = 1;
  }
  return ret;
}

// solution b, trick: x & (x - 1) drops the rightmost 1 of x. O(k), k is number of 1 in x
public short isParity2(long x) {
  short ret = 0;
  while(x != 0) {
    x &= x - 1;
    ret ^= 1; // every time remove a 1, update parity is 0 or 1
  }
}

// solution c, complex 
