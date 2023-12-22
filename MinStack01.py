'''
// Time Complexity : All operations O(1) except when the outstack is empty and instack is not during pop or peek operation 
// Space Complexity : Worst O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
I have 2 stacks, one is instack and other one is outstack. Instack is for input values during pushes. During peek or pop when 
outStack is empty but instack is not, values would be transferred from in to out and at the end operation would be done
on final value of outstack which would be first value of queue.
'''

class MinStack:

    def __init__(self):
        self.items = []
        self.minitems = []
        
    def push(self, val: int) -> None:
        self.items.append(val)
        if self.minitems:
            self.minitems.append(min(val, self.minitems[-1]))
        else:
            self.minitems.append(val)
        
    def pop(self) -> None:
        self.items.pop()
        self.minitems.pop()
        
    def top(self) -> int:
        return self.items[-1]
       
    def getMin(self) -> int:
        return self.minitems[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()