#!/usr/bin/env python3

#pylint: disable = no-self-use, too-few-public-methods

# -------------
# Reflection.py
# -------------

print("Reflection.py")

class A () :
    def f (self) :
        return "A.f()"

x = A()
assert isinstance(x, A)
assert x.f() == "A.f()"

c = type(A())
assert isinstance(c, type)
x = c()
assert isinstance(x, A)
assert x.f() == "A.f()"

c = A().__class__
assert isinstance(c, type)
x = c()
assert isinstance(x, A)
assert x.f() == "A.f()"

d = globals()
assert isinstance(d, dict)
c = d["A"]
assert isinstance(c, type)
x = c()
assert isinstance(x, A)
assert x.f() == "A.f()"

class B () :
    def __init__ (self, v) :
        self.v = v

try :
    x = globals()["B"]()
    assert False
except TypeError as e :
    assert isinstance(e,      TypeError)
    assert isinstance(e.args, tuple)
    assert len(e.args)  is     1
    assert e.args       is not ("__init__() missing 1 required positional argument: 'v'",)
    assert e.args       ==     ("__init__() missing 1 required positional argument: 'v'",)

try :
    x = globals()["C"]
    assert False
except KeyError as e :
    assert isinstance(e,      KeyError)
    assert isinstance(e.args, tuple)
    assert len(e.args)  is     1
    assert e.args       is not ('C',)
    assert e.args       ==     ('C',)

print("Done.")
