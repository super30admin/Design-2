## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

class MyQueue:

    # We will use 2 stacks:
    # always push to the inStack
    # always pop from the outStack
    def __init__(self):
        self.inStack = []
        self.outStack = []

    # always push to the inStack
    def push(self, x: int) -> None:
        self.inStack.append(x)


    # Complexity: Best Case: O(1); Worst Case: O(n) when we need to invert the inStack
    # As Stack is LIFO and Queue is FIFO, we can't pop from the inStack
    # because top of the stack will be the last element that was added and not the first
    # and the first element is at the bottom, so we need to reverse the stack
    def pop(self) -> int:
        # we will use the outStack to reverse the inStack
        # simply pop from the inStack and add to the outStack
        # now the outStack will have the first element on top
        if len(self.outStack) == 0:
            while len(self.inStack):
                self.outStack.append(self.inStack.pop())
        
        # outStack will always have the elements in FIFO order
        # so always pop from here
        return self.outStack.pop()

    # Complexity: O(1)
    def peek(self) -> int:
        if len(self.outStack): # always peek from top of outStack
            return self.outStack[-1]
        else: # but if the outStack is empty, return the 1st element in the inStack
            return self.inStack[0]

    # simply check if both the stacks are empty
    # Complexity: O(1)
    def empty(self) -> bool:
        return len(self.outStack) == 0 and len(self.inStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()