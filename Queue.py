# Time Complexity : push, isEmpty-O(1), pop, peek-O(n)(worstcase),-O(1)(avg case)
# Space Complexity :O(2n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
#Initialized two arrays one to store the original order and the other to extract the 1st element when needed for pop and peek

class MyQueue:

    def __init__(self):
        self.inSt = []
        self.outSt = []
        

    def push(self, x: int) -> None:
        self.inSt.append(x)
        

    def pop(self) -> int:
        if len(self.outSt) == 0:
            while(self.inSt):
                self.outSt.append(self.inSt.pop())
        return self.outSt.pop()
        

    def peek(self) -> int:
        if len(self.outSt) == 0:
            while(self.inSt):
                self.outSt.append(self.inSt.pop())
        return self.outSt[-1]
        

    def empty(self) -> bool:
        return len(self.outSt) == 0 and len(self.inSt) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()