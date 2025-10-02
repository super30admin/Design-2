# Time Complexity : O(1) for push, pop, peek, empty because the underlying operations (append, pop, len) are O(1).
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Visualizing the problem with in and out stacks is much easier for transferring elements.

class MyQueue:

    def __init__(self):
        # When elements are pushed they always go in inStack
        # When pop/peek, we rehydrate the outStack as needed.
        # Time is O(n) only in this case.
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if self.outStack == []:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        if self.outStack == []:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()