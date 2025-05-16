"""
Time Complexity
#   push(x)   -> O(1)
#   pop()     -> O(1)
#   peek()    -> O(1)
#   empty()   -> O(1)

Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# Using two stacks where elements are reversed from stack1 to stack2 only when needed.
"""

class MyQueue(object):

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if not self.stack1:
            self.front = x
        self.stack1.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self):
        """
        :rtype: int
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.stack1 and not self.stack2


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()