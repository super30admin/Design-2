"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :No
Your code here along with comments explaining your approach:
I have used 2 stacks to implement a queue. Here push is O(1) complexity as we only append the element to top of 
stack1. In case we need to pop, if stack2 is empty, we keep on popping elements from stack1 and keep appending
to stack2 until only 1 element is left and we return that. In case, stack2 is not empty, that means we 
already did this popping and appending, so we just pop the last element from stack2 and return. 
Similarly for peek, we apply the same operations as for pop, but at last we return stack2's top 
instead of popping it
"""


cclass MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.stack1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if self.empty():
            return None
        if self.stack2:
            return self.stack2.pop()
        elif self.stack1:
            while len(self.stack1) > 1:
                temp = self.stack1.pop()
                self.stack2.append(temp)
            return self.stack1.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.empty():
            return None
        if self.stack2:
            return self.stack2[-1]
        elif self.stack1:
            while len(self.stack1) > 0:
                temp = self.stack1.pop()
                self.stack2.append(temp)
            return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if not self.stack1 and not self.stack2:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
