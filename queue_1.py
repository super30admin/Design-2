# take 2 list 
# inlist for push orperation, outlist for pop and peek
# for pop and peek check whether outlist empty if so then move inlist values to outlist and return [-1] index value

class MyQueue:

    def __init__(self):
        self.inList = []
        self.outList = []

    def push(self, x: int) -> None:
        self.inList.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outList.pop()

    def peek(self) -> int:
        if len(self.outList) == 0:
            while len(self.inList) != 0:
                self.outList.append(self.inList.pop())
        
        return self.outList[-1]

    def empty(self) -> bool:
        return not len(self.inList)  and not len(self.outList)