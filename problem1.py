# I am adding to instack for push operations
# Whenever pop/peek happens, checking if outstack is empty, if yes transfering all elements in instack to outstack
# As the above operation will reverse the order and give the pop and peek correctly
class MyQueue:

    def __init__(self):
        self.instack=[]
        self.outstack=[]
        
    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if len(self.outstack)==0:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()
        

    def peek(self) -> int:
        if len(self.outstack)==0:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        

    def empty(self) -> bool:
        return len(self.outstack)==0 and len(self.instack)==0