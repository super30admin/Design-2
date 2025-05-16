
"""
This implementation uses two stacks: input_stack for push operations and output_stack for pop, peek, and empty operations. 
When popping or peeking, we transfer elements from input_stack to output_stack if output_stack is empty, ensuring the queue order is maintained. 
All operations run in O(1) time on average due to amortized analysis.
"""

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.input_stack = []
        self.output_stack = []

    def push(self, x: int) -> None:
        # Simply push to input stack
        self.input_stack.append(x)

    def pop(self) -> int:
        # If output stack is empty, transfer all elements from input stack
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
        # Pop from output stack
        return self.output_stack.pop()

    def peek(self) -> int:
        # If output stack is empty, transfer all elements from input stack
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
        # Return top of output stack without removing it
        return self.output_stack[-1]

    def empty(self) -> bool:
        # Queue is empty if both stacks are empty
        return not self.input_stack and not self.output_stack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()