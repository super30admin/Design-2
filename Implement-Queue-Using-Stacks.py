class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    # O(1) amortized time

    def push(self, x: int) -> None:
        self.instack.append(x)

    # O(1) amortized time

    def pop(self) -> int:
        if(len(self.outstack) == 0):
            while(len(self.instack) > 0):
                temp = self.instack.pop()
                self.outstack.append(temp)
        return self.outstack.pop()

    # O(1) amortized time

    def peek(self) -> int:
        if(len(self.outstack) == 0):
            while(len(self.instack) > 0):
                temp = self.instack.pop()
                self.outstack.append(temp)
        return self.outstack[-1]

    # O(1) amortized time

    def empty(self) -> bool:
        if (len(self.instack) == 0 and len(self.outstack) == 0):
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
