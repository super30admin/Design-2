class MyQueue:

    def __init__(self):
        self.inst=[]
        self.otst=[]
        

    def push(self, x: int) -> None:
        self.inst.append(x)
        

    def pop(self) -> int:
        if self.empty():
            return -1
        self.peek()
        return self.otst.pop()
        

    def peek(self) -> int:
        if self.empty():
            return -1
        if len(self.otst)==0:
            while len(self.inst)!=0:
                self.otst.append(self.inst.pop())
        return self.otst[-1]
        

    def empty(self) -> bool:
        if len(self.inst)==0 and len(self.otst)==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()