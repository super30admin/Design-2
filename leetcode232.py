#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb  4 20:57:54 2026

@author: rishigoswamy

    Approach:
    ----------
    We implement a queue using two stacks: an input stack for enqueue operations
    and an output stack for dequeue and peek operations.
    Elements are pushed onto the input stack, and only when the output stack is
    empty do we transfer all elements from the input stack to the output stack,
    thereby reversing their order to maintain FIFO behavior.
    
    Time Complexity:
    ----------------
    push  : O(1)
    pop   : O(1) amortized
    peek  : O(1) amortized
    empty : O(1)
    
    Space Complexity:
    -----------------
    O(n), where n is the number of elements stored across the two stacks.

"""

class MyQueue:

    def __init__(self):
        self.inputStack = []
        self.outputStack = []
        

    def push(self, x: int) -> None:
        self.inputStack.append(x)
        

    def pop(self) -> int:
        if self.outputStack:
            return self.outputStack.pop()
        else:
            while self.inputStack:
                self.outputStack.append(self.inputStack.pop())
            return self.outputStack.pop()
        

    def peek(self) -> int:
        if self.outputStack:
            return self.outputStack[-1]
        else:
            while self.inputStack:
                self.outputStack.append(self.inputStack.pop())
            return self.outputStack[-1]
        
    def empty(self) -> bool:
        return not self.outputStack and not self.inputStack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()