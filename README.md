# Design-2

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()
    
    def peek(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

    def empty(self) -> bool:
        return (not self.s1) and (not self.s2)


## Problem 2:(https://leetcode.com/problems/design-hashset/)
class MyHashSet:

    def __init__(self):
        self.capacity = 1000
        self.s = [[] for i in range(self.capacity)]
    
    def hashfunc(self,key):
        return key%self.capacity 

    def add(self, key: int) -> None:
        hashfunc = self.hashfunc(key)
        if not self.contains(key):
            self.s[hashfunc].append(key)
        
    def remove(self, key: int) -> None:
        hashfunc = self.hashfunc(key)
        if self.contains(key):
            self.s[hashfunc].remove(key)

    def contains(self, key: int) -> bool:
        hashfunc = self.hashfunc(key)
        return (key in self.s[hashfunc])



