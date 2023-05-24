# Time Complexity: O(1) for push and empty. O(n) for pop and peek. 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class MyQueue(object):
    def __init__(self):
        self.input = []
        self.output = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.input.append(x)

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.output.pop()
        
    def peek(self):
        """
        :rtype: int
        """
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        return self.output[-1]
        
    def empty(self):
        """
        :rtype: bool
        """
        return not self.input and not self.output
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()