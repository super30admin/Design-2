

"""
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
"""

"""

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

"""


class MyQueue(object):

    def __init__(self):
        self.in_stack = []   # Stack to handle incoming elements
        self.out_stack = []  # Stack to handle outgoing (reversed) elements

    def push(self, x):
        """
        Push element to the back of the queue.
        """
        self.in_stack.append(x)

    def pop(self):
        """
        Removes the element from the front and returns it.
        """
        self.move()  # Make sure front is on out_stack
        return self.out_stack.pop()

    def peek(self):
        """
        Get the front element without removing it.
        """
        self.move()
        return self.out_stack[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        """
        return not self.in_stack and not self.out_stack

    def move(self):
        """
        Only if out_stack is empty, pour everything from in_stack into out_stack
        to reverse the order (so we get the oldest element on top).
        """
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
