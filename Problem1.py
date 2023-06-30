// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Implemented the logic using 2 stacks. When popped, pop all elements and add it to auxiliary stack. 

class MyQueue:

    def __init__(self):
        self.org_stack=[]
        self.aux_stack=[]

    def push(self, x: int) -> None:
        self.org_stack.append(x)

    def pop(self) -> int:
        if len(self.aux_stack) == 0:
            while len(self.org_stack)>0:
                self.aux_stack.append(self.org_stack.pop())

        return self.aux_stack.pop()

    def peek(self) -> int:
        if len(self.aux_stack) > 0:
            return self.aux_stack[-1]

        return self.org_stack[0]

    def empty(self) -> bool:
        if len(self.org_stack)>0 or len(self.aux_stack)>0:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()