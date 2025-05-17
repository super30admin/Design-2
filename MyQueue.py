# Time Complexity
# push: O(1)
# pop : O(N)
# peek: O(1)
# empty: O(1)
# Space Complexity : O(N) - sume of the space used by stack in and Stack out is eaual to O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use two stacks to simulate queue behavior (FIFO).
# Push to stack_in; for pop/peek, transfer to stack_out when it's empty to reverse order.



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
        self.move()
        return self.stack_out.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        self.move()
        return self.stack_out[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.stack_in and not self.stack_out
        
    def move(self):
        """
        Move elements from stack_in to stack_out if stack_out is empty.
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
