# Time Complexity : Amortized O(1) for all operations except empty which is strict O(1)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode Yes:
# Any problem you faced while coding this : No


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class Stack:
    def __init__(self, default = None) -> None:
        self.head = None
        self.default = default
        self.size = 0
    def push(self,data):
        new = Node(data)
        if self.head is None: self.head = new
        else:
            new.next = self.head
            self.head = new
        self.size += 1
    def pop(self):
        if self.head is None: return self.default
        data = self.head.data
        self.head = self.head.next
        self.size -= 1
        return data
    def empty(self):
        return self.head is None
    def peek(self):
        if self.empty(): return self.default
        else: return self.head.data
class MyQueue:
    def __init__(self):
        self.stack1 = Stack()
        self.stack2 = Stack()
        self.first = None
    def push(self, x):
        if self.stack1.empty(): self.first = x
        self.stack1.push(x)
    def __move(self):
        if self.stack2.empty():
            while not self.stack1.empty():
                self.stack2.push(self.stack1.pop())
    def pop(self):
        self.__move()
        return self.stack2.pop()
    def peek(self):
        if self.stack2.empty(): return self.first
        return self.stack2.peek()
    def empty(self):
        return self.stack1.size + self.stack2.size == 0