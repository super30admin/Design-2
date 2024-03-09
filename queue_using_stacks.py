"""
Explanation: Using two stacks as mentioned in the question, Implemented them using python's list
When a pop or peek operation is asked, the elements in main stack are moved to a secondary stack
called pop_stack in reverse order and performed that operation on that second stack.
"""

class MyQueue:

    def __init__(self):
        self.main_stack = []
        self.pop_stack = []

    def push(self, x: int) -> None:
        self.main_stack.append(x)

    def pop(self) -> int:
        if not self.pop_stack:
            while self.main_stack:
                self.pop_stack.append(self.main_stack.pop())
        return self.pop_stack.pop()

    def peek(self) -> int:
        if not self.pop_stack:
            while self.main_stack:
                self.pop_stack.append(self.main_stack.pop())
        return self.pop_stack[-1]

    def empty(self) -> bool:
        return self.main_stack and self.pop_stack