class MyQueue:

    def __init__(self):
        self.in1 = []
        self.out = []
        

    def push(self, x: int) -> None:
        self.in1.append(x)
        

    def pop(self) -> int:
        if not self.out:
            while self.in1:
                self.out.append(self.in1.pop())
        return self.out.pop()
        
    def peek(self) -> int:
        if not self.out:
            while self.in1:
                self.out.append(self.in1.pop())
        return self.out[-1]

    def empty(self) -> bool:
        return not self.in1 and not self.out


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
