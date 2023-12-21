# Time Complexity : O(1) for all operations except pop and peek this is amortized O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# we utilize two stack where we are inseting into our delte stack by rmoving in reverse order from our add stack which will populate the delete stack in the expected queue format 

class MyQueue:

    def __init__(self):
        self.addStack = []
        self.deleteStack = []
    def push(self, x: int) -> None:
        self.addStack.append(x)

    def pop(self) -> int:
        self.copyElements()
        return self.deleteStack.pop()

    def peek(self) -> int:
        self.copyElements()
        return self.deleteStack[-1]

    def empty(self) -> bool:
        return not self.addStack and not self.deleteStack
    def copyElements(self):
        if not self.deleteStack:
            while self.addStack:
                self.deleteStack.append(self.addStack.pop())

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()