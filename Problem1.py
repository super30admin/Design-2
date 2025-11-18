"""
DESIGN QUEUES USING STACKS
https://leetcode.com/problems/implement-queue-using-stacks/description/
"""

#Time complexity:
# push: O(1)
# pop: O(1)
# peek: O(1)
# empty_stack: O(1)

#Space Complexity: O(n)
class MyQueue(object):

    def __init__(self):
        # in_stack for enqueue, out_stack for dequeue
        self.in_stack = []
        self.out_stack = []

    def push(self, x):
        """
        Enqueue element x to the back of queue
        :type x: int
        :rtype: None
        """
        self.in_stack.append(x)

    def pop(self):
        """
        Dequeue element from the front of queue
        :rtype: int
        """
        self._shift_stacks()
        if not self.out_stack:   # Edge case: queue empty
            return None
        return self.out_stack.pop()

    def peek(self):
        """
        Get the front element
        :rtype: int
        """
        self._shift_stacks()
        if not self.out_stack:   # Edge case: queue empty
            return None
        return self.out_stack[-1]

    def empty(self):
        """
        Returns whether the queue is empty
        :rtype: bool
        """
        return not self.in_stack and not self.out_stack

    def _shift_stacks(self):
        """
        Helper function:
        Move elements from in_stack to out_stack if out_stack is empty
        Ensures correct FIFO order
        """
        if not self.out_stack:  # only shift when out_stack is empty
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())