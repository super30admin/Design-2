''' Time Complexity : 
        push operation - 0(1)
        pop, peek : O(1) amortized
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : 1. Maintain 2 stack, inStack and minStack, push always in inStack
              2. For pop and peek, pop elements from inStack to minStack
'''

class MyQueue:
    def __init__(self):
        self.in_stack=[]
        self.out_stack=[]
        
    def push(self, x: int) -> None:
        self.in_stack.append(x)
        
    def pop(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()
    
    def peek(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]
        
    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()