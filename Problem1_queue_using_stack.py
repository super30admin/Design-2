# // Time Complexity : for push & empty = O(1), pop, peek =  O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.outArr = []
        self.inArr = []
        

    def push(self, x: int) -> None:
        self.inArr.append(x)
        

    def pop(self) -> int:
        if len(self.outArr) == 0:
            #push from in to out
            for i in range(len(self.inArr)):
                self.outArr.append(self.inArr.pop())
        return self.outArr.pop()
                
    def peek(self) -> int:
        print("here")
        if len(self.outArr) == 0:
            #push from in to out
            for i in range(len(self.inArr)):
                self.outArr.append(self.inArr.pop())
        val = self.outArr[-1]
        return val
        
    def empty(self) -> bool:
        if len(self.outArr) == 0 and len(self.inArr) == 0:
            return True
        else:
            return False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()