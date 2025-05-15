""" 
Time Complexity: 
 - push: O(1)
 - pop: amortized O(1)
 - peek: O(1)
 - empty: O(1) 
 
Space Complexity:
 - push: O(n)
 - pop: O(1)
 - peek: O(1)
 - empty: O(1)  
 
 Approach:
    - Use two stacks to store the data
    - When pushing, push the data to the in_stack
    - When popping, pop the data from the out_stack if no data present in the out_stack, reverse the in_stack and push the data to the out_stack and then pop from the out_stack
    - When peeking, pop the data from the out_stack if no data present, return the first element of in_stack
    - When empty, reverse the in_stack and push the data to the out_stack
"""


class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []
        

    def push(self, x: int) -> None:
        self.in_stack.append(x)
        
    def pop(self) -> int:
        if len(self.out_stack)==0:
            for x in self.in_stack[::-1]:
                self.out_stack.append(x)
            self.in_stack = [] 
        return self.out_stack.pop()
        
    def peek(self) -> int:
        if len(self.out_stack)==0:
            return self.in_stack[0]
        return self.out_stack[-1]
        
    def empty(self) -> bool:
        return len(self.in_stack)==len(self.out_stack)==0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()