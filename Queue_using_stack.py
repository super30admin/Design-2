class MyQueue:

    def __init__(self):
        self.q = []
        self.outq=[]

    def push(self, x: int) -> None:
        self.q.append(x)
        print(self.q)

    def copy(self):
        for x in range(0,len(self.q)):
            self.outq.append(self.q.pop())
            print('!')
            print(x)
        print(self.outq)

    def pop(self) -> int:
        # return self.q.pop(0)
        if(len(self.outq) == 0):
            self.copy()
        return self.outq.pop()
            


    def peek(self) -> int:
        #return self.q[0]
        if(len(self.outq) == 0):
            self.copy()
        return self.outq[-1]


    def empty(self) -> bool:
        return (len(self.q) == 0 and len(self.outq) == 0)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()