#Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this :no



class MyQueue:

    def __init__(self):
        # Initialize two stacks, one for input and one for output
        self.input = []  # Stack to simulate the input side of the queue
        self.output = []  # Stack to simulate the output side of the queue

    def push(self, x: int) -> None:
        # Add the element 'x' to the input stack
        self.input.append(x)

    def pop(self) -> int:
        # Ensure the output stack is up-to-date
        self.peek()
        # Pop and return the top element from the output stack
        return self.output.pop()

    def peek(self) -> int:
        # If the output stack is empty, update it by popping all elements from the input stack and pushing them to the output stack
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        # Return the front element (top) of the output stack without popping it
        return self.output[-1]

    def empty(self) -> bool:
        # The queue is empty if both the input and output stacks are empty
        return not self.input and not self.output
