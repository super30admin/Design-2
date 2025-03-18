# // Time Complexity :O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes 
# // Any problem you faced while coding this :No 


class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)
        

    def pop(self) -> int:
        if len(self.out_stack) == 0:
            while len(self.in_stack):
                temp  = self.in_stack.pop()
                self.out_stack.append(temp) 
        return self.out_stack.pop()

    def peek(self) -> int:
        if len(self.out_stack) == 0:
            while len(self.in_stack):
                temp  = self.in_stack.pop()
                self.out_stack.append(temp)
        return self.out_stack[-1]

    def empty(self) -> bool:
        return not len(self.out_stack) and not len(self.in_stack)
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()