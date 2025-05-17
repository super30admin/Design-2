#approach is to use two stacks and consider them as one
#we can start with putting in all elemenets into first or in stack
# as soon as we see a pop() we can start filling out stack by poping from in-stack
# we also check if out stack is empty before we do that is not just pop from out stack
# time complexity - push O(1) pop() is amortized O(n) peek same as pop and empty O(1)
# space O(n)


class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        return not self.inStack and not self.outStack
