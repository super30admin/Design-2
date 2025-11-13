# leetcode username: shreyagoyal06
# Time complexities- push: O(1); pop: O(n) worst case, O(1) best case; peek(): O(n) worst case, O(1) best case; empty():O(1)
# Initialized two stacks: one for adding values, and the other stack for copying to and popping in a queue format. 

class MyQueue(object):

    def __init__(self):
        self.input_stack = []
        self.output_stack = []
          

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.input_stack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
        return self.output_stack.pop()

    def peek(self):
        """
        :rtype: int
        """
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
        return self.output_stack[-1]
        
        

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.input_stack) == 0 and len(self.output_stack) == 0

