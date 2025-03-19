# Time Complexity : O(1) for push, O(1) for pop, O(1) for peek, O(1) for empty
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyQueue:

    def __init__(self):
        self.inSt = []
        self.outSt = []
        

    def push(self, x: int) -> None:
        self.inSt.append(x)

    def pop(self) -> int:
        if not self.outSt:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt.pop()        

    def peek(self) -> int:
        if not self.outSt:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt[-1]

    def empty(self) -> bool:
        # return max(len(self.inSt), len(self.outSt)) == 0
        return len(self.inSt) == 0 and len(self.outSt) == 0


obj = MyQueue()
obj.push(5)
obj.push(6)
obj.push(1)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()
print(param_2, param_3, param_4)