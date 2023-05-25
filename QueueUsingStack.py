'''
Time Complexity : Push: O(1), Pop: Amortized O(1)
Space Complexity : O(n), n is number of elements in both stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
        pushing in stack1
        pop from stack2 always
        if stack2 is empty then pop elements from stack1 and push to stack2
'''

class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]
        
    def push(self, x: int) -> None:
        self.s1.append(x)
        
    def pop(self) -> int:
        if len(self.s2)==0:
            while self.s1:
                self.s2.append(self.s1.pop())
        
        ele = self.s2.pop()
        return ele

    def peek(self) -> int:
        if len(self.s2)==0:
            return self.s1[0]
        else:
            return self.s2[-1]
        

    def empty(self) -> bool:
        if len(self.s1)==0 and len(self.s2)==0:
            return True
        return False
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()