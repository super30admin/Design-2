class MyQueue:
    def __init__(self):
        self.ins = []
        self.outs = []

    def push(self, x: int) -> None:
        self.ins.append(x)
        return

    def peek(self) -> int:
        if len(self.outs) == 0:
            while len(self.ins) != 0:
                self.outs.append(self.ins.pop(0))
            return self.outs[0]
        return self.outs[0]

    def pop(self) -> int:
        self.peek()
        return self.outs.pop(0)

    def empty(self) -> bool:
        if len(self.ins) == 0 and len(self.outs) == 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()
