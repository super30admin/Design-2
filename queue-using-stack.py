# // Time Complexity : O(1) amortized
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA

class MyQueue(object):
    def __init__(self):
        self.stack_in =[]
        self.stack_out=[]

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
        self.peek()
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
        return not bool( self.stack_in or self.stack_out)