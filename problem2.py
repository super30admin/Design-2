class MyQueue:

    def __init__(self):
        self.master = []
        self.slave = []    

    def push(self, x: int) -> None:
        while len(self.master):
            top = self.master.pop()
            self.slave.append(top)
        self.master.append(x)
        while len(self.slave):
            top = self.slave.pop()
            self.master.append(top)
        

    def pop(self) -> int:
        return self.master.pop()
        

    def peek(self) -> int:
        return self.master[-1]
        

    def empty(self) -> bool:
        return not len(self.master)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()