# Time Complexity : Ammortized - O(1) for the push,empty functions, O(n) for pop and peek functions
# Space Complexity : O(n), where n is the size of stack
# Did this code successfully run on Leetcode : Yes , LC 232
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyQueue(object):

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if self.stack2:
            while self.stack2:
                self.stack1.append(self.stack2.pop())
        self.stack1.append(x)
        while self.stack1:
            self.stack2.append(self.stack1.pop())

    def pop(self):
        """
        :rtype: int
        """
        if self.stack2:
            return self.stack2.pop()

    def peek(self):
        """
        :rtype: int
        """
        return self.stack2[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.stack2) == 0