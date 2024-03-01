# Time Complexity : O(1) for all operations
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if self.outstack:
            return self.outstack.pop()
        while self.instack:
            self.outstack.append(self.instack.pop())
        return self.outstack.pop()

    def peek(self) -> int:
        if self.outstack:
            return self.outstack[-1]
        while self.instack:
            self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:
        if not self.instack and not self.outstack:
            return True
        return False
