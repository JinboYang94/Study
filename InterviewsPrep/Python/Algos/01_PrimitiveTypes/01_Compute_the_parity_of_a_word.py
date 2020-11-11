def parity(x):
    ret = 0
    while x:
        ret ^= x & 1
        x >>= 1
    return ret

