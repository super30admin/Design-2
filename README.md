# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
## 

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []
        
    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
            return self.outStack[-1]
            
    def empty(self) -> bool:
        return not self.inStack and not self.outStack

## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
class Node:
        def __init__(self, key: int, value: int):
            self.key = key
            self.value = value
            self.next = None
    
    def find(self, key: int, head: Node) -> Node:
        prev = head
        curr = head.next
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def getBucket(self, key: int) -> int:
        return hash(key)%self.buckets

    def __init__(self):
       self.buckets = 10000
       self.storage = [None] * self.buckets 

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = self.Node(-1,-1)        
        prev = self.find(key, self.storage[bucket])
        if prev.next == None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.find(key, self.storage[bucket])
        if prev.next == None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return
        prev = self.find(key, self.storage[bucket])
        if prev.next == None:
            return
        prev.next = prev.next.next



