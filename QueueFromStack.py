class MyQueue:

    def __init__(self):
        self.list_push = []
        self.list_pop = []
        

    def push(self, x: int) -> None:
        if len(self.list_pop) > 0 :
            for i in range(len(self.list_pop)):
                val = self.list_pop.pop()
                self.list_push.append(val)
        self.list_push.append(x)
        

    def pop(self) -> int:
        if len(self.list_push) > 0 :
            for i in range(len(self.list_push)):
                val = self.list_push.pop()
                self.list_pop.append(val)
        return self.list_pop.pop()
        

    def peek(self) -> int:
        if len(self.list_pop) > 0:
            return self.list_pop[-1]
        elif len(self.list_push) > 0:
            return self.list_push[0]

    def empty(self) -> bool:
        if len(self.list_pop) == 0 and len(self.list_push) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()