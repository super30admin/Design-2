class MyQueue:
    # Time Complexity: O(1)
    # Space Complexity: O(n)
    # Leetcode: Successfully runs
    # No issues

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        # Push element into inStack
        self.inStack.append(x)

    def pop(self) -> int:
        # If outStack is empty, move all elements from inStack to outStack
        # This reverses the order so the oldest element is on top
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        # If outStack is empty, move all elements from inStack to outStack
        # This reverses the order so the oldest element is on top
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        # view top element
        return self.outStack[-1]

    def empty(self) -> bool:
        # Queue is empty only if both stacks are empty
        return not self.inStack and not self.outStack
