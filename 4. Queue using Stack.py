class MyQueue:

    def __init__(self):
        # Initialize two stacks
        self.in_stack = []   # Stack to handle incoming elements
        self.out_stack = []  # Stack to handle outgoing elements

    def push(self, x: int) -> None:
        # Always push the new element into in_stack
        self.in_stack.append(x)

    def pop(self) -> int:
        # If out_stack is empty, move all elements from in_stack
        if not self.out_stack:
            while self.in_stack:
                # Transfer from in_stack to out_stack to reverse order
                self.out_stack.append(self.in_stack.pop())
        # Pop from out_stack, which represents the front of the queue
        return self.out_stack.pop()

    def peek(self) -> int:
        # If out_stack is empty, move elements from in_stack
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        # Return the top of out_stack (front of the queue)
        return self.out_stack[-1]

    def empty(self) -> bool:
        # Queue is empty if both stacks are empty
        return not self.in_stack and not self.out_stack

# TC: O(1) for push, O(n) for pop and peek in the worst case when transferring elements
# SC: O(n) for storing elements in both the stacks