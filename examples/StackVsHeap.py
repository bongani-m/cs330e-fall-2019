#!/usr/bin/env python

# --------------
# StackVsHeap.py
# --------------

from sys import getrecursionlimit, setrecursionlimit

def f (n) :
    if n == 0 :
        return 0
    return 1 + f(n - 1)

print("StackVsHeap.py")

try :
    assert f(123) == 123
except RuntimeError :
    assert False

try :
    assert f(1234) == 1234
    assert False
except RuntimeError as e :
    assert e.args == ("maximum recursion depth exceeded",)

assert getrecursionlimit() == 1000
setrecursionlimit(10000)
assert getrecursionlimit() == 10000

try :
    assert f(1234) == 1234
except RuntimeError :
    assert False

print("Done.")
