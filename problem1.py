class MyQueue:

    def __init__(self):
        self.stk_in=[]
        self.stk_out=[]
        
    def push(self, x: int) -> None:
        self.stk_in.append(x)
        
    def pop(self) -> int:
        if(self.stk_out==[]):
            while(self.stk_in):
                self.stk_out.append(self.stk_in[-1])
                del(self.stk_in[-1])
        temp=self.stk_out[-1]
        del(self.stk_out[-1])
        return temp
        
    def peek(self) -> int:
        if(self.stk_out==[]):
            while(self.stk_in):
                self.stk_out.append(self.stk_in[-1])
                del(self.stk_in[-1])
        temp=self.stk_out[-1]
        #del(self.stk_out[-1])
        return temp

    def empty(self) -> bool:
        if(self.stk_in==[] and self.stk_out==[]):
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(2)
print(obj.peek())
print(obj.pop())
print(obj.empty())
        