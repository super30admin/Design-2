class MyQueue:

    def __init__(self):
        self.in_stk = []
        self.out_stk = []
    

    def push(self, x: int) -> None:
        self.in_stk.append(x)   

    def pop(self) -> int:
        # pop_reverse = self.in_stk[::-1]
        if self.out_stk is None:
            while self.in_stk:
                self.out_stk.append(self.in_stk.pop())
            self.out_stk.pop()

    def peek(self) -> int:
        if self.out_stk:
            return self.out_stk[len(self.out_stk)-1]
        elif self.in_stk:
            return self.in_stk[0]
        else: return 
            

    def empty(self) -> bool:
        if self.in_stk != None and self.out_stk != None:
            return False
        else: return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()