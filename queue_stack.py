# Time Complexity : Push - O(1), Pop - Amortized O(1), Empty - O(1), Peek - O(1)
# Space Complexity : Push - O(n), Pop - O(1), Empty - O(1), Peek - O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []
        self.front = None

    def push(self, x: int) -> None:
        if not self.s1:
            self.front = x
        self.s1.append(x)

    def pop(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()

    def peek(self) -> int:
        if self.s2:
            return self.s2[-1]
        return self.front

    def empty(self) -> bool:
        return not self.s1 and not self.s2


