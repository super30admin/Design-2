        
class MyQueue:

    def __init__(self):
        self.st1 = []
        self.st2 = []
        

    def push(self, x: int) -> None:
        self.st1.append(x)

    def pop(self) -> int:
        while len(self.st1) != 0 :
            self.st2.append(self.st1.pop())
        ans =  self.st2.pop()    
        while len(self.st2) !=0:
            self.st1.append(self.st2.pop())
        return ans
        
    def peek(self) -> int:
        return self.st1[0]

    def empty(self) -> bool:
        if len(self.st1) > 0:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()