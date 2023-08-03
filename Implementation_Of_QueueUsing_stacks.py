class MyQueue:

    def __init__(self):
        self.st1 = list()
        self.st2 = list()

    def push(self, x: int) -> None:
        self.st1.append(x)
        

    def pop(self) -> int:
        if not self.st2:
            if self.st1:
                while self.st1:
                    self.st2.append(self.st1.pop())
            else:
                return -1

        return self.st2.pop()


    def peek(self) -> int:
        if not self.st2:
            if self.st1:
                while self.st1:
                    self.st2.append(self.st1.pop())
            else:
                return -1
        
        return self.st2[-1]

    def empty(self) -> bool:
        if  (self.st2 or self.st1):
            return False
        else:
            return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()