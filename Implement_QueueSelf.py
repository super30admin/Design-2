#Time Complexity: O(1) operations
#Space Complexity: O(n) stacks

#Approach:
# Created two stacks: namely input and output.
# Input stack is used to elements during push operations
# Output stack is used for pop and peek operations to retrieve the toppmost element.

class MyQueue(object):

    def __init__(self):
        self.ip_stack = []
        self.op_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.ip_stack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if self.op_stack == None:
            while(self.ip_stack):
                self.op_stack.append(self.ip_stack.pop())
            
        return self.op_stack.pop()


    def peek(self):
        """
        :rtype: int
        """
        if not self.op_stack:
            while(self.ip_stack):
                self.op_stack.append(self.ip_stack.pop())

        return self.op_stack[-1]


    def empty(self):
        """
        :rtype: bool
        """
        if len(self.ip_stack) == 0 and (self.op_stack) == 0:
            return True
        else:
            return False 
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()