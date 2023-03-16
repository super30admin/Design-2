class MyQueue:

    def __init__(self):
        self.frontstack=[]
        self.backstack=[]

    def push(self, x: int) -> None:
        self.backstack.append(x)

    def pop(self) -> int:
        if not self.frontstack:
            while (self.backstack):
                self.frontstack.append(self.backstack.pop())
        popped=self.frontstack[-1]
        del self.frontstack[-1]
        return popped

    def peek(self) -> int:
        if not self.frontstack:
            while(self.backstack):
                self.frontstack.append(self.backstack.pop())
        return self.frontstack[-1]

    def empty(self) -> bool:
        if len(self.frontstack)==0 and len(self.backstack)==0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()