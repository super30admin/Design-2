# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# Approach: 1. Initialize two stacks and for all push operations add the new elements to the inStack
#           2. In the pop function, we first check if the stacks are empty to avoid Null exceptions, and then use the peek function logic to transfer all the items from inStack to outStack so the outStack starts functioning like FIFO. This lets us peek at the top element by accessing the last index of the outStack.
#           3. At the end of the pop function, we just pop out the top element from the outStack since after the peek function outStack has the same structure like a Queue and follows FIFO

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if self.empty():
            return -1
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        return not self.inStack and not self.outStack

commands = ["MyQueue", "push", "push", "peek", "pop", "empty"]
arguments = [[], [1], [2], [], [], []]

output = []
obj = None

for cmd, args in zip(commands, arguments):
    if cmd == "MyQueue":
        obj = MyQueue()
        output.append(None)
    elif cmd == "push":
        output.append(obj.push(args[0]))
    elif cmd == "pop":
        output.append(obj.pop())
    elif cmd == "peek":
        output.append(obj.peek())
    elif cmd == "empty":
        output.append(obj.empty())

print("Output:", output)