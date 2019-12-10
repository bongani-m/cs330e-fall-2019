#!/usr/bin/env python3

from itertools import cycle

# ------
# Cycle.py
# ------

# cycle(p): iterates through a given iterable indefinitely until explicitly broken
def cycle_range_for(s) :
   if s :
      while True :
         for i in range(len(s)) :
            yield s[i]
   else :
      pass

def cycle_for(s) :
   if s :
      while True :
         for i in s :  
            yield i
   else :
      pass
      
def cycle_for (s) : # user-defined iterable
    p = iter(s)
    try :
        while True :
           w = next(p)
           yield w
    except StopIteration :
        pass
    