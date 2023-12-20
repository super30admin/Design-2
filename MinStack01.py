'''
// Time Complexity : Push O(1), 
// Space Complexity : Worst O(n), Best O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, Because precourse also had similar


// Your code here along with comments explaining your approach
'''

class MinStack:

    def __init__(self):
        self.items = []

    def isEmpty(self):
        return len(self.items)==0
        
    def push(self, val: int) -> None:
        return self.items.append(val)
        
    def pop(self) -> None:
        if not self.isEmpty():
            return self.items.pop()
        else:
            print("Can't remove from empty stack.")
        
    def top(self) -> int:
        if not self.isEmpty():
            return self.items[-1]
        else:
            print("Empty stack!")
       
    def getMin(self) -> int:
        if not self.isEmpty():
            return min(self.items)
        else:
            print("Empty stack to find minimum value.")
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()