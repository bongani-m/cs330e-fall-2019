#!/usr/bin/env python3

# ---------
# Lambda.py
# ---------

from functools import reduce

print("Lambda.py")

def add (x, y) :
    return x + y

assert add(2, 3)                 == 5
assert reduce(add, [2, 3, 4], 0) == 9

assert (lambda x, y : x + y)(2, 3)               == 5
assert reduce(lambda x, y : x + y, [2, 3, 4], 0) == 9

print("Done.")
