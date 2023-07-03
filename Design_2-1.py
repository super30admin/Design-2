class MyQueue:

    def __init__(self):
        self.S1=[]
        self.S2=[]   

    def push(self, x: int) -> None:
        self.S1.append(x)
        
    def pop(self) -> int:
        self.peek()
        return self.S2.pop()
    
    def peek(self) -> int:
        if not self.S2:
            while self.S1:
                self.S2.append(self.S1.pop())
        return self.S2[-1]
        
    def empty(self) -> bool:
        return not self.S1 and not self.S2
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()