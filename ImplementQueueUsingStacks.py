
"""
I have used approahes
1) On push I swap all elements to s2 and again swap back to s1
2) I swap when I get  pop or peek request
"""


class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    # Approach one

    def push(self, x: int) -> None:
        while self.s1:
            self.s2.append(self.s1.pop(-1))
        self.s1.append(x)
        while self.s2:
            self.s1.append(self.s2.pop(-1))

    def pop(self) -> int:
        return self.s1.pop(-1)

    def peek(self) -> int:
        return self.s1[-1]

    def empty(self) -> bool:
        if self.s1:
            return False
        return True

###################################################################################

    # Approach two
    def transfer(self):
        while self.s1:
            self.s2.append(self.s1.pop(-1))

    def push1(self, x: int) -> None:
        self.s1.append(x)

    def pop1(self) -> int:
        if not self.s2:
            self.transfer()
        return self.s2.pop(-1)

    def peek1(self) -> int:
        if not self.s2:
            self.transfer()
        return self.s2[-1]

    def empty1(self) -> bool:
        if self.s1 or self.s2:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
