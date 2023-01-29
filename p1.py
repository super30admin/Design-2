#python doesnt have peek() and isEmpty()
class MyQueue:

    def __init__(self):
        self.s1 = [] #in stack
        self.s2 = [] #out stack
       
    def push(self, x: int) -> None:
        self.s1.append(x)
        
        
    def pop(self) -> int:
       if not self.s2: # s2 is empty
            #shift all the items in s1 to s2
            while self.s1:
                self.s2.append(self.s1.pop())
       return self.s2.pop()
        

    def peek(self) -> int:
        if not self.s2: # s2 is empty
            #shift all the items in s1 to s2
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
        

    def empty(self) -> bool:
            return (not self.s1) and (not self.s2)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()