import re
s = "b \na3"
a = re.split(".", s)                                           # any character
#assert isinstance(a, list)
#assert a == ['', '', '', '', '\n', '', '', '', '', '', '', '']
print(a)

s = "ab\na123"
a = re.split("3$", s) 
print(a)

s = "ab\nba123"
a = re.split("ab", s)
print(a)