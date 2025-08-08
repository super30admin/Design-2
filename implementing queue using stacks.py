#Implementing Queue using two stacks
# 1st stack is input stack and 2nd stack is output stack
# we will be working on these both stacks to implement queues
class MyQueue:

    def __init__(self):
        self.inst = []
        self.outst = []

    def push(self, x: int) -> None:
        self.inst.append(x)        

    def pop(self) -> int:
        if self.empty():
            return -1
        self.peek()
        return self.outst.pop()

    def peek(self) -> int:
        if not self.outst:
            while self.inst:
                self.outst.append(self.inst.pop())
        return self.outst[-1]        

    def empty(self) -> bool:
        return not self.inst and not self.outst