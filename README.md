# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        # self.counter = 0
        self.main_stack = []
        self.buffer_stack = []

    def push(self, x: int) -> None:
        self.main_stack.append(x)

    def pop(self) -> int:
        self.transfer_to_buffer()
        return self.buffer_stack.pop()

    def peek(self) -> int:
        self.transfer_to_buffer()
        return self.buffer_stack[-1]

    def empty(self) -> bool:
        return not self.main_stack and not self.buffer_stack

    def transfer_to_buffer(self):
        if not self.buffer_stack:
            while self.main_stack:
                self.buffer_stack.append(self.main_stack.pop())


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyHashMap:
    class Node: 
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.size = 10000
        self.table = [None for _ in range(self.size)]

    def hash(self, value):
        return value % self.size   

    def put(self, key: int, value: int) -> None:
        # hash the key
        index = self.hash(key)
        # is there a node? : init dummy 
        if self.table[index] is None: self.table[index] = self.Node(-1, -1)

        prev = self._find(self.table[index], key)

        if prev.next: 
            prev.next.value = value
        else:
            prev.next = self.Node(key, value)
        
    def get(self, key: int) -> int:
        index = self.hash(key)
        if self.table[index] is None: 
            return -1
        
        prev = self._find(self.table[index], key)

        if prev.next: 
            return prev.next.value
        return -1

    def remove(self, key: int) -> None:
        index = self.hash(key)
        if self.table[index] is None: 
            return
        
        prev = self._find(self.table[index], key)
        if prev.next:
            prev.next = prev.next.next

    def _find(self,head,key):
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev



