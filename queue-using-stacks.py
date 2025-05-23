"""
# Time Complexity :
- init: O(1)
- push: O(1)
- pop: O(1)
- peek: O(1)
- empty: O(1)
# Space Complexity :
- O(n)
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : No
"""

class MyQueue(object):

    def __init__(self):
        self.stack_in = []
        self.stack_out = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack_in.append(x)        

    def pop(self):
        """
        :rtype: int
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.stack_in and not self.stack_out

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()