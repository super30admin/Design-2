class MyQueue:

    def __init__(self):
        self.i=[]
        self.o=[]

    def push(self, x: int) -> None:
        self.i.append(x)
    
    def help(self)  -> None:
        if not self.o:
            while self.i:
                self.o.append(self.i.pop())

    def pop(self) -> int:
        self.help()
        return self.o.pop()

    def peek(self) -> int:
        self.help()
        return self.o[-1]

    def empty(self) -> bool:
        return not self.i and not self.o


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()