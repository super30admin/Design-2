# Author : Akaash Trivedi
# Push
# Time Complexity : O(n)
# Space Complexity : O(n)
# Pop, peek
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes #232
# Any problem you faced while coding this : No

# Implement Queue using Stacks

class MyQueue:

    def __init__(self):
        self.mainStack = []
        self.extraStack = []

    def push(self, x: int) -> None:
        while self.mainStack:
            self.extraStack.append(self.mainStack.pop())
        self.mainStack.append(x)
        while self.extraStack:
            self.mainStack.append(self.extraStack.pop())

    def pop(self) -> int:
        return self.mainStack.pop()

    def peek(self) -> int:
        return self.mainStack[-1]

    def empty(self) -> bool:
        return not self.mainStack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()