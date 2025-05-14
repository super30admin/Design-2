# // Time Complexity :
  # pop is O(n),rest all are O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# Using List as stack and using ocunt variable 
# https://leetcode.com/problems/implement-queue-using-stacks/description/
class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]
        self.str_idx=0
        self.length=0

    def push(self, x: int) -> None:
        self.s1.append(x)
        self.length+=1
        return None
        

    def pop(self) -> int:
        self.length-=1
        return self.s1.pop(0)

        

    def peek(self) -> int:
        if self.length>0:
            return self.s1[0]
        return None
        

    def empty(self) -> bool:
        return  self.length==0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
