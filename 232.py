# use one stack(in) to append to stack and,
# another stack(out) which will pull elements in the reverse order from in-stack
# to simulate FIFO when popping
# Time - O(1)
# Space - O(n)
class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)

    def ensureOutStack(self):
        if len(self.outstack) != 0:
            return
        while len(self.instack)!=0:
            self.outstack.append(self.instack.pop())

    def pop(self) -> int:
        self.ensureOutStack()
        return None if len(self.outstack)==0 else self.outstack.pop()

    def peek(self) -> int:
        self.ensureOutStack()
        return None if len(self.outstack)==0 else self.outstack[-1]

    def empty(self) -> bool:
        return len(self.instack) == len(self.outstack) == 0

