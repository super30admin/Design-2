# Code ran in Leetcode. Used a single stack. 
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        # O(1) Time Complexity
        return self.s1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        # O(1) Time Complexity 
        return self.s1.pop(0)

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # O(1) Time Complexity 
        return self.s1[0]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        # O(1) Time Complexity 
        return not self.s1
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
