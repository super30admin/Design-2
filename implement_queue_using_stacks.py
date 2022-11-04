class MyQueue:

    def __init__(self):
        self.in_stack=[]
        self.out_stack=[]
        

    def push(self, x: int) -> None:
        self.in_stack.append(x)
        

    def pop(self) -> int:
        if self.out_stack==None:
            while(self.in_stack!=None):
                self.out_stack.push(self.in_stack.pop())
        elif self.out_stack[0]==None:
            return self.out_stack.pop()

    def peek(self) -> int:
        if self.out_stack==None:
            while(self.in_stack!=None):
                self.out_stack.push(self.in_stack.pop())
        
        return self.out_stack[-1]


    def empty(self) -> bool:
        if self.in_stack==None and self.out_stack==None:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()