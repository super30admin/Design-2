class MyQueue:

    def __init__(self):
        self.inSt=[]
        self.outSt=[]

    def push(self, x: int) -> None:
        self.inSt.append(x)
        
    def pop(self) -> int:
        if len(self.outSt)==0:
            while len(self.inSt)>0:
                self.outSt.append(self.inSt.pop())
        return self.outSt.pop()
        

    def peek(self) -> int:
        if len(self.outSt)==0:
            while len(self.inSt)>0:
                self.outSt.append(self.inSt.pop())
        return self.outSt[len(self.outSt)-1] 

        

    def empty(self) -> bool:
        if len(self.inSt)==0 and len(self.outSt)==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()