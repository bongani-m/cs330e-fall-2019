#!/usr/bin/env python3

# ------
# Chain.py
# ------

# chain(iter1, iter2, ...)
# -----------------
# Chain make an iterator that returns elements from the first iterable
# until it is exhausted, then proceeds to the next iterable, until all
# of the iterables are exhausted.
# Used for treating consecutive sequences as a single sequence
class chain_class :
    def __init__ (self, *a) :
        self.p = iter(a)          # iterator over the outer iterable
        self.q = iter([])         # iterator over the inner iterables

    def __iter__ (self) :
        return self

    def __next__ (self) :
        try :
            j = next(self.q)      # value of the inner iterables
        except StopIteration :
            i = next(self.p)      # value of the outer iterable, an inner iterable
            while not i :
                i = next(self.p)
            self.q = iter(i)
            j      = next(self.q)
        return j
