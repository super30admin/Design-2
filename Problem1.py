# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        self.stin = []
        self.stout = []

    def push(self, x: int) -> None:
        self.stin.append(x)

    def pop(self) -> int:
        if not self.stout:
            while self.stin:
                self.stout.append(self.stin.pop())
        return self.stout.pop()

    def peek(self) -> int:
        if not self.stout:
            while(self.stin):
                self.stout.append(self.stin.pop())
        return self.stout[-1]
        
    def empty(self) -> bool:
        return not self.stin and not self.stout
        


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(10)
obj.push(6)
obj.push(5)
obj.push(11)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()