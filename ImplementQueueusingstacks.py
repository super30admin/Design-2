# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 25/31 cases passed initially then fixed it 


# Approach is to create a list and append, pop, peek the value in the list.

class MyQueue:

    def __init__(self):
        self.l=[]    

    def push(self, x: int) -> None:
        self.l.append(x)
        

    def pop(self) -> int:
        val=self.l[0]
        self.l=self.l[1:]
        return val

    def peek(self) -> int:
        return self.l[0]

    def empty(self) -> bool:
        if (self.l == []):
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()