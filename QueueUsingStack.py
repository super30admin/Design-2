# All test cases passed on leetcode
class MyQueue:

    # Here we initialise 2 stacks, one holds the pushed values and
    # other holds the values to be popped
    def __init__(self):
        self.inStack = []
        self.outStack = []

    # Here we push values always into inStack
    # Time complexity - O(1)
    # Space complexity - O(n)
    def push(self, x: int) -> None:
        self.inStack.append(x)

    # Here we check if outStack has any elements to pop, if not then we
    # push all inStack elements in outStack and we pop & return last element
    # of outStack
    # Time complexity - O(1) averagely but O(n) in worst case
    # Space complexity - O(n)
    def pop(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    # Here similar to pop function, we check if outStack has any elements
    # to pop, if not then we push all inStack elements in outStack and return
    # last element of outStack.
    # Time complexity - O(1)
    # Space complexity - O(n)
    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    # Time complexity - O(1)
    # Space complexity - O(n)
    # Here we check if both stacks are empty or not
    def empty(self) -> bool:
        return not self.inStack and not self.outStack

