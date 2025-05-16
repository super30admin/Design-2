# Time Complexity:
#   push: O(1)
#   pop: Amortized O(1)
#   peek: Amortized O(1)
#   empty: O(1)

# Space Complexity: O(n) — where n is the number of elements in the queue

# Did this code successfully run on Leetcode: Yes

# Explanation:
# We use two stacks to simulate queue behavior.
# New elements go into in_stack. When we need to pop or peek, and out_stack is empty,
# we transfer all elements from in_stack to out_stack, reversing their order so we get FIFO behavior for pop.

class MyQueue:

    def __init__(self):
        # Stack to hold incoming elements
        self.in_stack = []
        # Stack to reverse order for popping/peeking
        self.out_stack = []

    def push(self, x: int) -> None:
        # Always push to in_stack
        self.in_stack.append(x)

    def pop(self) -> int:
        # Move from in_stack to out_stack if out_stack is empty
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        # Pop from out_stack (front of queue)
        return self.out_stack.pop()

    def peek(self) -> int:
        # Same logic as pop but return top instead of removing it
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        # Queue is empty only when both stacks are empty
        return not self.in_stack and not self.out_stack
