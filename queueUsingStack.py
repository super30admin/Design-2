# Use 2 lists to simulate 2 stacks. inStack is used to push elements. outStack is used to pop elements
# When outStack is empty, we pop all elements from inStack and push them to outStack
# This way, the order of elements is reversed and we can get the front element of the queue from the top of outStack
class MyQueue:
    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0