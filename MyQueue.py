# Time Complexity: O(1) amortized for all the methods
# Space Complexity: O(n), n is the no.of elements in the stack
# Did this code successfully run on Leetcode: Yes

# Your code here along with comments explaining your approach
# I have used two stacks, one for adding elements to the queue and another one for removing elements from the queue

class MyQueue(object):

    def __init__(self):
        self.stack_1 = []
        self.stack_2 = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack_1.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if len(self.stack_2):
            return self.stack_2.pop()
        else:
            while len(self.stack_1) > 0:
                self.stack_2.append(self.stack_1.pop())

            return self.stack_2.pop()


    def peek(self):
        """
        :rtype: int
        """
        if len(self.stack_2):
            return self.stack_2[-1]
        else:
            return self.stack_1[0]
        

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.stack_1) == 0 and len(self.stack_2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()