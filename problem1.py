class MyQueue:

    def __init__(self):
        self.ini = []
        self.out = []

    def push(self, x: int) -> None:
        self.ini.append(x)

    def pop(self) -> int:
        if self.out: 
            popped = self.out.pop()
            return popped
        else: 
            while self.ini: 
                pop = self.ini.pop()
                self.out.append(pop)
        
        if self.out: 
            popped = self.out.pop()
            return popped
    def peek(self) -> int:
        if self.out: 
            return self.out[-1]
        else: 
            while self.ini: 
                pop = self.ini.pop()
                self.out.append(pop)
        return self.out[-1]
        

    def empty(self) -> bool:
        return not self.ini and not self.out


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
