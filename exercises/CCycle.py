#!/usr/bin/env python3

from itertools import cycle

# ------
# CCycle.py
# ------

# cycle(p): iterates through a given iterable indefinitely until explicitly broken
class cycle_class() :
   def __init__(self, s) :
      self.s = s
      self.i = 0
      self.size = len(s)
   
   def __iter__(self) :
      return self
      
   def __next__(self) :
      if self.size == 0 :
         return [] 
      else :          
         j = self.i
         self.i += 1
         if self.i == self.size : 
            self.i = 0
         return self.s[j]
 