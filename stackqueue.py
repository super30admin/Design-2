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
        self._transfer_elements()  # Transfer elements to the output_stack if it's empty
        if self.output_stack:
            return self.output_stack.pop()
        else:
            return None


    def peek(self):
        """
        :rtype: int
        """
        self._transfer_elements()  # Transfer elements to the output_stack if it's empty
        if self.output_stack:
            return self.output_stack[-1]
        else:
            return None


    def empty(self):
        """
        :rtype: bool
        """
        return not self.input_stack and not self.output_stack

    def _transfer_elements(self):
        """
        Transfers elements from input_stack to output_stack if output_stack is empty.
        """
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())

# Example usage:
myQueue = MyQueue()
myQueue.push(1)
myQueue.push(2)
print(myQueue.peek())  # Output: 1
print(myQueue.pop())   # Output: 1
print(myQueue.empty()) # Output: False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()